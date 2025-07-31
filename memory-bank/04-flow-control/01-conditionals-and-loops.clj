;; Flow Control in Clojure
;; Clojure provides several forms for controlling program flow

;; 1. CONDITIONAL EXPRESSIONS

;; if - basic conditional (returns a value)
(if (> 5 3)
  "5 is greater than 3"    ; then branch
  "5 is not greater than 3") ; else branch
; => "5 is greater than 3"

;; if without else returns nil for false condition
(if false "won't see this")  ; => nil

;; Multiple expressions in if branches require do
(if (even? 4)
  (do
    (println "4 is even")
    "even number")
  (do
    (println "4 is odd")
    "odd number"))

;; when - if without else, implicit do
(when (pos? 5)
  (println "Positive number")
  (println "Processing...")
  (* 5 2))  ; => 10

;; when-not - when condition is false
(when-not (empty? [1 2 3])
  (println "Vector is not empty")
  "has elements")

;; if-let - bind and test in one form
(if-let [result (seq [1 2 3])]
  (str "First element: " (first result))
  "Empty sequence")

;; when-let - when + let combination
(when-let [user {:name "Alice" :age 30}]
  (str "User: " (:name user)))

;; 2. CASE EXPRESSIONS

;; case - efficient multi-way branching (like switch)
(defn describe-number [n]
  (case n
    1 "one"
    2 "two"
    3 "three"
    4 "four"
    5 "five"
    "other number"))  ; default case

(describe-number 3)  ; => "three"
(describe-number 7)  ; => "other number"

;; case with multiple values per branch
(defn number-type [n]
  (case n
    (1 3 5 7 9) "odd single digit"
    (2 4 6 8)   "even single digit"
    0           "zero"
    "other"))

;; 3. COND - GENERAL CONDITIONAL

;; cond - multiple condition-expression pairs
(defn grade-letter [score]
  (cond
    (>= score 90) "A"
    (>= score 80) "B"
    (>= score 70) "C"
    (>= score 60) "D"
    :else         "F"))  ; :else is just a truthy value

(grade-letter 85)  ; => "B"

;; cond-> and cond->> - conditional threading
(cond-> 1        ; start with 1
  true    inc    ; 1 -> 2 (always true)
  false   (* 42) ; skipped (condition false)
  (> 2 1) (* 3)) ; 2 -> 6 (condition true)
; => 6

;; 4. CONDP - CONDITION WITH PREDICATE

;; condp - test value against predicate
(defn describe-collection [coll]
  (condp instance? coll
    java.util.List "It's a list"
    java.util.Set  "It's a set"
    java.util.Map  "It's a map"
    "Unknown collection type"))

;; condp with comparison
(defn number-range [n]
  (condp < n  ; predicate is <, value is n
    0   "negative"
    10  "small positive"
    100 "medium positive"
    "large positive"))

;; 5. LOOPS AND ITERATION

;; loop/recur - explicit iteration (tail recursive)
(defn sum-to-n [n]
  (loop [i 1
         sum 0]
    (if (> i n)
      sum
      (recur (inc i) (+ sum i)))))

(sum-to-n 5)  ; => 15

;; while - condition-based loop (rare in Clojure)
(let [counter (atom 0)]
  (while (< @counter 3)
    (println "Count:" @counter)
    (swap! counter inc)))

;; 6. EXCEPTION HANDLING

;; try/catch/finally
(defn safe-divide [x y]
  (try
    (/ x y)
    (catch ArithmeticException e
      (println "Cannot divide by zero!")
      :error)
    (catch Exception e
      (println "Unknown error:" (.getMessage e))
      :error)
    (finally
      (println "Division attempt completed"))))

(safe-divide 10 0)  ; prints message, returns :error

;; try without catch (just finally)
(try
  (println "Doing something...")
  "result"
  (finally
    (println "Cleanup")))

;; 7. SEQUENCE ITERATION PATTERNS

;; doseq - iterate for side effects
(doseq [x [1 2 3]
        y [:a :b]]
  (println x y))
; Prints: 1 :a, 1 :b, 2 :a, 2 :b, 3 :a, 3 :b

;; dotimes - repeat n times
(dotimes [i 3]
  (println "Iteration" i))
; Prints: Iteration 0, Iteration 1, Iteration 2

;; for - list comprehension (returns lazy sequence)
(for [x [1 2 3]
      y [:a :b]
      :when (odd? x)]  ; filtering
  [x y])
; => ([1 :a] [1 :b] [3 :a] [3 :b])

;; 8. EARLY TERMINATION

;; reduced - early termination in reductions
(reduce (fn [acc x]
          (if (> acc 10)
            (reduced acc)  ; stop early
            (+ acc x)))
        0
        [1 2 3 4 5 6 7 8])
; => 10 (stops when accumulator > 10)

;; take-while - take elements while condition is true
(take-while #(< % 5) [1 2 3 4 5 6 7])  ; => (1 2 3 4)

;; 9. PATTERN MATCHING (core.match library)

;; Basic pattern matching (requires [org.clojure/core.match "1.0.0"])
(require '[clojure.core.match :refer [match]])

(defn describe-data [data]
  (match data
    {:type :user :name name} (str "User: " name)
    {:type :admin}           "Administrator"
    [x y]                    (str "Pair: " x ", " y)
    x                        (str "Other: " x)))

;; 10. THREADING MACROS FOR FLOW CONTROL

;; -> (thread first) - insert each result as first argument
(-> 5
    inc      ; (inc 5) => 6
    (* 2)    ; (* 6 2) => 12
    (- 3))   ; (- 12 3) => 9

;; ->> (thread last) - insert each result as last argument
(->> [1 2 3 4 5]
     (map inc)        ; (map inc [1 2 3 4 5])
     (filter even?)   ; (filter even? (2 3 4 5 6))
     (reduce +))      ; (reduce + (2 4 6)) => 12

;; as-> - thread with custom position
(as-> {:a 1 :b 2} data
  (assoc data :c 3)     ; {:a 1 :b 2 :c 3}
  (vals data)           ; (1 2 3)
  (apply + data))       ; 6

;; some-> - thread first, stop on nil
(some-> {:user {:profile {:name "Alice"}}}
        :user
        :profile
        :name)  ; => "Alice"

(some-> {:user nil}
        :user
        :profile  ; stops here, returns nil
        :name)

;; 11. MEMORY TIPS

;; Flow control principles:
;; - Everything is an expression (returns a value)
;; - Prefer functional approaches over imperative loops
;; - Use sequence operations instead of explicit iteration
;; - Handle nil values gracefully

;; Common patterns:
;; - if/when for simple conditionals
;; - cond for multiple conditions
;; - case for exact value matching
;; - loop/recur for explicit iteration
;; - doseq for side effects
;; - for for sequence generation

;; Best practices:
;; - Avoid mutable state in loops
;; - Use threading macros for clarity
;; - Handle exceptions appropriately
;; - Prefer pure functions over side effects
;; - Think in terms of data transformation
