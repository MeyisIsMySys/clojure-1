;; 08-concurrency/01-concurrency-basics.clj
;; Clojure Concurrency - Safe parallel programming
;; 
;; Memory Note: Clojure provides excellent concurrency primitives
;; Built on immutable data structures for thread safety

(ns memory-bank.concurrency.basics
  "Introduction to Clojure's concurrency model")

;; =============================================================================
;; IMMUTABILITY AND THREAD SAFETY
;; =============================================================================

;; Clojure's immutable data structures are inherently thread-safe
;; No locks needed for reading immutable data

(def shared-data {:users 1000 :posts 5000})

;; Multiple threads can safely read this without synchronization

;; =============================================================================
;; ATOMS - SYNCHRONOUS COORDINATED STATE
;; =============================================================================

;; Atoms provide atomic updates to a single reference
(def counter (atom 0))

;; Safe atomic increment
(swap! counter inc)
@counter  ; => 1

;; Atomic update with function
(swap! counter + 10)
@counter  ; => 11

;; Reset to specific value
(reset! counter 100)
@counter  ; => 100

;; Memory Tip: Use atoms for independent state that needs atomic updates

;; =============================================================================
;; REFS AND SOFTWARE TRANSACTIONAL MEMORY (STM)
;; =============================================================================

;; Refs provide coordinated synchronous updates using STM
(def account-a (ref 1000))
(def account-b (ref 500))

;; Transfer money atomically
(defn transfer [from to amount]
  (dosync
    (alter from - amount)
    (alter to + amount)))

;; All changes in dosync happen atomically or not at all
;; (transfer account-a account-b 100)

;; Memory Tip: Use refs when you need to coordinate multiple pieces of state

;; =============================================================================
;; AGENTS - ASYNCHRONOUS UPDATES
;; =============================================================================

;; Agents handle asynchronous state changes
(def logger (agent []))

;; Send asynchronous update
(send logger conj "Log entry 1")
(send logger conj "Log entry 2")

;; Check current state
@logger  ; Eventually => ["Log entry 1" "Log entry 2"]

;; Memory Tip: Use agents for asynchronous operations and fire-and-forget updates

;; =============================================================================
;; FUTURES AND PROMISES
;; =============================================================================

;; Future - run computation in background
(def future-result 
  (future 
    (Thread/sleep 1000)  ; Simulate work
    (* 6 7)))

;; Get result (blocks if not ready)
@future-result  ; => 42

;; Promise - manual completion
(def promise-result (promise))

;; Deliver value from another thread
(future (deliver promise-result "Hello from the future!"))

;; Get the promised value
@promise-result  ; => "Hello from the future!"

;; =============================================================================
;; PMAP - PARALLEL MAP
;; =============================================================================

;; Parallel map for CPU-intensive operations
(defn slow-square [x]
  (Thread/sleep 100)  ; Simulate slow operation
  (* x x))

;; Sequential
(time (doall (map slow-square (range 10))))

;; Parallel (faster for CPU-bound tasks)
(time (doall (pmap slow-square (range 10))))

;; Memory Tip: Use pmap when map operations are CPU-intensive

;; =============================================================================
;; PRACTICAL EXAMPLES
;; =============================================================================

;; Example: Thread-safe counter with statistics
(def stats (atom {:count 0 :total 0}))

(defn add-number [n]
  (swap! stats 
         #(-> %
              (update :count inc)
              (update :total + n))))

;; Example: Producer-consumer with agents
(def work-queue (agent []))
(def results (agent []))

(defn add-work [item]
  (send work-queue conj item))

(defn process-work []
  (send work-queue 
        (fn [queue]
          (when-let [item (first queue)]
            (send results conj (* item item))  ; Process item
            (rest queue)))))

;; =============================================================================
;; BEST PRACTICES
;; =============================================================================

;; 1. Prefer immutable data structures
;; 2. Use atoms for independent state
;; 3. Use refs for coordinated state changes
;; 4. Use agents for asynchronous operations
;; 5. Use futures for parallel computations
;; 6. Avoid locks and mutable state when possible

;; Memory Bank Notes:
;; - Immutability eliminates most concurrency issues
;; - Atoms: synchronous, atomic, independent updates
;; - Refs: synchronous, coordinated updates via STM
;; - Agents: asynchronous, independent updates
;; - Futures: parallel computation with eventual results
;; - Always prefer Clojure's concurrency primitives over Java's
