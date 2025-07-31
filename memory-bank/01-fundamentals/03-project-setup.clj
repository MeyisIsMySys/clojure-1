;; Project Setup and Development Workflow
;; Complete guide to creating and managing Clojure projects

;; ===============================
;; ENVIRONMENT SETUP
;; ===============================

;; Using mise for environment management
;; mise.toml defines tools and tasks for consistent development

;; Required tools (automatically managed by mise):
;; - Java (OpenJDK 21 LTS)
;; - Clojure CLI (latest)
;; - Babashka (latest)
;; - Node.js (for ClojureScript)

;; ===============================
;; PROJECT CREATION
;; ===============================

;; 1. Install deps-new tool (one-time setup)
;; clj -Ttools install-latest :lib io.github.seancorfield/deps-new :as new

;; 2. Create new application project
;; clj -Tnew app :name my-project-name

;; 3. Available project templates:
;; - app: Standard application with main function
;; - lib: Library project for sharing code
;; - scratch: Minimal project for experimentation

;; Using mise task (after configuration):
;; mise run new-project my-project-name

;; ===============================
;; PROJECT STRUCTURE
;; ===============================

;; Standard Clojure project layout:
my-project/
├── deps.edn          ; Dependencies and build configuration
├── build.clj         ; Build script using tools.build
├── src/              ; Source code
│   └── my_project/
│       └── core.clj  ; Main namespace
├── test/             ; Test files
│   └── my_project/
│       └── core_test.clj
├── resources/        ; Resource files (config, data, etc.)
├── doc/              ; Documentation
├── README.md         ; Project documentation
└── .gitignore        ; Git ignore patterns

;; ===============================
;; DEVELOPMENT WORKFLOW
;; ===============================

;; 1. Start REPL for interactive development
;; cd my-project
;; clj                    ; or mise run repl

;; 2. Load and test code in REPL
;; (require '[my-project.core :as core] :reload)
;; (core/main-function)

;; 3. Run tests
;; clj -T:build test

;; 4. Build project
;; clj -T:build ci        ; Complete CI build including tests

;; ===============================
;; REPL-DRIVEN DEVELOPMENT
;; ===============================

;; Core philosophy: Write and test code interactively

;; Basic REPL workflow:
;; 1. Start REPL: clj
;; 2. Load namespace: (require '[my-project.core :as core])
;; 3. Evaluate expressions: (core/my-function args)
;; 4. Modify code in editor
;; 5. Reload: (require '[my-project.core :as core] :reload)
;; 6. Repeat testing

;; Useful REPL commands:
(doc function-name)       ; Show documentation
(source function-name)    ; Show source code
(find-doc "search-term")  ; Search documentation
(dir namespace)           ; List functions in namespace

;; ===============================
;; MISE TASKS REFERENCE
;; ===============================

;; Available mise tasks (run with: mise run <task-name>):

;; Development tasks:
;; repl          - Start Clojure REPL
;; bb-repl       - Start Babashka REPL
;; new-project   - Create new Clojure project

;; Setup and verification:
;; setup         - Set up development environment
;; test-setup    - Test that all tools are working

;; Learning resources:
;; memory-bank   - Open fundamentals tutorial
;; exercises     - Open beginner exercises
;; quick-ref     - Open quick reference guide

;; ===============================
;; DEPENDENCY MANAGEMENT
;; ===============================

;; deps.edn structure:
{:paths ["src" "resources"]
 :deps {org.clojure/clojure {:mvn/version "1.11.1"}}
 :aliases
 {:test {:extra-paths ["test"]
         :extra-deps {io.github.cognitect-labs/test-runner
                      {:git/tag "v0.5.1" :git/sha "dfb30dd"}}}
  :build {:deps {io.github.clojure/tools.build {:mvn/version "0.9.6"}}
          :ns-default build}}}

;; Add dependencies by editing deps.edn:
;; {:deps {org.clojure/clojure {:mvn/version "1.11.1"}
;;         cheshire/cheshire {:mvn/version "5.11.0"}}}

;; ===============================
;; COMMON PROJECT PATTERNS
;; ===============================

;; 1. Library project:
;; - Focus on reusable functions
;; - Comprehensive test coverage
;; - Clear API documentation

;; 2. Application project:
;; - Main entry point
;; - CLI argument handling
;; - Resource management

;; 3. Web application:
;; - Ring/Compojure for HTTP
;; - Database integration
;; - Template rendering

;; ===============================
;; BEST PRACTICES
;; ===============================

;; File organization:
;; - One namespace per file
;; - File path matches namespace: com.example.util → src/com/example/util.clj
;; - Use kebab-case for file names, convert to underscore for filesystem

;; Namespace naming:
;; - Use reverse domain notation: com.yourcompany.projectname.module
;; - Keep namespaces focused and cohesive
;; - Prefer specific names over generic ones

;; REPL development:
;; - Keep REPL running during development
;; - Test functions immediately after writing
;; - Use (comment ...) blocks for exploratory code
;; - Save useful REPL sessions in comment blocks

;; ===============================
;; TROUBLESHOOTING
;; ===============================

;; Common issues and solutions:

;; REPL won't start:
;; - Check Java installation: java -version
;; - Verify Clojure CLI: clj --version
;; - Check deps.edn syntax

;; Namespace not found:
;; - Verify file path matches namespace
;; - Check for typos in require statements
;; - Ensure file is saved

;; Dependencies not loading:
;; - Check deps.edn syntax
;; - Verify dependency coordinates
;; - Clear .cpcache if needed: rm -rf .cpcache

;; Exit REPL:
;; - (System/exit 0)
;; - Ctrl+C or Cmd+C
;; - In VS Code: Debug → Stop

;; ===============================
;; LEARNING PROGRESSION
;; ===============================

;; Beginner workflow:
;; 1. Create simple project: mise run new-project hello-world
;; 2. Start REPL and explore: clj
;; 3. Modify core.clj and reload in REPL
;; 4. Write simple tests

;; Intermediate workflow:
;; 1. Add external dependencies
;; 2. Organize code into multiple namespaces
;; 3. Use build automation
;; 4. Integrate with external tools

;; Advanced workflow:
;; 1. Custom project templates
;; 2. Advanced build configurations
;; 3. Performance optimization
;; 4. Deployment automation

;; Remember: Start simple, iterate quickly, and leverage the REPL!
