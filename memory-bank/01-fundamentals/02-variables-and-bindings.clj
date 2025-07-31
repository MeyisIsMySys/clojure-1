;; Variables and Definitions in Clojure

;; 1. def - Defining global vars
;; Use 'def' to create global bindings

(def pi 3.14159)
(def greeting "Hello, Clojure!")
(def my-vector [1 2 3 4 5])

;; Using defined vars
(println greeting)
(* pi 2)

;; 2. let - Local bindings
;; Use 'let' for local variables within a scope

(let [x 10
      y 20
      z (+ x y)]
  (println "x:" x "y:" y "z:" z)
  (* z 2))  ; Returns 60

;; let creates a new scope
(let [name "Alice"
      age 30]
  (str name " is " age " years old"))

;; Nested let bindings
(let [a 5]
  (let [b 10
        c (+ a b)]
    (* c 2)))  ; => 30

;; 3. Destructuring in let
;; Extract values from data structures

;; Vector destructuring
(let [[first second third] [1 2 3 4 5]]
  (println "First:" first)    ; => 1
  (println "Second:" second)  ; => 2
  (println "Third:" third))   ; => 3

;; Map destructuring
(let [{name :name age :age} {:name "Bob" :age 25 :city "NYC"}]
  (str name " is " age " years old"))

;; Destructuring with defaults
(let [{name :name age :age city :city :or {city "Unknown"}} 
      {:name "Charlie" :age 35}]
  (str name " lives in " city))

;; 4. Naming Conventions
;; - Use kebab-case for multi-word names
;; - Predicates (functions returning true/false) end with ?
;; - Functions with side effects often end with !
;; - Constants in SCREAMING-KEBAB-CASE

(def max-retries 3)
(def user-name "john-doe")
(def is-valid? true)

;; 5. def vs let - Key Differences

;; def:
;; - Creates global vars
;; - Available throughout the namespace
;; - Use for constants, functions, global state

;; let:
;; - Creates local bindings
;; - Only available within the let block
;; - Use for temporary calculations, local variables

;; Example showing scope
(def global-var "I'm global")

(defn example-function []
  (let [local-var "I'm local"]
    (println global-var)  ; Can access global
    (println local-var))) ; Can access local

;; (println local-var)    ; This would cause an error!

;; 6. Memory Tips
;; - prefer 'let' for temporary values
;; - Use 'def' sparingly for global state
;; - Destructuring makes code cleaner and more readable
;; - Always use meaningful names
;; - Clojure vars are thread-safe by default

;; Practice Examples:

;; 1. Create a let binding that calculates the area of a circle
(let [radius 5
      area (* pi radius radius)]
  area)

;; 2. Destructure a person map
(let [person {:first-name "Jane" :last-name "Doe" :age 28}
      {first :first-name last :last-name} person]
  (str first " " last))

;; 3. Use multiple let bindings
(let [numbers [10 20 30]
      [a b c] numbers
      sum (+ a b c)
      average (/ sum 3)]
  {:sum sum :average average})
