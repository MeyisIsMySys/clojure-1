;; Sequence Operations in Clojure
;; All Clojure collections can be treated as sequences

;; 1. SEQUENCE ABSTRACTION
;; Three fundamental operations:
;; - first: get the first element
;; - rest: get all elements except the first
;; - cons: add an element to the front

;; Works with all collections
(first [1 2 3])      ; => 1
(first '(a b c))     ; => a
(first {:a 1 :b 2})  ; => [:a 1] (first key-value pair)

(rest [1 2 3])       ; => (2 3)
(rest #{1 2 3})      ; => (2 3) or similar (sets are unordered)

(cons 0 [1 2 3])     ; => (0 1 2 3)

;; 2. COMMON SEQUENCE FUNCTIONS

;; map - transform each element
(map inc [1 2 3 4])              ; => (2 3 4 5)
(map str [:a :b :c])             ; => ("a" "b" "c")
(map + [1 2 3] [10 20 30])       ; => (11 22 33) (multiple collections)

;; filter - keep elements that match predicate
(filter even? [1 2 3 4 5 6])     ; => (2 4 6)
(filter #(> % 10) [5 15 8 20 3]) ; => (15 20)

;; remove - opposite of filter
(remove even? [1 2 3 4 5 6])     ; => (1 3 5)

;; reduce - combine elements into single value
(reduce + [1 2 3 4])             ; => 10
(reduce * [1 2 3 4])             ; => 24
(reduce str ["a" "b" "c"])       ; => "abc"

;; reduce with initial value
(reduce + 100 [1 2 3])           ; => 106
(reduce conj [] [1 2 3])         ; => [1 2 3]

;; 3. LAZY SEQUENCES
;; Many sequence operations return lazy sequences
;; Elements are computed only when needed

(def infinite-numbers (iterate inc 0))  ; infinite sequence: 0, 1, 2, 3...
(take 5 infinite-numbers)               ; => (0 1 2 3 4)

;; range - create sequences of numbers
(range 5)          ; => (0 1 2 3 4)
(range 2 8)        ; => (2 3 4 5 6 7)
(range 0 10 2)     ; => (0 2 4 6 8)

;; repeat - repeat a value
(take 3 (repeat "hello"))        ; => ("hello" "hello" "hello")
(repeat 5 :x)                    ; => (:x :x :x :x :x)

;; cycle - repeat a sequence infinitely
(take 8 (cycle [1 2 3]))         ; => (1 2 3 1 2 3 1 2)

;; 4. TAKING AND DROPPING

;; take - get first n elements
(take 3 [1 2 3 4 5])             ; => (1 2 3)
(take 10 (range))                ; => (0 1 2 3 4 5 6 7 8 9)

;; drop - skip first n elements
(drop 2 [1 2 3 4 5])             ; => (3 4 5)

;; take-while - take elements while predicate is true
(take-while #(< % 5) [1 2 3 4 5 6 7])  ; => (1 2 3 4)

;; drop-while - drop elements while predicate is true
(drop-while #(< % 5) [1 2 3 4 5 6 7])  ; => (5 6 7)

;; 5. SEQUENCE UTILITIES

;; count - number of elements
(count [1 2 3 4])                ; => 4
(count "hello")                  ; => 5

;; empty? - check if sequence is empty
(empty? [])                      ; => true
(empty? [1])                     ; => false

;; seq - convert to sequence (nil if empty)
(seq [1 2 3])                    ; => (1 2 3)
(seq [])                         ; => nil

;; reverse - reverse order
(reverse [1 2 3 4])              ; => (4 3 2 1)

;; sort - sort elements
(sort [3 1 4 1 5])               ; => (1 1 3 4 5)
(sort > [3 1 4 1 5])             ; => (5 4 3 1 1) (descending)

;; distinct - remove duplicates
(distinct [1 2 2 3 3 3])         ; => (1 2 3)

;; 6. COMBINING SEQUENCES

;; concat - concatenate sequences
(concat [1 2] [3 4] [5 6])       ; => (1 2 3 4 5 6)

;; interleave - alternate elements from sequences
(interleave [1 2 3] [:a :b :c])  ; => (1 :a 2 :b 3 :c)

;; interpose - insert separator between elements
(interpose "," ["a" "b" "c"])    ; => ("a" "," "b" "," "c")

;; partition - group elements
(partition 2 [1 2 3 4 5 6])      ; => ((1 2) (3 4) (5 6))
(partition 3 [1 2 3 4 5 6 7 8])  ; => ((1 2 3) (4 5 6))

;; partition-by - partition when function value changes
(partition-by even? [1 1 2 2 2 3 3])  ; => ((1 1) (2 2 2) (3 3))

;; 7. HIGHER-ORDER SEQUENCE FUNCTIONS

;; mapcat - map then concatenate
(mapcat #(repeat 2 %) [1 2 3])   ; => (1 1 2 2 3 3)

;; apply - apply function to sequence as arguments
(apply + [1 2 3 4])              ; same as (+ 1 2 3 4) => 10
(apply str ["hello" " " "world"]) ; => "hello world"

;; some - find first truthy result
(some even? [1 3 4 5])           ; => true
(some #(when (even? %) %) [1 3 4 5])  ; => 4

;; every? - check if all elements satisfy predicate
(every? even? [2 4 6 8])         ; => true
(every? even? [2 4 5 8])         ; => false

;; 8. THREADING MACROS FOR SEQUENCES
;; Make sequence operations more readable

;; Thread-first macro (->)
(->> [1 2 3 4 5 6 7 8 9 10]
     (filter even?)
     (map #(* % %))
     (take 3))                   ; => (4 16 36)

;; Thread-last macro (->>)
(-> {:numbers [1 2 3 4 5]}
    :numbers
    (map inc)
    reverse)                     ; => (6 5 4 3 2)

;; 9. MEMORY TIPS

;; Performance notes:
;; - Lazy sequences are memory efficient for large data
;; - Use 'doall' or 'dorun' to force evaluation if needed
;; - Many functions return lazy sequences by default

;; Common patterns:
;; - map → transform elements
;; - filter → select elements
;; - reduce → combine elements
;; - take/drop → control sequence length
;; - partition → group elements

;; Best practices:
;; - Use threading macros for multiple operations
;; - Understand lazy vs eager evaluation
;; - Prefer sequence functions over loops
;; - Think in terms of data transformation pipelines
