;; Conventional Commits Quick Reference for Clojure Memory Bank
;; This file provides quick examples of commit message patterns for this project

;; Basic Format: type(scope): description

;; =============================================================================
;; ADDING NEW LEARNING CONTENT
;; =============================================================================

;; New tutorials and explanations
;; feat(fundamentals): add REPL debugging commands
;; feat(data-structures): add sequence manipulation examples  
;; feat(functions): add higher-order function tutorial
;; feat(macros): add macro hygiene best practices
;; feat(concurrency): add core.async introduction

;; New exercises
;; feat(exercises): add beginner problems for functions
;; feat(exercises): add intermediate data structure challenges
;; feat(exercises): add advanced macro writing exercises

;; New projects
;; feat(projects): add web scraper project template
;; feat(projects): add CLI tool project guide
;; feat(projects): add game development starter

;; =============================================================================
;; FIXING ERRORS AND ISSUES  
;; =============================================================================

;; Code example fixes
;; fix(functions): correct recursion base case example
;; fix(data-structures): update vector indexing syntax
;; fix(java-interop): fix Java method call examples
;; fix(namespaces): correct require syntax in examples

;; Documentation fixes
;; fix(readme): correct installation command for Windows
;; fix(setup): update dependency versions
;; fix(exercises): fix typo in problem description

;; =============================================================================
;; IMPROVING DOCUMENTATION
;; =============================================================================

;; README and setup guides
;; docs(readme): add troubleshooting section
;; docs(setup): clarify REPL configuration steps  
;; docs(contributing): add code review guidelines

;; Learning material documentation
;; docs(fundamentals): add cross-references to related topics
;; docs(functions): improve explanation clarity
;; docs(exercises): add solution hints and guidance

;; =============================================================================
;; REORGANIZING AND REFACTORING
;; =============================================================================

;; Content organization
;; refactor(exercises): group problems by difficulty
;; refactor(functions): split large file into focused topics
;; refactor(projects): reorganize by complexity level

;; Code improvements (without changing behavior)
;; refactor(data-structures): improve example readability
;; refactor(namespaces): simplify namespace examples
;; refactor(reference): consolidate quick reference guides

;; =============================================================================
;; STYLING AND FORMATTING
;; =============================================================================

;; Code formatting
;; style(fundamentals): improve code indentation
;; style(functions): add consistent commenting style
;; style(exercises): format solution code consistently

;; Documentation formatting  
;; style(readme): improve markdown formatting
;; style(reference): standardize quick reference layout

;; =============================================================================
;; TESTING AND VALIDATION
;; =============================================================================

;; Adding tests
;; test(functions): add validation for example outputs
;; test(data-structures): add edge case testing
;; test(exercises): add solution verification tests

;; =============================================================================
;; MAINTENANCE AND CHORES
;; =============================================================================

;; Dependencies and build
;; chore: update Clojure version to 1.11.1
;; chore(setup): update VS Code extensions list
;; build: add linting configuration

;; GitHub and CI
;; ci: add commit message validation
;; chore(github): update issue templates
;; build: configure automated testing

;; =============================================================================
;; SCOPES REFERENCE
;; =============================================================================

;; Learning Content Scopes:
;; - fundamentals      (01-fundamentals/)
;; - data-structures   (02-data-structures/)  
;; - functions         (03-functions/)
;; - flow-control      (04-flow-control/)
;; - namespaces        (05-namespaces/)
;; - java-interop      (06-java-interop/)
;; - macros            (07-macros/)
;; - concurrency       (08-concurrency/)
;; - web-dev           (09-web-development/)
;; - testing           (10-testing/)
;; - exercises         (99-exercises/)
;; - projects          (99-projects/)
;; - reference         (99-reference/)

;; Meta Scopes:
;; - setup             (Project setup and configuration)
;; - docs              (Documentation and guides)
;; - tooling           (Development tools and scripts)
;; - github            (GitHub-specific files)
;; - workspace         (VS Code workspace configuration)

;; =============================================================================
;; MEMORY TIPS
;; =============================================================================

;; ✅ DO:
;; - Use imperative mood: "add" not "added"
;; - Start with lowercase
;; - Keep description under 50 characters
;; - Be specific about what changed
;; - Include scope when modifying specific sections

;; ❌ DON'T:
;; - Use vague descriptions like "fix stuff" or "update files"
;; - Include periods at end of description
;; - Write in past tense
;; - Make descriptions too long
;; - Forget to test examples before committing

;; Examples of GOOD commit messages:
;; feat(functions): add partial application examples
;; fix(data-structures): correct map merge syntax error  
;; docs(readme): add Windows setup instructions
;; refactor(exercises): group by difficulty level
;; style(fundamentals): improve code formatting

;; Examples of BAD commit messages:
;; Added some examples
;; Fix.
;; Updated stuff in functions
;; feat(functions): Added really comprehensive examples about partial application that will help users understand this concept much better.
;; Fixed the bug

;; For complete guidelines, see: .github/CONVENTIONAL_COMMITS.md
