;; Clojure Data Structures
;; Clojure has four main collection types: lists, vectors, maps, and sets

;; 1. LISTS - Linked lists, optimized for sequential access from the front
;; Syntax: (1 2 3) or '(1 2 3)

;; Creating lists
'(1 2 3 4)           ; quoted list
(list 1 2 3 4)       ; using list function
(quote (1 2 3 4))    ; using quote

;; List operations
(def my-list '(1 2 3 4 5))

(first my-list)      ; => 1 (first element)
(rest my-list)       ; => (2 3 4 5) (all but first)
(cons 0 my-list)     ; => (0 1 2 3 4 5) (add to front)
(conj my-list 0)     ; => (0 1 2 3 4 5) (add to front for lists)

;; Lists are great for:
;; - Sequential processing
;; - When you need to add/remove from the front
;; - Representing code (homoiconicity)

;; 2. VECTORS - Indexed collections, optimized for random access
;; Syntax: [1 2 3]

;; Creating vectors
[1 2 3 4]            ; literal syntax
(vector 1 2 3 4)     ; using vector function
(vec '(1 2 3 4))     ; convert list to vector

;; Vector operations
(def my-vector [1 2 3 4 5])

(get my-vector 0)    ; => 1 (get by index)
(my-vector 2)        ; => 3 (vectors are functions of their indices)
(nth my-vector 1)    ; => 2 (get nth element)
(count my-vector)    ; => 5 (length)
(conj my-vector 6)   ; => [1 2 3 4 5 6] (add to end for vectors)

;; Vector slicing
(subvec my-vector 1 4)   ; => [2 3 4] (elements from index 1 to 3)

;; Vectors are great for:
;; - Random access by index
;; - When you need to add to the end
;; - Most common collection type

;; 3. MAPS - Key-value pairs (hash maps)
;; Syntax: {:key value}

;; Creating maps
{:name "Alice" :age 30 :city "NYC"}
(hash-map :name "Bob" :age 25)
(zipmap [:a :b :c] [1 2 3])  ; => {:a 1 :b 2 :c 3}

;; Map operations
(def person {:name "Charlie" :age 35 :occupation "Developer"})

(get person :name)           ; => "Charlie"
(person :age)                ; => 35 (maps are functions of their keys)
(:name person)               ; => "Charlie" (keywords are functions too!)
(get person :salary "N/A")   ; => "N/A" (default value)

;; Adding/updating
(assoc person :salary 75000)         ; add/update key
(assoc person :age 36 :city "SF")    ; multiple updates
(dissoc person :age)                 ; remove key

;; Map functions
(keys person)       ; => (:name :age :occupation)
(vals person)       ; => ("Charlie" 35 "Developer")
(count person)      ; => 3

;; Maps are great for:
;; - Representing entities/records
;; - Configuration data
;; - Lookup tables

;; 4. SETS - Unique collections
;; Syntax: #{1 2 3}

;; Creating sets
#{1 2 3 4}           ; literal syntax
(set [1 2 3 2 1])    ; => #{1 2 3} (duplicates removed)
(hash-set 1 2 3 4)   ; using hash-set function

;; Set operations
(def my-set #{1 2 3 4 5})

(contains? my-set 3)     ; => true (membership test)
(my-set 3)               ; => 3 (sets are functions too!)
(conj my-set 6)          ; => #{1 2 3 4 5 6}
(disj my-set 2)          ; => #{1 3 4 5}

;; Set theory operations
(def set1 #{1 2 3 4})
(def set2 #{3 4 5 6})

(clojure.set/union set1 set2)        ; => #{1 2 3 4 5 6}
(clojure.set/intersection set1 set2) ; => #{3 4}
(clojure.set/difference set1 set2)   ; => #{1 2}

;; Sets are great for:
;; - Ensuring uniqueness
;; - Membership testing
;; - Set operations (union, intersection, etc.)

;; 5. NESTED DATA STRUCTURES

;; Complex nested structure
(def company
  {:name "Tech Corp"
   :employees [{:name "Alice" :department "Engineering" :skills #{:clojure :java}}
               {:name "Bob" :department "Design" :skills #{:figma :sketch}}
               {:name "Charlie" :department "Engineering" :skills #{:python :sql}}]
   :departments #{:engineering :design :sales}})

;; Accessing nested data
(get-in company [:employees 0 :name])        ; => "Alice"
(-> company :employees first :skills)        ; => #{:clojure :java}

;; Updating nested data
(assoc-in company [:employees 0 :salary] 75000)
(update-in company [:employees] conj {:name "Diana" :department "Sales"})

;; 6. MEMORY TIPS

;; Performance characteristics:
;; Lists: O(1) for head operations, O(n) for tail/random access
;; Vectors: O(1) for tail operations and random access (nearly)
;; Maps: O(1) for get/assoc/dissoc (hash table)
;; Sets: O(1) for contains/conj/disj (hash table)

;; All collections are:
;; - Immutable (operations return new collections)
;; - Persistent (share structure for efficiency)
;; - Sequable (can be processed with sequence functions)

;; Choose based on usage:
;; - Vector: default choice, random access needed
;; - List: sequential processing, code representation
;; - Map: key-value lookup
;; - Set: uniqueness, membership testing
