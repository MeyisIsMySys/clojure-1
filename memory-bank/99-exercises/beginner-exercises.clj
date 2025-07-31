;; Clojure Exercises - Beginner Level
;; Work through these exercises to practice basic Clojure concepts

;; ===============================
;; BASIC OPERATIONS
;; ===============================

;; Exercise 1: Basic arithmetic
;; Calculate the result of: (5 + 3) * 2 - 1
;; Write this using Clojure prefix notation

;; Your answer here:
;; (- (* (+ 5 3) 2) 1)

;; Exercise 2: String manipulation
;; Create a function that takes a first name and last name
;; and returns "Hello, FirstName LastName!"

;; Your answer here:
;; (defn full-greeting [first-name last-name]
;;   (str "Hello, " first-name " " last-name "!"))

;; ===============================
;; COLLECTIONS
;; ===============================

;; Exercise 3: Vector operations
;; Given the vector [1 2 3 4 5], create expressions that:
;; a) Get the first element
;; b) Get the last element
;; c) Get all elements except the first
;; d) Add 6 to the end

(def my-vector [1 2 3 4 5])

;; Your answers here:
;; a) (first my-vector)
;; b) (last my-vector)
;; c) (rest my-vector)
;; d) (conj my-vector 6)

;; Exercise 4: Map operations
;; Create a map representing a person with :name, :age, and :city
;; Then write expressions to:
;; a) Get the person's name
;; b) Add an :email field
;; c) Remove the :city field
;; d) Update the age to be one year older

;; Your answers here:
;; (def person {:name "Alice" :age 30 :city "NYC"})
;; a) (:name person)
;; b) (assoc person :email "alice@example.com")
;; c) (dissoc person :city)
;; d) (update person :age inc)

;; ===============================
;; FUNCTIONS
;; ===============================

;; Exercise 5: Simple functions
;; Write functions for:
;; a) Calculate the area of a circle (π * r²)
;; b) Check if a number is even
;; c) Convert temperature from Celsius to Fahrenheit

;; Your answers here:
;; a) (defn circle-area [radius] (* Math/PI radius radius))
;; b) (defn is-even? [n] (even? n))
;; c) (defn celsius-to-fahrenheit [c] (+ (* c 9/5) 32))

;; Exercise 6: Higher-order functions
;; Using map, filter, and reduce:
;; a) Square all numbers in [1 2 3 4 5]
;; b) Keep only even numbers from [1 2 3 4 5 6 7 8]
;; c) Sum all numbers in [10 20 30 40]

;; Your answers here:
;; a) (map #(* % %) [1 2 3 4 5])
;; b) (filter even? [1 2 3 4 5 6 7 8])
;; c) (reduce + [10 20 30 40])

;; ===============================
;; CONDITIONALS
;; ===============================

;; Exercise 7: Grade calculator
;; Write a function that takes a numeric score (0-100)
;; and returns a letter grade:
;; 90-100: "A", 80-89: "B", 70-79: "C", 60-69: "D", below 60: "F"

;; Your answer here:
;; (defn letter-grade [score]
;;   (cond
;;     (>= score 90) "A"
;;     (>= score 80) "B"
;;     (>= score 70) "C"
;;     (>= score 60) "D"
;;     :else "F"))

;; Exercise 8: FizzBuzz element
;; Write a function that takes a number and returns:
;; - "Fizz" if divisible by 3
;; - "Buzz" if divisible by 5
;; - "FizzBuzz" if divisible by both
;; - The number itself otherwise

;; Your answer here:
;; (defn fizzbuzz [n]
;;   (cond
;;     (and (zero? (mod n 3)) (zero? (mod n 5))) "FizzBuzz"
;;     (zero? (mod n 3)) "Fizz"
;;     (zero? (mod n 5)) "Buzz"
;;     :else n))

;; ===============================
;; SEQUENCE OPERATIONS
;; ===============================

;; Exercise 9: Data processing
;; Given this data about people:
(def people [{:name "Alice" :age 30 :city "NYC"}
             {:name "Bob" :age 25 :city "LA"}
             {:name "Charlie" :age 35 :city "NYC"}
             {:name "Diana" :age 28 :city "Chicago"}])

;; Write expressions to:
;; a) Get all names
;; b) Find people older than 27
;; c) Get all unique cities
;; d) Calculate average age

;; Your answers here:
;; a) (map :name people)
;; b) (filter #(> (:age %) 27) people)
;; c) (set (map :city people))
;; d) (/ (reduce + (map :age people)) (count people))

;; Exercise 10: String processing
;; Given a string "hello world clojure programming"
;; Write expressions to:
;; a) Split into words
;; b) Capitalize each word
;; c) Keep only words longer than 4 characters
;; d) Join them back with commas

(def text "hello world clojure programming")

;; Your answers here:
;; a) (clojure.string/split text #" ")
;; b) (map clojure.string/capitalize (clojure.string/split text #" "))
;; c) (filter #(> (count %) 4) (clojure.string/split text #" "))
;; d) (clojure.string/join ", " (filter #(> (count %) 4) (clojure.string/split text #" ")))

;; ===============================
;; CHALLENGE PROBLEMS
;; ===============================

;; Exercise 11: Palindrome checker
;; Write a function that checks if a string is a palindrome
;; (reads the same forwards and backwards)

;; Your answer here:
;; (defn palindrome? [s]
;;   (let [clean (clojure.string/replace (clojure.string/lower-case s) #"[^a-z]" "")]
;;     (= clean (clojure.string/reverse clean))))

;; Exercise 12: Word frequency counter
;; Write a function that takes a string and returns a map
;; of word frequencies

;; Your answer here:
;; (defn word-frequency [text]
;;   (frequencies 
;;     (map clojure.string/lower-case 
;;       (clojure.string/split text #"\s+"))))

;; Exercise 13: Fibonacci sequence
;; Write a function that generates the first n numbers
;; of the Fibonacci sequence

;; Your answer here:
;; (defn fibonacci [n]
;;   (take n 
;;     (map first 
;;       (iterate (fn [[a b]] [b (+ a b)]) [0 1]))))

;; ===============================
;; TESTING YOUR SOLUTIONS
;; ===============================

;; Uncomment and run these to test your solutions:

;; Test basic arithmetic
;; (assert (= 15 (- (* (+ 5 3) 2) 1)))

;; Test greeting function
;; (assert (= "Hello, John Doe!" (full-greeting "John" "Doe")))

;; Test grade function
;; (assert (= "B" (letter-grade 85)))
;; (assert (= "F" (letter-grade 55)))

;; Test fizzbuzz
;; (assert (= "FizzBuzz" (fizzbuzz 15)))
;; (assert (= "Fizz" (fizzbuzz 9)))
;; (assert (= "Buzz" (fizzbuzz 10)))
;; (assert (= 7 (fizzbuzz 7)))

;; Remember: Try these in your REPL to see the results!
