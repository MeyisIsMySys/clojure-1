;; Quick Reference Guide for Clojure

;; ===============================
;; BASIC SYNTAX
;; ===============================

;; Comments
; Single line comment
;; Section comment
;;; File-level comment

;; Function calls (prefix notation)
(+ 1 2 3)        ; => 6
(str "a" "b")    ; => "ab"

;; ===============================
;; DATA TYPES
;; ===============================

;; Numbers
42               ; integer
3.14             ; float
22/7             ; ratio

;; Strings & Characters
"hello"          ; string
\a               ; character

;; Booleans & nil
true false nil

;; Keywords & Symbols
:keyword         ; keyword
'symbol          ; symbol

;; ===============================
;; COLLECTIONS
;; ===============================

;; Lists (linked list)
'(1 2 3)
(list 1 2 3)

;; Vectors (indexed)
[1 2 3]
(vector 1 2 3)

;; Maps (key-value)
{:a 1 :b 2}
(hash-map :a 1 :b 2)

;; Sets (unique values)
#{1 2 3}
(set [1 2 3])

;; ===============================
;; FUNCTIONS
;; ===============================

;; Define function
(defn name [params] body)

;; Anonymous function
(fn [x] (* x x))
#(* % %)

;; Multiple arity
(defn greet
  ([name] (str "Hi " name))
  ([first last] (str "Hi " first " " last)))

;; Variable arguments
(defn sum [& nums] (apply + nums))

;; ===============================
;; VARIABLES & BINDINGS
;; ===============================

;; Global binding
(def x 42)

;; Local binding
(let [x 10 y 20] (+ x y))

;; Destructuring
(let [[a b c] [1 2 3]] a)        ; => 1
(let [{name :name} {:name "Joe"}] name)  ; => "Joe"

;; ===============================
;; SEQUENCE OPERATIONS
;; ===============================

;; Basic operations
(first [1 2 3])      ; => 1
(rest [1 2 3])       ; => (2 3)
(cons 0 [1 2 3])     ; => (0 1 2 3)

;; Transformations
(map inc [1 2 3])            ; => (2 3 4)
(filter even? [1 2 3 4])     ; => (2 4)
(reduce + [1 2 3 4])         ; => 10

;; Utilities
(count [1 2 3])      ; => 3
(reverse [1 2 3])    ; => (3 2 1)
(sort [3 1 2])       ; => (1 2 3)

;; ===============================
;; CONDITIONALS
;; ===============================

;; Basic if
(if condition then-expr else-expr)

;; Multiple conditions
(cond
  (< x 0) "negative"
  (= x 0) "zero"
  :else   "positive")

;; Pattern matching
(case x
  1 "one"
  2 "two"
  "other")

;; Conditional execution
(when condition body)
(when-not condition body)

;; ===============================
;; THREADING MACROS
;; ===============================

;; Thread first
(-> x f1 f2 f3)
; Same as: (f3 (f2 (f1 x)))

;; Thread last
(->> x f1 f2 f3)
; Same as: (f3 (f2 (f1 x)))

;; ===============================
;; COMMON PREDICATES
;; ===============================

;; Type checks
(nil? x)         ; is nil?
(true? x)        ; is exactly true?
(false? x)       ; is exactly false?
(string? x)      ; is string?
(number? x)      ; is number?
(keyword? x)     ; is keyword?
(symbol? x)      ; is symbol?
(fn? x)          ; is function?

;; Collection checks
(empty? coll)    ; is empty?
(seq coll)       ; has elements? (nil if empty)
(coll? x)        ; is collection?
(map? x)         ; is map?
(vector? x)      ; is vector?
(list? x)        ; is list?
(set? x)         ; is set?

;; Numeric checks
(pos? x)         ; positive?
(neg? x)         ; negative?
(zero? x)        ; zero?
(even? x)        ; even?
(odd? x)         ; odd?

;; ===============================
;; USEFUL FUNCTIONS
;; ===============================

;; String operations
(str & args)             ; concatenate
(clojure.string/join sep coll)
(clojure.string/split s regex)

;; Collection operations
(get coll key)           ; get value by key
(assoc map key val)      ; add/update key-value
(dissoc map key)         ; remove key
(conj coll item)         ; add item
(into coll1 coll2)       ; add all items

;; Sequence generation
(range n)                ; 0 to n-1
(range start end)        ; start to end-1
(repeat n x)             ; repeat x n times
(cycle coll)             ; infinite repetition

;; ===============================
;; REPL COMMANDS
;; ===============================

(doc function-name)      ; show documentation
(source function-name)   ; show source code
(find-doc "search")      ; search documentation
(dir namespace)          ; list functions in namespace

;; ===============================
;; NAMESPACE OPERATIONS
;; ===============================

(ns my-namespace)        ; create/switch namespace
(require '[clojure.string :as str])
(use 'clojure.set)
(import '(java.util Date))

;; ===============================
;; ERROR HANDLING
;; ===============================

(try
  (risky-operation)
  (catch Exception e
    (handle-error e))
  (finally
    (cleanup)))

;; ===============================
;; JAVA INTEROP
;; ===============================

;; Call method
(.method object args)
(Math/abs -5)

;; Access field
(.field object)

;; Create object
(new ClassName args)
(ClassName. args)

;; ===============================
;; DEVELOPMENT WORKFLOW
;; ===============================

;; Starting REPL
clj                      ; Start Clojure REPL
bb repl                  ; Start Babashka REPL

;; Project Creation
;; Install deps-new (one time):
;; clj -Ttools install-latest :lib io.github.seancorfield/deps-new :as new

;; Create new project:
;; clj -Tnew app :name my-project

;; With mise tasks:
mise run repl            ; Start REPL
mise run bb-repl         ; Start Babashka REPL
mise run new-project my-app ; Create new project
mise run test-setup      ; Test environment
mise run memory-bank     ; Open learning materials

;; REPL Exit
(System/exit 0)          ; Exit REPL programmatically
;; Ctrl+C or Cmd+C        ; Keyboard interrupt
;; In VS Code: Debug -> Stop

;; Build and Test (in project)
clj -T:build test        ; Run tests
clj -T:build ci          ; Full CI build

;; ===============================
;; MEMORY AIDS
;; ===============================

;; Remember: Everything is an expression that returns a value
;; Prefix notation: (function arg1 arg2 ...)
;; Immutable by default
;; Functions are first-class
;; Think in terms of data transformation
;; Use REPL for experimentation
