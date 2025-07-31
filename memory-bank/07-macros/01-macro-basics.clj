;; 07-macros/01-macro-basics.clj
;; Clojure Macros - Code that writes code
;; 
;; Memory Note: Macros are Clojure's metaprogramming facility
;; They allow you to write code that generates code at compile time

(ns memory-bank.macros.basics
  "Introduction to Clojure macros - the foundation of metaprogramming")

;; =============================================================================
;; UNDERSTANDING MACROS
;; =============================================================================

;; Macros are functions that run at compile time and transform code
;; They receive unevaluated forms and return new forms

;; Example: Simple macro
(defmacro when-debug
  "Execute body only when debugging is enabled"
  [& body]
  `(when *debug*
     ~@body))

;; Usage:
;; (def ^:dynamic *debug* true)
;; (when-debug 
;;   (println "Debug info")
;;   (println "More debug"))

;; =============================================================================
;; QUOTE AND SYNTAX-QUOTE
;; =============================================================================

;; Quote (') prevents evaluation
'(+ 1 2)  ; => (+ 1 2) - not evaluated

;; Syntax-quote (`) like quote but with namespace resolution
`(+ 1 2)  ; => (clojure.core/+ 1 2)

;; Unquote (~) evaluates within syntax-quote
(let [x 42]
  `(println ~x))  ; => (clojure.core/println 42)

;; Unquote-splicing (~@) splices sequences
(let [args [1 2 3]]
  `(+ ~@args))  ; => (clojure.core/+ 1 2 3)

;; =============================================================================
;; SIMPLE MACROS
;; =============================================================================

(defmacro unless
  "Inverse of when - execute body when condition is false"
  [condition & body]
  `(when (not ~condition)
     ~@body))

;; Memory Tip: Always use syntax-quote and unquote in macros
;; This ensures proper namespace resolution

;; Example usage:
;; (unless false (println "This will print"))
;; (unless true (println "This won't print"))

(defmacro bench
  "Simple benchmarking macro"
  [expr]
  `(let [start# (System/nanoTime)
         result# ~expr
         end# (System/nanoTime)]
     (println "Execution time:" (/ (- end# start#) 1000000.0) "ms")
     result#))

;; The # suffix creates unique symbols (gensym) to avoid variable capture

;; =============================================================================
;; PRACTICE EXERCISES
;; =============================================================================

;; 1. Create a macro `with-timing` that prints how long a block takes
;; 2. Create a macro `safe-div` that returns 0 for division by zero
;; 3. Create a macro `repeat-n` that repeats an expression n times

;; Memory Bank Notes:
;; - Macros transform code before compilation
;; - Use syntax-quote (`) and unquote (~) for code generation
;; - Always use gensym (#) for local variables in macros
;; - Test macros with macroexpand and macroexpand-1
;; - Remember: macros are about code transformation, not runtime behavior
