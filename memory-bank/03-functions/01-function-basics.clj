;; Functions in Clojure
;; Functions are first-class citizens in Clojure

;; 1. DEFINING FUNCTIONS

;; defn - standard function definition
(defn greet
  "Greets a person by name"  ; docstring (optional)
  [name]                     ; parameter vector
  (str "Hello, " name "!"))  ; function body

;; Calling the function
(greet "Alice")  ; => "Hello, Alice!"

;; Multiple arity (different number of parameters)
(defn greet-many
  "Greets one or more people"
  ([name]
   (str "Hello, " name "!"))
  ([first-name last-name]
   (str "Hello, " first-name " " last-name "!"))
  ([first-name middle-name last-name]
   (str "Hello, " first-name " " middle-name " " last-name "!")))

(greet-many "Alice")                    ; => "Hello, Alice!"
(greet-many "Bob" "Smith")              ; => "Hello, Bob Smith!"
(greet-many "John" "Q" "Public")        ; => "Hello, John Q Public!"

;; Variable arguments with &
(defn sum-all
  "Sums all provided numbers"
  [& numbers]
  (apply + numbers))

(sum-all 1 2 3 4 5)  ; => 15

;; Combining fixed and variable arguments
(defn log-message
  "Logs a message with optional additional data"
  [level message & data]
  (str "[" level "] " message " " (apply str data)))

(log-message "INFO" "User logged in" "user-id: 123")

;; 2. ANONYMOUS FUNCTIONS

;; fn form - explicit anonymous function
(fn [x] (* x x))

;; Using anonymous function
((fn [x] (* x x)) 5)  ; => 25

;; Assigning to a var
(def square (fn [x] (* x x)))
(square 4)  ; => 16

;; Shorthand syntax with #()
#(* % %)          ; single argument (%)
#(+ %1 %2)        ; multiple arguments (%1, %2, etc.)
#(str %1 " " %2)  ; works with any expression

;; Examples
(map #(* % %) [1 2 3 4])     ; => (1 4 9 16)
(filter #(> % 5) [1 6 3 8])  ; => (6 8)

;; 3. HIGHER-ORDER FUNCTIONS
;; Functions that take or return other functions

;; Function that takes a function as argument
(defn apply-twice
  "Applies function f to value x twice"
  [f x]
  (f (f x)))

(apply-twice inc 5)        ; => 7
(apply-twice #(* 2 %) 3)   ; => 12

;; Function that returns a function
(defn make-adder
  "Returns a function that adds n to its argument"
  [n]
  (fn [x] (+ x n)))

(def add-5 (make-adder 5))
(add-5 10)  ; => 15

;; 4. PARTIAL APPLICATION

;; partial - create new function with some arguments pre-filled
(def add-10 (partial + 10))
(add-10 5)  ; => 15

(def multiply-by-3 (partial * 3))
(multiply-by-3 4)  ; => 12

;; More complex partial
(defn log-with-level [level timestamp message]
  (str "[" level "] " timestamp " - " message))

(def info-logger (partial log-with-level "INFO"))
(info-logger "2023-07-30" "User logged in")

;; 5. COMPOSITION

;; comp - compose functions (right to left)
(def add-one-and-square (comp #(* % %) inc))
(add-one-and-square 4)  ; => 25 (4 + 1 = 5, 5 * 5 = 25)

;; Multiple function composition
(def process-data (comp #(apply str %) 
                        reverse 
                        #(map clojure.string/upper-case %)))

(process-data ["hello" "world"])  ; => "DLROWOLLEH"

;; 6. RECURSIVE FUNCTIONS

;; Simple recursion
(defn factorial
  "Calculates factorial of n"
  [n]
  (if (<= n 1)
    1
    (* n (factorial (dec n)))))

(factorial 5)  ; => 120

;; Tail recursion with recur (more efficient)
(defn factorial-tail
  "Tail-recursive factorial"
  [n]
  (letfn [(fact-helper [n acc]
            (if (<= n 1)
              acc
              (recur (dec n) (* acc n))))]
    (fact-helper n 1)))

(factorial-tail 5)  ; => 120

;; 7. LOCAL FUNCTIONS

;; letfn - define local functions
(defn calculate-stats
  "Calculates various statistics for a collection of numbers"
  [numbers]
  (letfn [(mean [nums] 
            (/ (apply + nums) (count nums)))
          (variance [nums]
            (let [m (mean nums)]
              (mean (map #(* (- % m) (- % m)) nums))))]
    {:mean (mean numbers)
     :variance (variance numbers)
     :count (count numbers)}))

(calculate-stats [1 2 3 4 5])
; => {:mean 3, :variance 2, :count 5}

;; 8. FUNCTION PREDICATES

;; fn? - check if something is a function
(fn? +)         ; => true
(fn? greet)     ; => true
(fn? 42)        ; => false

;; ifn? - check if something is invokable (function-like)
(ifn? +)        ; => true
(ifn? {:a 1})   ; => true (maps are functions)
(ifn? #{1 2})   ; => true (sets are functions)

;; 9. FUNCTION METADATA

;; Adding metadata to functions
(defn ^{:doc "Adds two numbers"
        :test (fn [] (assert (= 5 (add-nums 2 3))))}
  add-nums
  [a b]
  (+ a b))

;; Accessing metadata
(meta #'add-nums)

;; 10. MEMOIZATION

;; memoize - cache function results
(def fib
  (memoize 
    (fn [n]
      (if (<= n 1)
        n
        (+ (fib (- n 1)) (fib (- n 2)))))))

(time (fib 35))  ; Fast after first call due to memoization

;; 11. MEMORY TIPS

;; Function definition patterns:
;; - Use defn for named functions
;; - Use fn or #() for anonymous functions
;; - Use letfn for local helper functions
;; - Use partial for argument pre-filling
;; - Use comp for function composition

;; Performance considerations:
;; - Use recur for tail recursion (no stack overflow)
;; - Memoize expensive pure functions
;; - Prefer higher-order functions over explicit loops
;; - Functions are values - can be stored, passed, returned

;; Best practices:
;; - Keep functions small and focused
;; - Use descriptive names
;; - Add docstrings for public functions
;; - Prefer pure functions (no side effects)
;; - Think in terms of data transformation
