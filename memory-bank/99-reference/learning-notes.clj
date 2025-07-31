;; Learning Notes and Tips for Clojure
;; A collection of insights, gotchas, and best practices

;; ===============================
;; MINDSET SHIFTS
;; ===============================

;; 1. From Objects to Data
;; - Think in terms of data transformation, not object manipulation
;; - Data structures are the primary abstraction
;; - Functions transform data from one shape to another

;; 2. From Imperative to Functional
;; - Instead of: "How do I change this?"
;; - Think: "How do I create a new version with the changes?"
;; - Embrace immutability and pure functions

;; 3. From Control Flow to Data Flow
;; - Use sequence operations instead of loops
;; - Chain transformations with threading macros
;; - Think in terms of pipelines

;; ===============================
;; COMMON GOTCHAS
;; ===============================

;; 1. Lists vs Vectors
;; Lists are for sequential access, vectors for random access
(def my-list '(1 2 3))    ; Good for: cons, first, rest
(def my-vector [1 2 3])   ; Good for: get, assoc, conj at end

;; conj behaves differently!
(conj '(1 2 3) 4)  ; => (4 1 2 3) - adds to front
(conj [1 2 3] 4)   ; => [1 2 3 4] - adds to end

;; 2. Lazy Sequences
;; Many functions return lazy sequences
(def lazy-result (map println [1 2 3]))  ; Nothing printed yet!
(doall lazy-result)  ; Force evaluation, now it prints

;; Use doall when you need side effects to happen
(doall (map #(spit (str "file" % ".txt") %) [1 2 3]))

;; 3. nil vs false vs empty
(if nil "truthy" "falsy")        ; => "falsy"
(if false "truthy" "falsy")      ; => "falsy"
(if [] "truthy" "falsy")         ; => "truthy" (empty vector is truthy!)
(if '() "truthy" "falsy")        ; => "truthy" (empty list is truthy!)

;; Use empty? to check for empty collections
(empty? [])    ; => true
(empty? '())   ; => true
(empty? nil)   ; => true

;; 4. Keywords vs Strings
;; Keywords are more efficient for map keys
{:name "Alice"}     ; Preferred
{"name" "Alice"}    ; Less efficient

;; Keywords can be used as functions
(:name {:name "Alice"})  ; => "Alice"
("name" {"name" "Alice"}) ; This won't work!

;; ===============================
;; PERFORMANCE TIPS
;; ===============================

;; 1. Use Appropriate Data Structures
;; - Vector: random access, adding to end
;; - List: sequential access, adding to front
;; - Map: key-value lookup
;; - Set: membership testing

;; 2. Avoid Reflection
(set! *warn-on-reflection* true)

;; Bad: causes reflection
(defn string-length [s]
  (.length s))

;; Good: type hint eliminates reflection
(defn string-length [^String s]
  (.length s))

;; 3. Use Transients for Bulk Operations
;; When building large collections incrementally
(defn build-vector-slow [n]
  (loop [i 0 v []]
    (if (< i n)
      (recur (inc i) (conj v i))
      v)))

(defn build-vector-fast [n]
  (loop [i 0 v (transient [])]
    (if (< i n)
      (recur (inc i) (conj! v i))
      (persistent! v))))

;; 4. Prefer reduce over loop/recur
;; reduce is often more idiomatic and sometimes faster
(defn sum-loop [numbers]
  (loop [nums numbers acc 0]
    (if (empty? nums)
      acc
      (recur (rest nums) (+ acc (first nums))))))

(defn sum-reduce [numbers]
  (reduce + numbers))  ; Much simpler!

;; ===============================
;; DEBUGGING STRATEGIES
;; ===============================

;; 1. Use the REPL
;; Develop incrementally, test each step
(def test-data [1 2 3 4 5])
(map inc test-data)  ; Test transformation
(filter even? (map inc test-data))  ; Add filter
(->> test-data (map inc) (filter even?))  ; Chain operations

;; 2. Add println for debugging
(defn debug-pipeline [data]
  (->> data
       (map inc)
       (#(do (println "After inc:" %) %))  ; Debug print
       (filter even?)
       (#(do (println "After filter:" %) %))))

;; 3. Use -> and ->> for clarity
;; Instead of deeply nested expressions
(reduce + (filter even? (map #(* % %) [1 2 3 4 5])))

;; Use threading:
(->> [1 2 3 4 5]
     (map #(* % %))
     (filter even?)
     (reduce +))

;; ===============================
;; COMMON PATTERNS
;; ===============================

;; 1. Data Transformation Pipeline
(->> data
     (map transform-fn)
     (filter predicate-fn)
     (group-by category-fn)
     (into {}))

;; 2. Error Handling with nil
(defn safe-get [m k]
  (when m
    (get m k)))

;; Chain safely with some->
(some-> user :profile :address :city)

;; 3. Configuration Maps
(def config
  {:database {:host "localhost"
              :port 5432
              :name "myapp"}
   :server   {:port 8080
              :threads 10}})

(get-in config [:database :host])  ; => "localhost"

;; 4. Protocol-based Polymorphism
(defprotocol Drawable
  (draw [this]))

(defrecord Circle [radius]
  Drawable
  (draw [this] (str "Drawing circle with radius " radius)))

;; ===============================
;; TESTING STRATEGIES
;; ===============================

;; 1. Test Pure Functions
(defn add [a b] (+ a b))

(deftest test-add
  (is (= 5 (add 2 3)))
  (is (= 0 (add -2 2))))

;; 2. Use Fixtures for Setup/Teardown
(use-fixtures :each
  (fn [test-fn]
    (println "Setting up test")
    (test-fn)
    (println "Tearing down test")))

;; 3. Property-Based Testing
(require '[clojure.test.check.generators :as gen]
         '[clojure.test.check.properties :as prop])

(def add-commutative
  (prop/for-all [a gen/int
                 b gen/int]
    (= (+ a b) (+ b a))))

;; ===============================
;; CODE ORGANIZATION
;; ===============================

;; 1. Namespace Organization
;; my-app.core          - main entry point
;; my-app.config        - configuration
;; my-app.db            - database operations
;; my-app.handlers      - request handlers
;; my-app.utils.string  - string utilities
;; my-app.utils.date    - date utilities

;; 2. Keep Functions Small
;; Prefer many small functions over few large ones
(defn validate-user [user]
  (and (valid-email? (:email user))
       (valid-age? (:age user))
       (valid-name? (:name user))))

;; 3. Use Descriptive Names
;; Good
(defn calculate-monthly-payment [principal rate term])

;; Bad
(defn calc [p r t])

;; ===============================
;; MEMORY AIDS
;; ===============================

;; Remember these key concepts:
;; 1. Data is immutable by default
;; 2. Functions are first-class values
;; 3. Code is data (homoiconicity)
;; 4. Prefer pure functions
;; 5. Use the sequence abstraction
;; 6. Embrace the REPL workflow
;; 7. Think in terms of data transformation
;; 8. Leverage the rich standard library
;; 9. Use appropriate data structures
;; 10. Handle nil gracefully

;; Common beginner mistakes to avoid:
;; - Overusing atoms and refs (prefer pure functions)
;; - Not understanding lazy evaluation
;; - Using the wrong collection type
;; - Fighting immutability instead of embracing it
;; - Not using the REPL effectively
;; - Trying to write imperative code in functional style
