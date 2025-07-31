;; Java Interoperability in Clojure
;; Clojure runs on the JVM and provides seamless Java interop

;; 1. CALLING JAVA METHODS

;; Static method calls
(Math/abs -42)           ; => 42
(Math/max 10 20)         ; => 20
(Math/PI)                ; => 3.141592653589793
(System/currentTimeMillis)

;; Instance method calls
(def my-string "Hello World")
(.length my-string)      ; => 11
(.toLowerCase my-string) ; => "hello world"
(.substring my-string 0 5) ; => "Hello"

;; Chaining method calls with ->
(-> "  hello world  "
    .trim
    .toUpperCase
    (.replace "WORLD" "CLOJURE"))  ; => "HELLO CLOJURE"

;; 2. ACCESSING JAVA FIELDS

;; Static fields
Math/PI                  ; => 3.141592653589793
Integer/MAX_VALUE        ; => 2147483647

;; Instance fields (less common in modern Java)
;; (.field object)

;; 3. CREATING JAVA OBJECTS

;; Using 'new'
(new java.util.Date)
(new java.util.ArrayList)
(new String "hello")

;; Shorthand syntax (class.)
(java.util.Date.)
(java.util.ArrayList.)
(String. "hello")

;; With constructor arguments
(new java.io.File "/path/to/file")
(java.io.File. "/path/to/file")

;; 4. IMPORTING JAVA CLASSES

;; Import single class
(import 'java.util.Date)
(Date.)  ; Now can use Date directly

;; Import multiple classes from same package
(import '(java.util Date Calendar ArrayList HashMap))

;; Import in namespace declaration
(ns my-app.core
  (:import [java.util Date Calendar]
           [java.io File FileReader]
           [java.net URL URI]))

;; 5. WORKING WITH JAVA COLLECTIONS

;; Java collections are mutable and integrate with Clojure
(def java-list (java.util.ArrayList.))
(.add java-list "first")
(.add java-list "second")
(.size java-list)  ; => 2

;; Convert between Clojure and Java collections
(into [] java-list)  ; Java -> Clojure vector
(java.util.ArrayList. [1 2 3])  ; Clojure -> Java

;; Clojure sequence functions work on Java collections
(map #(.toUpperCase %) java-list)
(filter #(.startsWith % "f") java-list)

;; 6. WORKING WITH ARRAYS

;; Create arrays
(make-array String 5)        ; String array of size 5
(into-array String ["a" "b"]) ; From Clojure sequence

;; Access array elements
(def arr (into-array [1 2 3 4 5]))
(aget arr 0)   ; => 1 (get element)
(aset arr 0 10) ; set element
(alength arr)   ; => 5 (array length)

;; Array type hints for performance
(defn sum-array [^ints arr]
  (loop [i 0 sum 0]
    (if (< i (alength arr))
      (recur (inc i) (+ sum (aget arr i)))
      sum)))

;; 7. EXCEPTION HANDLING

;; Try-catch with Java exceptions
(try
  (/ 1 0)
  (catch ArithmeticException e
    (println "Division by zero!")
    (.getMessage e))
  (catch Exception e
    (println "General error:" (.getMessage e))))

;; Throwing Java exceptions
(defn validate-positive [n]
  (when (not (pos? n))
    (throw (IllegalArgumentException. "Number must be positive")))
  n)

;; 8. IMPLEMENTING JAVA INTERFACES

;; Using reify to implement interfaces
(def my-runnable
  (reify java.lang.Runnable
    (run [this]
      (println "Running in thread"))))

;; Using with Java threading
(def thread (Thread. my-runnable))
(.start thread)

;; Implementing multiple interfaces
(def my-comparator
  (reify java.util.Comparator
    (compare [this a b]
      (compare (.length a) (.length b)))))

;; 9. EXTENDING JAVA CLASSES

;; Using proxy to extend classes
(def my-list
  (proxy [java.util.ArrayList] []
    (add [item]
      (println "Adding:" item)
      (proxy-super add item))))

;; 10. TYPE HINTS FOR PERFORMANCE

;; Type hints prevent reflection
(defn string-length [^String s]
  (.length s))

;; Type hints for return values
(defn ^String make-string [x]
  (str x))

;; Type hints for better performance
(defn process-numbers [^java.util.List numbers]
  (loop [i 0 sum 0.0]
    (if (< i (.size numbers))
      (recur (inc i) (+ sum (.doubleValue (.get numbers i))))
      sum)))

;; 11. USEFUL JAVA INTEROP PATTERNS

;; Working with Java builders
(defn create-url [spec]
  (-> (java.net.URL. spec)
      .toString))

;; Converting Java iterables to Clojure sequences
(defn java-iterable-to-seq [iterable]
  (iterator-seq (.iterator iterable)))

;; Creating Java maps from Clojure maps
(defn clojure-map-to-java [clj-map]
  (java.util.HashMap. clj-map))

;; 12. COMMON JAVA CLASSES IN CLOJURE

;; Date and time
(import 'java.util.Date)
(def now (Date.))
(.toString now)

;; File operations
(import 'java.io.File)
(def file (File. "/path/to/file"))
(.exists file)
(.getName file)

;; URL operations
(import 'java.net.URL)
(def url (URL. "https://example.com"))
(.getHost url)
(.getPath url)

;; Regular expressions (Java Pattern)
(import 'java.util.regex.Pattern)
(def pattern (Pattern/compile "\\d+"))
(.matcher pattern "123abc")

;; 13. REFLECTION AND PERFORMANCE

;; Avoid reflection warnings with type hints
(set! *warn-on-reflection* true)

;; Without type hint (causes reflection)
(defn bad-length [s]
  (.length s))  ; Warning about reflection

;; With type hint (no reflection)
(defn good-length [^String s]
  (.length s))

;; 14. SYSTEM PROPERTIES AND ENVIRONMENT

;; System properties
(System/getProperty "java.version")
(System/getProperty "user.home")
(System/setProperty "my.property" "value")

;; Environment variables
(System/getenv "PATH")
(System/getenv "HOME")

;; 15. MEMORY TIPS

;; Java interop best practices:
;; - Use type hints to avoid reflection
;; - Prefer Clojure collections when possible
;; - Convert Java collections to Clojure for functional operations
;; - Use reify for interfaces, proxy for classes
;; - Handle Java exceptions appropriately

;; Common patterns:
;; - (.method obj args) for instance methods
;; - (Class/method args) for static methods
;; - (Class.) for constructors
;; - (import ...) to bring classes into namespace

;; Performance considerations:
;; - Type hints eliminate reflection overhead
;; - Primitive arrays are more efficient than boxed
;; - Direct Java method calls are fast
;; - Minimize boxing/unboxing of primitives

;; Integration strategies:
;; - Wrap Java APIs in Clojure functions
;; - Use protocols to abstract over Java interfaces
;; - Create Clojure-friendly facades for Java libraries
;; - Leverage existing Java ecosystem libraries
