# Copilot Instructions for Clojure Learning Memory Bank

## Project Overview
This is a comprehensive Clojure learning memory bank designed to guide users from beginner to advanced level. The repository serves as a structured educational resource with practical examples, exercises, and project ideas.

## Repository Structure
```
memory-bank/
├── 01-fundamentals/          # Core Clojure concepts and syntax
├── 02-data-structures/       # Collections, sequences, and data manipulation
├── 03-functions/             # Functions, higher-order functions, composition
├── 04-flow-control/          # Conditionals, loops, control structures
├── 05-namespaces/            # Code organization and module system
├── 06-java-interop/          # Java integration and interoperability
├── 07-macros/                # Macro system (to be added)
├── 08-concurrency/           # Concurrency primitives (to be added)
├── 09-web-development/       # Web frameworks and libraries (to be added)
├── 10-testing/               # Testing frameworks and strategies (to be added)
├── 99-exercises/             # Practice problems and solutions
├── 99-projects/              # Project ideas from beginner to advanced
└── 99-reference/             # Quick references and learning tips
```

## Coding Standards and Conventions

### File Organization
- Use meaningful, descriptive filenames with numbers for ordering
- Include comprehensive docstrings and comments in all .clj files
- Organize content from basic to advanced concepts
- Provide practical, runnable examples in every file

### Code Style
- Follow standard Clojure conventions (kebab-case, meaningful names)
- Include type hints where performance matters
- Prefer pure functions and immutable data structures
- Use threading macros (-> and ->>) for clarity
- Add inline comments explaining concepts for learners

### Documentation Standards
- Every function should have a docstring explaining its purpose
- Include examples of usage in comments
- Explain the "why" behind patterns and idioms
- Reference related concepts and cross-link topics
- Add memory tips and gotchas for common mistakes

## When Assisting with This Project

### For New Content Creation
1. **Maintain Educational Focus**: Always explain concepts clearly with beginner-friendly language
2. **Include Practical Examples**: Provide runnable code that users can experiment with
3. **Progressive Complexity**: Build from simple to complex concepts
4. **Cross-Reference**: Link related topics and concepts
5. **Best Practices**: Show idiomatic Clojure patterns and explain why they're preferred

### For Code Examples
- Always include working, testable examples
- Add comments explaining each step for learning purposes
- Show multiple approaches when applicable (e.g., loop vs. reduce)
- Include common pitfalls and how to avoid them
- Demonstrate REPL usage and interactive development

### For Exercise Creation
- Provide clear problem statements
- Include solution hints or guidance
- Offer multiple difficulty levels
- Connect exercises to real-world scenarios
- Include test cases or expected outputs

### For Project Ideas
- Scale projects from beginner to advanced
- Include required libraries and setup instructions
- Break down complex projects into manageable steps
- Suggest learning goals for each project
- Provide architectural guidance

## Content Guidelines

### Learning Philosophy
- **REPL-Driven Development**: Emphasize interactive learning
- **Functional Thinking**: Guide transition from imperative to functional mindset
- **Data-First Approach**: Focus on data transformation patterns
- **Practical Application**: Connect theory to real-world usage

### Topic Coverage Priorities
1. **Core Language Features**: Syntax, data structures, functions
2. **Functional Programming**: Higher-order functions, composition, immutability
3. **Ecosystem Integration**: Java interop, popular libraries
4. **Development Practices**: Testing, debugging, performance
5. **Advanced Topics**: Macros, concurrency, metaprogramming

### Quality Standards
- All code must be syntactically correct and runnable
- Examples should be practical and relevant
- Explanations should be clear and beginner-friendly
- Include performance considerations when relevant
- Provide context for when to use different approaches

## Maintenance Guidelines

### Regular Updates
- Keep examples current with latest Clojure versions
- Update library recommendations and versions
- Add new exercises based on common learning challenges
- Expand project ideas with emerging patterns and libraries

### Content Review
- Ensure accuracy of all code examples
- Verify links to external resources
- Update deprecated patterns or functions
- Maintain consistency in explanations and style

### User Feedback Integration
- Add clarifications based on common questions
- Create new examples for frequently misunderstood concepts
- Expand sections that users find particularly valuable
- Address gaps in the learning progression

## Interaction Patterns

### When User Asks About Clojure Concepts
1. Check if the topic exists in the memory bank
2. Reference existing materials when applicable
3. Suggest which memory bank files to study
4. Offer to create new content if gaps exist
5. Provide REPL examples for immediate practice

### When User Needs Exercises or Practice
1. Direct to relevant exercise files
2. Create custom exercises based on their level
3. Suggest appropriate project ideas
4. Provide debugging help with memory bank references

### When User Wants to Extend the Memory Bank
1. Follow established file naming and organization patterns
2. Maintain consistent documentation standards
3. Ensure new content integrates with existing materials
4. Add cross-references to related topics

### When User Makes Commits or Requests Commit Messages
1. Follow Conventional Commits specification (see .github/CONVENTIONAL_COMMITS.md)
2. Use appropriate types: feat, fix, docs, refactor, style, test, chore
3. Include relevant scopes: fundamentals, data-structures, functions, etc.
4. Write imperative, descriptive commit messages under 50 characters
5. Examples:
   - `feat(macros): add basic macro hygiene tutorial`
   - `fix(exercises): correct solution for map problem`
   - `docs(readme): update setup instructions for Windows`
   - `refactor(functions): improve higher-order function examples`

## Success Metrics
- User progression through learning materials
- Practical application of concepts in projects
- Understanding of functional programming principles
- Ability to write idiomatic Clojure code
- Comfort with REPL-driven development workflow

Remember: This memory bank is designed to be a living document that grows with the user's learning journey. Always prioritize clarity, practical applicability, and progressive skill building.
