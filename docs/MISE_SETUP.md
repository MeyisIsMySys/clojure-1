# Complete Clojure Environment Setup with mise

This guide will help you set up a complete, professional Clojure development environment using [mise](https://mise.jdx.dev/) for automatic tool management.

## 🎯 What is mise?

[mise](https://mise.jdx.dev/) is a development environment manager that automatically installs and manages programming language tools and runtimes. It replaces the need to manually install Java, Clojure CLI, and other development tools.

**Benefits for Clojure learning:**
- ✅ **One-command setup** - Install everything with `./setup.sh`
- ✅ **Version management** - Consistent tool versions across systems
- ✅ **Project isolation** - Per-project environment configuration
- ✅ **Task automation** - Pre-configured development commands
- ✅ **Cross-platform** - Works on macOS, Linux, and WSL

## 🔧 Included Development Tools

Our `.mise.toml` configuration automatically installs and manages:

### Core Clojure Stack
- **Java OpenJDK 21** - Latest LTS runtime with optimal performance
- **Clojure CLI** - Official Clojure development and build tool
- **Babashka** - Fast-starting Clojure scripting environment

### Additional Tools  
- **Node.js LTS** - For ClojureScript development and modern tooling
- **Git** - Version control (system-dependent)

### Development Features
- **Automated tool installation** - No manual downloads or configuration
- **Version consistency** - Same tool versions across all environments  
- **Task automation** - Pre-configured commands for common workflows
- **Environment isolation** - Project-specific configurations

## 🚀 Quick Start Setup

### Step 1: Install mise

**macOS (Homebrew):**
```bash
brew install mise
```

**Linux/WSL (Script):**
```bash
curl https://mise.run | sh
```

**Manual Installation:** 
See the [mise installation guide](https://mise.jdx.dev/getting-started.html) for other options.

### Step 2: Automated Environment Setup

**One-command setup (recommended):**
```bash
./setup.sh
```

**Manual setup (if needed):**
```bash
# Install all tools
mise install

# Activate environment  
mise shell

# Verify installation
mise run test-setup
```

### Step 3: Start Learning

```bash
# Begin learning journey
mise run memory-bank

# Or start experimenting immediately
mise run repl
```

## 📋 Development Commands

All commands use the format `mise run <command>` for consistency and environment isolation.

### 🎓 Learning & Education
```bash
mise run memory-bank   # 📚 Open main learning materials  
mise run exercises     # 🎯 Practice problems and solutions
mise run quick-ref     # ⚡ Quick syntax and pattern reference
```

### 🔧 REPL Development
```bash
mise run repl          # 🔧 Start Clojure CLI REPL (full features)
mise run bb-repl       # ⚡ Start Babashka REPL (fast startup)
```

### 📦 Project Management  
```bash
mise run new-project my-app    # 📦 Create new Clojure project
mise run setup                 # 🛠 Initialize development environment  
mise run test-setup            # ✅ Verify all tools are working
```

### 🔍 Environment Inspection
```bash
mise ls                        # List installed tools and versions
mise which clj                 # Show path to Clojure CLI
mise exec -- clj --version     # Run commands in mise environment
```

## 🛠 Tool Details & Features

### Java (OpenJDK 21)
- **Purpose**: Runtime environment for all Clojure applications
- **Version**: Latest LTS (Long Term Support) for stability and performance
- **Benefits**: Optimal performance, modern JVM features, enterprise-ready

### Clojure CLI  
- **Purpose**: Official Clojure development tool and REPL
- **Features**: 
  - Interactive REPL with full language support
  - Dependency management via `deps.edn`
  - Project building and task automation
  - Integration with development tools
- **Usage**: Primary tool for Clojure development

### Babashka
- **Purpose**: Fast-starting Clojure for scripting and automation
- **Features**:
  - Near-instant startup (vs ~2 seconds for Clojure CLI)
  - Most common Clojure functions and libraries
  - Perfect for shell scripting and quick tasks
  - Great for experimentation and learning
- **Usage**: Quick experiments, automation scripts, fast feedback

### Node.js (LTS)
- **Purpose**: JavaScript runtime for ClojureScript development
- **Features**:
  - ClojureScript compilation and tooling
  - Modern web development workflow
  - NPM package ecosystem access
- **Usage**: Frontend development, build tools, modern web apps

## 📝 Environment Configuration

Our mise setup configures optimal environment variables for Clojure development:

```toml
[env]
EDITOR = "code"        # Default editor set to VS Code
CLJ_CONFIG = ".clojure" # Local Clojure configuration directory
```

### 🎓 Optimized Learning Workflow

**Daily Learning Session (20-60 minutes):**

```bash
# 1. Start your learning session
mise run memory-bank

# 2. Open REPL for hands-on experimentation  
mise run repl

# 3. Practice with targeted exercises
mise run exercises

# 4. Look up syntax and patterns
mise run quick-ref
```

**Project Development Workflow:**

```bash
# 1. Create a new application project
mise run new-project my-clojure-app

# 2. Navigate to project directory
cd my-clojure-app

# 3. Start project-specific REPL
mise run repl

# 4. Begin REPL-driven development
# Load, test, modify, reload cycle
```

**Quick Reference and Lookup:**

```bash
# Need to quickly check something?
mise run quick-ref

# Want to see practical examples?
mise run memory-bank
```

## 🔧 Advanced Configuration

### Adding More Tools
Extend `.mise.toml` to include additional development tools:

```toml
[tools]
# Current tools...
java = "openjdk-21"
clojure = "latest"
babashka = "latest"
nodejs = "lts"

# Add ClojureScript for frontend development
"npm:shadow-cljs" = "latest"

# Add additional utilities
"npm:http-server" = "latest"  # Simple HTTP server
```

### Custom Task Creation
Add project-specific automation tasks:

```toml
[tasks.dev]
description = "Start development environment"
run = [
    "echo 'Starting development environment...'",
    "clj -M:dev",
]

[tasks.test-watch]
description = "Run tests in watch mode"
run = "clj -M:test --watch"

[tasks.build]
description = "Build production application"
run = "clj -T:build ci"
```

### Environment Customization
Set additional environment variables for your workflow:

```toml
[env]
# Existing configuration...
EDITOR = "code"
CLJ_CONFIG = ".clojure"

# Add custom configuration
JAVA_OPTS = "-Xmx2g -Xms1g"           # JVM memory settings
CLOJURE_PRINT_LENGTH = "100"          # REPL print length
CLOJURE_PRINT_LEVEL = "10"            # REPL print depth
```

## 🐛 Troubleshooting Guide

### Tools Not Found After Installation

**Symptoms:** Commands like `clj` or `bb` not found
**Solution:**
```bash
# Reinstall all tools
mise install

# Check what's installed
mise list

# Install specific tool if missing
mise install java@openjdk-21
mise install clojure@latest

# Ensure environment is activated
mise shell
```

### REPL Won't Start

**Symptoms:** Error when running `mise run repl`
**Diagnosis:**
```bash
# Check Java installation
java -version

# Test Clojure CLI directly
clj -e "(println \"Hello, Clojure!\")"

# Verify mise environment
mise run test-setup
```

**Common Solutions:**
- Ensure Java is properly installed: `mise install java@openjdk-21`
- Clear Clojure cache: `rm -rf ~/.clojure/.cpcache`
- Restart terminal session

### Environment Not Activated

**Symptoms:** Tools installed but not in PATH
**Solution:**
```bash
# Manually activate environment
mise shell

# Or run commands through mise
mise exec -- clj

# Check mise configuration
mise doctor
```

### Performance Issues

**Symptoms:** Slow REPL startup or poor performance
**Solution:**
```bash
# Use Babashka for quick tasks
mise run bb-repl

# Optimize JVM settings in .mise.toml
[env]
JAVA_OPTS = "-Xmx2g -XX:+UseG1GC"
```

### Package/Dependency Issues

**Symptoms:** Can't resolve dependencies
**Solution:**
```bash
# Clear dependency cache
rm -rf ~/.m2/repository

# Verify deps.edn syntax
clj -Sdescribe

# Check for network connectivity
clj -Sforce -e "(println \"Connected\")"
```

## 📚 Additional Resources & Next Steps

### 🔗 Essential Links
- **[mise Documentation](https://mise.jdx.dev/)** - Complete mise reference
- **[Clojure CLI Guide](https://clojure.org/guides/getting_started)** - Official Clojure CLI docs
- **[Babashka Guide](https://github.com/babashka/babashka)** - Fast Clojure scripting
- **[deps.edn Reference](https://clojure.org/guides/deps_and_cli)** - Dependency management

### 🎯 Your Next Steps

1. **✅ Complete Setup**
   ```bash
   ./setup.sh
   mise run test-setup
   ```

2. **📚 Start Learning**
   ```bash
   mise run memory-bank
   # Begin with 01-fundamentals/01-getting-started.clj
   ```

3. **🎯 Daily Practice**
   ```bash
   mise run repl        # Daily REPL experimentation
   mise run exercises   # Regular skill building
   ```

4. **📦 Build Projects** 
   ```bash
   mise run new-project my-first-app
   # When ready for real application development
   ```

### 💡 Pro Tips for Success

1. **Use the REPL Daily** - Even 10 minutes of experimentation builds muscle memory
2. **Embrace Interactive Development** - Load, test, modify, reload cycle
3. **Keep mise Updated** - Run `mise self-update` occasionally  
4. **Customize Your Environment** - Modify `.mise.toml` as you learn preferences
5. **Track Your Progress** - Use `my-learning-journey.md` to log insights

---

## 🎉 You're Ready!

Your complete Clojure development environment is now configured and ready. You have:

✅ **Professional tooling** - Java, Clojure CLI, Babashka, Node.js  
✅ **Automated workflows** - Pre-configured development commands  
✅ **Learning resources** - Structured curriculum and exercises  
✅ **Modern setup** - Version-managed, reproducible environment  

**Start your Clojure journey now:**
```bash
mise run memory-bank
```

Happy learning! 🚀
