;; 10-testing/01-testing-basics.clj
;; Clojure Testing - Ensuring code quality
;; 
;; Memory Note: Clojure has excellent testing support
;; clojure.test is built-in, with many additional libraries available

(ns memory-bank.testing.basics
  "Introduction to testing in Clojure"
  (:require [clojure.test :refer :all]))

;; =============================================================================
;; BASIC TESTING WITH CLOJURE.TEST
;; =============================================================================

;; clojure.test is built into Clojure
;; Tests are written as functions with assertions

(deftest simple-math-test
  (testing "Basic arithmetic"
    (is (= 4 (+ 2 2)))
    (is (= 0 (- 5 5)))
    (is (= 25 (* 5 5)))))

;; Memory Tip: Tests are just functions with the deftest macro

;; =============================================================================
;; ASSERTION MACROS
;; =============================================================================

;; is - basic assertion
(deftest assertion-examples
  (testing "Different assertion types"
    ;; Equality
    (is (= 42 (* 6 7)))
    
    ;; Truth
    (is (true? true))
    (is (false? false))
    
    ;; nil checks
    (is (nil? nil))
    (is (some? "not nil"))
    
    ;; Exception testing
    (is (thrown? ArithmeticException (/ 1 0)))
    (is (thrown-with-msg? ArithmeticException #"Divide by zero" (/ 1 0)))
    
    ;; Collections
    (is (contains? #{1 2 3} 2))
    (is (= [1 2 3] (sort [3 1 2])))))

;; =============================================================================
;; TESTING FUNCTIONS
;; =============================================================================

;; Example functions to test
(defn fibonacci [n]
  (cond
    (<= n 0) 0
    (= n 1) 1
    :else (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))

(defn factorial [n]
  (if (<= n 1)
    1
    (* n (factorial (- n 1)))))

;; Tests for these functions
(deftest fibonacci-test
  (testing "Fibonacci sequence"
    (is (= 0 (fibonacci 0)))
    (is (= 1 (fibonacci 1)))
    (is (= 1 (fibonacci 2)))
    (is (= 2 (fibonacci 3)))
    (is (= 3 (fibonacci 4)))
    (is (= 5 (fibonacci 5)))
    (is (= 8 (fibonacci 6)))))

(deftest factorial-test
  (testing "Factorial calculation"
    (is (= 1 (factorial 0)))
    (is (= 1 (factorial 1)))
    (is (= 2 (factorial 2)))
    (is (= 6 (factorial 3)))
    (is (= 24 (factorial 4)))
    (is (= 120 (factorial 5)))))

;; =============================================================================
;; FIXTURES - SETUP AND TEARDOWN
;; =============================================================================

;; use-fixtures runs setup/teardown around tests
(def test-data (atom {}))

(defn setup-test-data [f]
  (reset! test-data {:users [{:id 1 :name "Alice"}
                            {:id 2 :name "Bob"}]})
  (f)  ; Run the test
  (reset! test-data {}))  ; Cleanup

;; Apply fixture to all tests in this namespace
(use-fixtures :each setup-test-data)

(deftest test-with-fixture
  (testing "Test data is available"
    (is (= 2 (count (:users @test-data))))
    (is (= "Alice" (-> @test-data :users first :name)))))

;; =============================================================================
;; TESTING SIDE EFFECTS
;; =============================================================================

;; Testing functions with side effects using with-redefs
(defn send-email [to subject body]
  ;; In real code, this would send an email
  (println "Sending email to:" to)
  {:sent true :to to})

(defn notify-user [user message]
  (send-email (:email user) "Notification" message))

(deftest notify-user-test
  (testing "User notification"
    (let [emails-sent (atom [])]
      (with-redefs [send-email (fn [to subject body]
                                (swap! emails-sent conj {:to to :subject subject :body body})
                                {:sent true :to to})]
        (let [user {:email "test@example.com"}
              result (notify-user user "Hello!")]
          (is (= {:sent true :to "test@example.com"} result))
          (is (= 1 (count @emails-sent)))
          (is (= "test@example.com" (:to (first @emails-sent)))))))))

;; Memory Tip: with-redefs temporarily replaces functions for testing

;; =============================================================================
;; PROPERTY-BASED TESTING
;; =============================================================================

;; test.check provides property-based testing
;; Add to deps.edn: org.clojure/test.check {:mvn/version "1.1.1"}

;; (require '[clojure.test.check :as tc]
;;          '[clojure.test.check.generators :as gen]
;;          '[clojure.test.check.properties :as prop]
;;          '[clojure.test.check.clojure-test :refer [defspec]])

;; Property-based test example:
;; (defspec reverse-twice-is-identity
;;   100  ; Number of test cases
;;   (prop/for-all [v (gen/vector gen/int)]
;;     (= v (reverse (reverse v)))))

;; =============================================================================
;; MOCKING AND STUBBING
;; =============================================================================

;; Simple mock using atoms
(defn create-mock []
  (let [calls (atom [])]
    {:fn (fn [& args] 
           (swap! calls conj args)
           :mocked-result)
     :calls calls}))

(deftest mock-example
  (testing "Function call tracking"
    (let [mock (create-mock)]
      ((:fn mock) "arg1" "arg2")
      ((:fn mock) "arg3")
      (is (= [["arg1" "arg2"] ["arg3"]] @(:calls mock))))))

;; =============================================================================
;; TESTING BEST PRACTICES
;; =============================================================================

;; 1. Write tests first (TDD) or alongside code
;; 2. Test behavior, not implementation
;; 3. Use descriptive test names and descriptions
;; 4. Keep tests independent and deterministic
;; 5. Test edge cases and error conditions
;; 6. Use fixtures for common setup
;; 7. Mock external dependencies

;; =============================================================================
;; RUNNING TESTS
;; =============================================================================

;; Run tests from REPL:
;; (run-tests)
;; (run-tests 'my.namespace)

;; Run from command line:
;; clj -X:test
;; lein test

;; =============================================================================
;; ADDITIONAL TESTING LIBRARIES
;; =============================================================================

;; 1. midje - Alternative testing framework with mocking
;; 2. test.check - Property-based testing
;; 3. clj-http-fake - HTTP client mocking
;; 4. with-redefs-fn - Dynamic function replacement
;; 5. bond - Spying and stubbing

;; Memory Bank Notes:
;; - Tests are functions with assertions
;; - Use is for assertions, testing for grouping
;; - deftest creates test functions
;; - use-fixtures for setup/teardown
;; - with-redefs for mocking side effects
;; - Test behavior, not implementation details
;; - Keep tests fast, independent, and deterministic
