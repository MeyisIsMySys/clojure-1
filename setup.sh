#!/bin/bash
# Setup script for Clojure Learning Environment using mise

set -e

echo "🚀 Setting up Clojure Learning Environment..."

# Check if mise is installed
if ! command -v mise &> /dev/null; then
    echo "❌ mise is not installed. Please install mise first:"
    echo "   macOS: brew install mise"
    echo "   Linux: curl https://mise.run | sh"
    echo "   See: https://mise.jdx.dev/getting-started.html"
    exit 1
fi

echo "✅ mise found, proceeding with setup..."

# Install all tools defined in .mise.toml
echo "📦 Installing Clojure development tools..."
mise install

# Activate the environment
echo "🔧 Activating environment..."
mise exec -- bash -c 'echo "Environment activated"'

# Test the installation
echo "🧪 Testing installation..."
mise run test-setup

echo ""
echo "🎉 Setup complete! Your Clojure learning environment is ready."
echo ""
echo "📚 Next steps:"
echo "   1. Run 'mise run memory-bank' to start learning"
echo "   2. Run 'mise run repl' to start a Clojure REPL"
echo "   3. Run 'mise run exercises' to open practice exercises"
echo ""
echo "💡 Available commands:"
echo "   - mise run repl          # Start Clojure REPL"
echo "   - mise run bb-repl       # Start Babashka REPL"
echo "   - mise run memory-bank   # Open learning materials"
echo "   - mise run exercises     # Open practice exercises"
echo "   - mise run quick-ref     # Open quick reference"
echo ""
echo "🔧 Optional: Install VS Code command line tools for better integration:"
echo "   - Open VS Code -> Command Palette (Cmd+Shift+P) -> 'Shell Command: Install code in PATH'"
echo ""
echo "Happy learning! 🎓"
