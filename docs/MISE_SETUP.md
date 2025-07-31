# Mise Configuration Guide for Clojure Learning

This document explains how to use mise to manage your Clojure learning environment.

## 🎯 What is mise?

[mise](https://mise.jdx.dev/) is a development environment manager that automatically installs and manages programming language tools and runtimes. It replaces the need to manually install Java, Clojure CLI, Leiningen, and other tools.

## 🔧 Tools Included

Our `.mise.toml` configuration automatically installs:

- **Java OpenJDK 21** - Required runtime for Clojure
- **Clojure CLI** - Official Clojure development tool
- **Leiningen** - Popular build tool and project manager
- **Babashka** - Fast-starting Clojure scripting environment
- **Node.js LTS** - For ClojureScript development
- **Git** - Version control

## 🚀 Quick Start

### 1. Install mise

**macOS:**
```bash
brew install mise
```

**Linux/WSL:**
```bash
curl https://mise.run | sh
```

**Manual installation:** See [mise installation guide](https://mise.jdx.dev/getting-started.html)

### 2. Set up environment

```bash
# Run the automated setup script
./setup.sh

# Or manually install tools
mise install

# Activate the environment
mise shell
```

### 3. Verify installation

```bash
mise run test-setup
```

## 📋 Available Commands

### Development REPLs
```bash
mise run repl          # Start Clojure CLI REPL
mise run lein-repl     # Start Leiningen REPL
mise run bb-repl       # Start Babashka REPL
```

### Learning Resources
```bash
mise run memory-bank   # Open main learning materials
mise run exercises     # Open practice exercises
mise run quick-ref     # Open quick reference guide
```

### Project Management
```bash
mise run new-project my-app    # Create new Leiningen project
mise run setup                 # Setup development environment
mise run test-setup           # Verify all tools work
```

## 🛠 Tool Details

### Java (OpenJDK 21)
- **Purpose**: Required runtime for all Clojure applications
- **Version**: Latest LTS version (21)
- **Usage**: Automatically used by Clojure tools

### Clojure CLI
- **Purpose**: Official Clojure development tool
- **Features**: REPL, dependency management, project building
- **Usage**: `clj` command for starting REPL and running code

### Leiningen
- **Purpose**: Build automation and dependency management
- **Features**: Project templates, testing, packaging
- **Usage**: `lein` command for project management

### Babashka
- **Purpose**: Fast-starting Clojure for scripting
- **Features**: Instant startup, shell scripting, task automation
- **Usage**: `bb` command for scripts and quick tasks

## 📝 Environment Variables

Our configuration sets these environment variables:

- `EDITOR=code` - Default editor set to VS Code
- `CLJ_CONFIG=.clojure` - Local Clojure configuration

## 🎓 Learning Workflow

### 1. Daily Learning Session
```bash
# Start your learning session
mise run memory-bank

# Open REPL for experimentation
mise run repl

# Practice with exercises
mise run exercises
```

### 2. Working on Projects
```bash
# Create a new project
mise run new-project my-clojure-app

# Navigate to project and start REPL
cd my-clojure-app
mise run lein-repl
```

### 3. Quick Reference
```bash
# Need to look something up?
mise run quick-ref
```

## 🔧 Customization

You can modify `.mise.toml` to:

### Add more tools
```toml
[tools]
# Add ClojureScript compiler
cljs = "latest"

# Add shadow-cljs for frontend development
"npm:shadow-cljs" = "latest"
```

### Create custom tasks
```toml
[tasks.my-task]
description = "My custom task"
run = "echo 'Hello from my task!'"
```

### Set environment variables
```toml
[env]
MY_VAR = "my-value"
```

## 🐛 Troubleshooting

### Tools not found
```bash
# Reinstall all tools
mise install

# Check what's installed
mise list

# Install specific tool
mise install java@openjdk-21
```

### REPL won't start
```bash
# Check Java installation
java -version

# Test Clojure specifically
clj -e "(println \"Hello, Clojure!\")"

# Run diagnostic
mise run test-setup
```

### Environment not activated
```bash
# Activate mise environment
mise shell

# Or run commands through mise
mise exec -- clj
```

## 📚 Additional Resources

- [mise documentation](https://mise.jdx.dev/)
- [Clojure CLI Guide](https://clojure.org/guides/getting_started)
- [Leiningen Tutorial](https://leiningen.org/tutorial.html)
- [Babashka Guide](https://github.com/babashka/babashka)

## 🎯 Next Steps

1. **Complete the setup**: Run `./setup.sh`
2. **Start learning**: Run `mise run memory-bank`
3. **Practice daily**: Use `mise run repl` for experimentation
4. **Build projects**: Use `mise run new-project` when ready

Your Clojure learning environment is now fully automated and reproducible! 🎉
