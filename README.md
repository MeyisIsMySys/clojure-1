# Clojure Learning Repository

A comprehensive memory bank and learning resource for mastering Clojure programming language.

## 🎯 Purpose

This repository serves as a structured learning path and reference guide for Clojure, containing organized examples, exercises, and project ideas to help you progress from beginner to advanced Clojure developer.

## 📚 What's Inside

The `memory-bank/` directory contains a comprehensive collection of Clojure learning materials:

- **Fundamentals** - Core concepts, syntax, and REPL usage
- **Data Structures** - Lists, vectors, maps, sets, and sequences
- **Functions** - Function definition, higher-order functions, and composition
- **Flow Control** - Conditionals, loops, and control structures
- **Namespaces** - Code organization and module system
- **Java Interop** - Working with Java classes and libraries
- **Exercises** - Hands-on practice problems
- **Projects** - Real-world project ideas to apply your knowledge
- **Reference** - Quick reference guides and learning tips

## 🚀 Getting Started

### Option 1: Automated Setup with mise (Recommended)

The easiest way to get started is using [mise](https://mise.jdx.dev/) to automatically install all required tools:

1. **Install mise** (if not already installed):
   ```bash
   # macOS
   brew install mise
   
   # Linux/WSL
   curl https://mise.run | sh
   ```

2. **Run the setup script**:
   ```bash
   ./setup.sh
   ```

3. **Start learning**:
   ```bash
   mise run memory-bank
   # or
   mise run repl
   ```

### Option 2: Manual Installation

1. **Install Clojure**: Follow the [official installation guide](https://clojure.org/guides/install_clojure)
2. **Install Java**: OpenJDK 11+ (included with mise setup)
3. **Start with fundamentals**: Begin with `memory-bank/01-fundamentals/01-getting-started.clj`
4. **Use the REPL**: Practice each concept interactively
5. **Work through exercises**: Apply what you learn with `memory-bank/99-exercises/`
6. **Build projects**: Apply your knowledge with project ideas in `memory-bank/99-projects/`

### Quick Commands (with mise)

```bash
mise run repl          # Start Clojure REPL
mise run lein-repl     # Start Leiningen REPL  
mise run bb-repl       # Start Babashka REPL
mise run memory-bank   # Open learning materials
mise run exercises     # Open practice exercises
mise run quick-ref     # Open quick reference
```

## 📖 Learning Path

```
01-fundamentals/     → Learn basic syntax and concepts
02-data-structures/  → Master Clojure's core data types
03-functions/        → Understand functional programming
04-flow-control/     → Learn control structures
05-namespaces/       → Organize your code
06-java-interop/     → Leverage the JVM ecosystem
99-exercises/        → Practice with hands-on problems
99-projects/         → Build real applications
99-reference/        → Quick lookup and tips
```

## 🎓 Learning Philosophy

This memory bank follows these principles:

- **REPL-Driven Development** - Learn by experimenting interactively
- **Progressive Complexity** - Start simple, build complexity gradually
- **Practical Examples** - Real-world code you can use and modify
- **Best Practices** - Learn the idiomatic Clojure way
- **Complete Reference** - Everything you need in one place

## 🤝 Contributing

Feel free to contribute by:
- Adding more exercises and examples
- Improving existing explanations
- Fixing errors or typos
- Suggesting new project ideas

## 📝 License

This project is open source and available under the [MIT License](LICENSE).
