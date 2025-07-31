;; Namespaces in Clojure
;; Namespaces provide code organization and prevent naming conflicts

;; 1. NAMESPACE BASICS

;; ns - declare a namespace (usually at the top of file)
(ns my-app.core
  "Main application namespace"  ; optional docstring
  (:require [clojure.string :as str]
            [clojure.set :refer [union intersection]]
            [clojure.data.json :as json])
  (:import [java.util Date]
           [java.io File]))

;; Current namespace
*ns*  ; => #namespace[my-app.core]

;; List all namespaces
(all-ns)

;; Find namespace by name
(find-ns 'clojure.core)

;; 2. REQUIRING NAMESPACES

;; require - load namespace
(require 'clojure.string)
(clojure.string/upper-case "hello")  ; => "HELLO"

;; require with alias
(require '[clojure.string :as str])
(str/upper-case "hello")  ; => "HELLO"

;; require with refer (import specific functions)
(require '[clojure.string :refer [upper-case lower-case]])
(upper-case "hello")  ; => "HELLO"

;; require with refer :all (import all public functions)
(require '[clojure.string :refer :all])

;; 3. USE (DISCOURAGED)
;; use is like require + refer :all, but discouraged

(use 'clojure.set)  ; imports all functions into current namespace
;; Better to use require with specific refers

;; 4. CREATING FUNCTIONS IN NAMESPACES

;; Functions defined with defn are public by default
(defn public-function
  "This function is accessible from other namespaces"
  [x]
  (* x 2))

;; Private functions (namespace-internal only)
(defn- private-function
  "This function is only accessible within this namespace"
  [x]
  (+ x 1))

;; Alternative private syntax
(def ^:private another-private-fn
  (fn [x] (- x 1)))

;; 5. NAMESPACE-QUALIFIED SYMBOLS

;; Fully qualified name
clojure.core/+
my-app.core/public-function

;; Auto-resolved keywords (Clojure 1.9+)
::my-keyword  ; resolves to :my-app.core/my-keyword

;; 6. NAMESPACE ALIASES

;; Create alias for current session
(alias 'str 'clojure.string)
(str/join "," ["a" "b" "c"])

;; 7. IMPORTING JAVA CLASSES

;; import - bring Java classes into namespace
(import 'java.util.Date)
(Date.)  ; create new Date instance

;; import multiple classes from same package
(import '(java.util Date Calendar)
        '(java.io File FileReader))

;; 8. NAMESPACE UTILITIES

;; ns-name - get namespace name
(ns-name *ns*)  ; => my-app.core

;; ns-aliases - get namespace aliases
(ns-aliases *ns*)

;; ns-imports - get imported classes
(ns-imports *ns*)

;; ns-interns - get functions/vars in namespace
(ns-interns *ns*)

;; ns-publics - get public vars in namespace
(ns-publics 'clojure.string)

;; ns-refers - get referred functions
(ns-refers *ns*)

;; 9. REMOVING THINGS FROM NAMESPACE

;; ns-unalias - remove alias
(ns-unalias *ns* 'str)

;; ns-unmap - remove var from namespace
(ns-unmap *ns* 'my-function)

;; remove - remove specific refers
(ns-unmap *ns* 'upper-case)

;; 10. DYNAMIC NAMESPACE SWITCHING

;; in-ns - switch to namespace (create if doesn't exist)
(in-ns 'user)  ; switch to user namespace

;; Switch back
(in-ns 'my-app.core)

;; 11. NAMESPACE METADATA

;; Add metadata to namespace
(ns my-app.utils
  "Utility functions"
  {:author "Your Name"
   :version "1.0.0"})

;; Access namespace metadata
(meta (find-ns 'my-app.utils))

;; 12. COMMON NAMESPACE PATTERNS

;; Typical namespace declaration for application
(ns my-app.user-service
  "Service for managing users"
  (:require [clojure.string :as str]
            [clojure.data.json :as json]
            [my-app.database :as db]
            [my-app.validation :refer [validate-email]])
  (:import [java.util UUID Date]))

;; Typical namespace for utilities
(ns my-app.utils
  "Common utility functions"
  (:require [clojure.string :as str]
            [clojure.walk :as walk]))

;; Test namespace
(ns my-app.user-service-test
  (:require [clojure.test :refer [deftest is testing]]
            [my-app.user-service :as user-service]))

;; 13. NAMESPACE ORGANIZATION BEST PRACTICES

;; Directory structure should match namespace structure:
;; src/
;;   my_app/
;;     core.clj        -> (ns my-app.core)
;;     user_service.clj -> (ns my-app.user-service)
;;     utils/
;;       string.clj    -> (ns my-app.utils.string)
;;       math.clj      -> (ns my-app.utils.math)

;; File naming conventions:
;; - Use underscores in filenames for hyphens in namespace names
;; - my-app.user-service -> my_app/user_service.clj

;; 14. CONDITIONAL REQUIRES

;; Require based on available features
(ns my-app.core
  (:require [clojure.string :as str]
            [clojure.core.async :as async :include-macros true]
            #?(:clj [clojure.java.io :as io]
               :cljs [cljs.core.async.interop :refer-macros [<p!]])))

;; Reader conditionals for cross-platform code
#?(:clj  (import 'java.util.Date)
   :cljs (def Date js/Date))

;; 15. MEMORY TIPS

;; Namespace organization:
;; - One namespace per file
;; - File path matches namespace name
;; - Use descriptive namespace names
;; - Group related functionality

;; Requiring best practices:
;; - Use aliases for frequently used namespaces
;; - Refer only specific functions you need
;; - Avoid 'use' - prefer explicit requires
;; - Keep requires at top of file

;; Common aliases:
;; - str for clojure.string
;; - set for clojure.set
;; - json for data libraries
;; - db for database namespaces

;; Privacy:
;; - Use defn- for private functions
;; - Keep implementation details private
;; - Expose clean public APIs

;; Namespace loading:
;; - Namespaces are loaded on first reference
;; - Circular dependencies will cause errors
;; - Use forward declarations if needed
