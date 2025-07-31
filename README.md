# Clojure Learning Memory Bank

A comprehensive, structured learning repository for mastering Clojure programming from beginner to advanced level.

## 🎯 Purpose

This repository serves as your complete Clojure learning journey, featuring:
- **Structured Learning Path** - Progressive curriculum from fundamentals to advanced topics
- **Interactive Learning** - REPL-driven development and hands-on examples
- **Practical Application** - Real-world projects and exercises
- **Complete Reference** - Quick lookup guides and best practices
- **Production-Ready Setup** - Automated environment with `mise` tooling

## 📚 What's Inside

The `memory-bank/` directory contains our comprehensive Clojure curriculum:

### 📖 Core Learning Modules
- **01-fundamentals/** - Core concepts, syntax, and REPL mastery
- **02-data-structures/** - Lists, vectors, maps, sets, and sequences
- **03-functions/** - Function definition, higher-order functions, and composition
- **04-flow-control/** - Conditionals, loops, and control structures
- **05-namespaces/** - Code organization and module system
- **06-java-interop/** - Java integration and JVM ecosystem leverage

### 🚀 Advanced Topics
- **07-macros/** - Metaprogramming and code transformation
- **08-concurrency/** - Atoms, refs, agents, and async programming
- **09-web-development/** - Ring, Compojure, and full-stack development
- **10-testing/** - Testing strategies and frameworks

### 🎯 Practice & Application
- **99-exercises/** - Hands-on practice problems with solutions
- **99-projects/** - Real-world project ideas from beginner to advanced
- **99-reference/** - Quick reference guides and learning tips

## 🚀 Getting Started

### Option 1: Automated Setup with mise (Recommended) ⭐

The fastest way to start learning is using [mise](https://mise.jdx.dev/) for automatic tool management:

**macOS:**
```bash
# Install mise
brew install mise

# Run automated setup
./setup.sh

# Start learning immediately
mise run memory-bank
```

**Linux/WSL:**
```bash
# Install mise
curl https://mise.run | sh

# Run automated setup
./setup.sh

# Start learning immediately
mise run memory-bank
```

### Option 2: Manual Installation

If you prefer manual setup:

1. **Install Java** (OpenJDK 11+)
2. **Install Clojure CLI**: Follow the [official guide](https://clojure.org/guides/install_clojure)
3. **Start learning**: Begin with `memory-bank/01-fundamentals/01-getting-started.clj`
4. **Use the REPL**: Practice each concept interactively
5. **Work through exercises**: Apply knowledge with `memory-bank/99-exercises/`
6. **Build projects**: Apply skills with `memory-bank/99-projects/`

### 🎯 Essential Commands (with mise)

```bash
# Learning & Development
mise run memory-bank   # 📚 Open main learning materials
mise run exercises     # 🎯 Practice problems and solutions
mise run quick-ref     # ⚡ Quick reference guide

# REPL Development
mise run repl          # 🔧 Start Clojure CLI REPL
mise run bb-repl       # ⚡ Start Babashka REPL (fast startup)

# Project Creation
mise run new-project my-app    # 📦 Create new Clojure project
mise run test-setup            # ✅ Verify environment setup
```

## 📖 Learning Path

Your structured journey to Clojure mastery:

```
📚 FOUNDATION (Weeks 1-4)
├── 01-fundamentals/      → Master basic syntax and REPL workflow
├── 02-data-structures/   → Learn Clojure's powerful data types
├── 03-functions/         → Understand functional programming
└── 04-flow-control/      → Control structures and iteration

🔧 INTERMEDIATE (Weeks 5-8)
├── 05-namespaces/        → Code organization and modularity
├── 06-java-interop/      → Leverage the JVM ecosystem
└── 10-testing/           → Testing strategies and frameworks

🚀 ADVANCED (Weeks 9-12)
├── 07-macros/            → Metaprogramming and DSLs
├── 08-concurrency/       → Concurrent and parallel programming
└── 09-web-development/   → Full-stack web applications

🎯 MASTERY (Ongoing)
├── 99-exercises/         → Practice problems and solutions
├── 99-projects/          → Real-world application projects
└── 99-reference/         → Quick lookup and best practices
```

## 🎓 Learning Philosophy

This memory bank follows proven educational principles:

### 🔄 REPL-Driven Development
- **Interactive Learning** - Experiment with every concept immediately
- **Immediate Feedback** - See results instantly as you learn
- **Incremental Building** - Build understanding step by step

### 📈 Progressive Complexity
- **Solid Foundations** - Master basics before advancing
- **Scaffolded Learning** - Each topic builds on previous knowledge
- **Practical Application** - Apply concepts through exercises and projects

### 💡 Best Practices Focus
- **Idiomatic Clojure** - Learn the "Clojure way" from the start
- **Real-world Examples** - Code you can use and modify
- **Production Ready** - Patterns and practices used in industry

### 🎯 Practical Mastery
- **Hands-on Learning** - Learn by doing, not just reading
- **Problem Solving** - Apply knowledge to solve real problems
- **Project Based** - Build actual applications to solidify skills

## 🛠 Development Environment

Our setup provides a complete, professional Clojure development environment:

### 🔧 Included Tools
- **Java OpenJDK 21** - Latest LTS runtime for optimal performance
- **Clojure CLI** - Official development and build tool
- **Babashka** - Fast-starting scripting and task automation
- **Node.js LTS** - For ClojureScript and modern web development

### 📁 Project Structure
```
clojure-learning/
├── .mise.toml              # Automated tool management
├── setup.sh                # One-command environment setup
├── memory-bank/            # Complete learning curriculum
│   ├── 01-fundamentals/    # Core concepts and syntax
│   ├── 02-data-structures/ # Collections and sequences
│   ├── 03-functions/       # Functional programming
│   ├── 04-flow-control/    # Control structures
│   ├── 05-namespaces/      # Code organization
│   ├── 06-java-interop/    # JVM integration
│   ├── 07-macros/          # Metaprogramming
│   ├── 08-concurrency/     # Parallel programming
│   ├── 09-web-development/ # Web applications
│   ├── 10-testing/         # Testing strategies
│   ├── 99-exercises/       # Practice problems
│   ├── 99-projects/        # Real-world projects
│   └── 99-reference/       # Quick references
├── docs/                   # Setup and configuration guides
└── new1/                   # Example project structure
```

## 🤝 Contributing

We welcome contributions that enhance the learning experience! See our detailed guides:

- **[Contributing Guide](.github/CONTRIBUTING.md)** - How to contribute effectively
- **[Conventional Commits](.github/CONVENTIONAL_COMMITS.md)** - Commit message standards
- **[Project Configuration](.github/PROJECT_CONFIG.md)** - Development setup

### Quick Start for Contributors
```bash
# Setup development environment
./setup.sh

# Make your changes following our standards
# Commit with conventional format
git commit -m "feat(fundamentals): add advanced REPL techniques"

# Submit pull request
```

## 📝 Documentation

Comprehensive guides for every aspect of your Clojure journey:

- **[Setup Guide](docs/MISE_SETUP.md)** - Complete environment configuration
- **[Memory Bank Guide](memory-bank/README.md)** - Learning curriculum overview
- **[Project Ideas](memory-bank/99-projects/project-ideas.md)** - Hands-on project suggestions
- **[Quick Reference](memory-bank/99-reference/quick-reference.clj)** - Syntax and patterns
- **[Learning Notes](memory-bank/99-reference/learning-notes.clj)** - Tips and best practices

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

**Ready to start your Clojure journey?** 🚀

Run `./setup.sh` and then `mise run memory-bank` to begin!
