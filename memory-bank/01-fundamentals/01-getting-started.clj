;; Getting Started with Clojure
;; This file introduces the basic concepts of Clojure programming

;; 1. REPL (Read-Eval-Print Loop)
;; Clojure is designed to be interactive. Use the REPL to experiment!
;; Start REPL with: clj

;; 2. Basic Syntax
;; Clojure uses prefix notation (Polish notation)
;; Function calls: (function-name arg1 arg2 ...)

;; Basic arithmetic
(+ 1 2)        ; => 3
(- 5 3)        ; => 2
(* 4 5)        ; => 20
(/ 10 2)       ; => 5

;; Nested expressions
(+ 1 (* 2 3))  ; => 7

;; 3. Comments
;; Single line comment starts with semicolon
;; Multiple semicolons for different levels of comments

;; This is a comment

;;; This is a section comment

;;;; This is a file-level comment

;; 4. Basic Data Types

;; Numbers
42          ; integer
3.14        ; float
22/7        ; ratio (exact fraction)

;; Strings
"Hello, World!"
"Multi-line
strings are
allowed"

;; Characters
\a          ; character 'a'
\space      ; space character
\newline    ; newline character

;; Booleans and nil
true        ; boolean true
false       ; boolean false
nil         ; represents null/empty

;; Keywords (like symbols, but evaluate to themselves)
:name
:age
:clojure

;; Symbols (names for things)
'my-symbol
'another-symbol

;; 5. Basic Functions

;; println - prints to console
(println "Hello, Clojure!")

;; str - string concatenation
(str "Hello, " "World!")

;; count - returns length/size
(count "Hello")     ; => 5
(count [1 2 3 4])   ; => 4

;; type - returns the type of a value
(type 42)           ; => java.lang.Long
(type "hello")      ; => java.lang.String
(type :keyword)     ; => clojure.lang.Keyword

;; 6. REPL Commands
;; (doc function-name)  - shows documentation
;; (source function-name) - shows source code
;; (find-doc "search-term") - searches documentation

;; Examples to try in REPL:
;; (doc +)
;; (doc str)
;; (find-doc "string")

;; 7. Memory Notes
;; - Everything is an expression that returns a value
;; - Parentheses are for function calls, not grouping
;; - Clojure is a Lisp: LISt Processing language
;; - Data structures are immutable by default
;; - Functions are first-class citizens

;; Practice: Try these expressions in your REPL!
