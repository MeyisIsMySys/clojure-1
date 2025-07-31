# Conventional Commits Guide for Clojure Learning Memory Bank

This project follows the [Conventional Commits](https://www.conventionalcommits.org/) specification to maintain a clean and meaningful commit history that helps with automated changelog generation and semantic versioning.

## 📝 Commit Message Format

```
<type>[optional scope]: <description>

[optional body]

[optional footer(s)]
```

### Examples
```
feat(fundamentals): add advanced REPL commands section
fix(data-structures): correct vector indexing example
docs(readme): update installation instructions
refactor(exercises): improve beginner exercise clarity
```

## 🏷️ Commit Types

### Primary Types (Most Common)

| Type | Description | Example |
|------|-------------|---------|
| `feat` | New feature or learning content | `feat(macros): add basic macro tutorial` |
| `fix` | Bug fix or correction | `fix(functions): correct syntax error in example` |
| `docs` | Documentation updates | `docs(contributing): add commit message guidelines` |
| `refactor` | Code restructuring without changing functionality | `refactor(exercises): reorganize beginner problems` |
| `style` | Code formatting, missing semicolons, etc. | `style(fundamentals): improve code formatting` |
| `test` | Adding or updating tests | `test(data-structures): add validation tests` |
| `chore` | Maintenance tasks | `chore: update dependencies` |

### Secondary Types (Less Common)

| Type | Description | Example |
|------|-------------|---------|
| `perf` | Performance improvements | `perf(functions): optimize recursive examples` |
| `build` | Build system or external dependencies | `build: add new linting configuration` |
| `ci` | Continuous integration changes | `ci: add GitHub Actions workflow` |
| `revert` | Reverting previous commits | `revert: "feat(macros): add advanced examples"` |

## 🎯 Scopes for This Project

Use these scopes to indicate which part of the memory bank you're modifying:

### Learning Content Scopes
- `fundamentals` - Basic Clojure concepts (01-fundamentals/)
- `data-structures` - Collections and sequences (02-data-structures/)
- `functions` - Functions and FP concepts (03-functions/)
- `flow-control` - Control structures (04-flow-control/)
- `namespaces` - Code organization (05-namespaces/)
- `java-interop` - Java integration (06-java-interop/)
- `macros` - Macro system (07-macros/)
- `concurrency` - Concurrency primitives (08-concurrency/)
- `web-dev` - Web development (09-web-development/)
- `testing` - Testing frameworks (10-testing/)
- `exercises` - Practice problems (99-exercises/)
- `projects` - Project ideas (99-projects/)
- `reference` - Quick references (99-reference/)

### Meta Scopes
- `setup` - Project setup and configuration
- `docs` - Documentation and guides
- `tooling` - Development tools and scripts
- `github` - GitHub-specific files (.github/)
- `workspace` - VS Code workspace configuration

## 📋 Writing Guidelines

### Description (Required)
- Use imperative mood: "add" not "added" or "adds"
- Start with lowercase letter
- No period at the end
- Maximum 50 characters
- Be specific and descriptive

**Good Examples:**
```
feat(fundamentals): add REPL debugging techniques
fix(data-structures): correct map destructuring syntax
docs(readme): clarify setup instructions for Windows
```

**Bad Examples:**
```
Added some stuff                    # Too vague
Fix.                               # Not descriptive
feat(fundamentals): Added new content about REPL debugging techniques that will help users learn. # Too long
```

### Body (Optional)
- Separate from description with blank line
- Wrap at 72 characters
- Explain what and why, not how
- Can include multiple paragraphs

```
feat(macros): add macro hygiene examples

Macro hygiene is a common stumbling block for intermediate learners.
These examples demonstrate:
- Symbol capture problems
- Solutions using gensym
- Best practices for macro writing

Addresses issue #42 about macro learning curve.
```

### Footer (Optional)
- Reference issues, breaking changes, or co-authors
- Format: `key: value` or `key #value`

```
feat(data-structures): add transducer examples

BREAKING CHANGE: removed deprecated sequence examples
Fixes #123
Co-authored-by: Jane Doe <jane@example.com>
```

## 🔧 Memory Bank Specific Patterns

### Adding New Learning Content
```
feat(topic): add [specific-concept] tutorial
feat(topic): add [concept] examples and exercises
feat(exercises): add [difficulty-level] problems for [topic]
feat(projects): add [project-type] project template
```

### Improving Existing Content
```
fix(topic): correct [specific-error] in [file-name]
refactor(topic): improve [concept] explanation clarity
style(topic): enhance code formatting and comments
docs(topic): add cross-references to related concepts
```

### Maintenance and Setup
```
chore(setup): update Clojure version to [version]
docs(contributing): add [specific-guideline]
build: configure [tool-name] for [purpose]
```

## 🚀 Examples for Common Scenarios

### Adding New Tutorial Content
```bash
git commit -m "feat(functions): add higher-order functions tutorial

Covers map, filter, reduce with practical examples.
Includes exercises progressing from basic to advanced.
Cross-references data-structures section."
```

### Fixing Code Examples
```bash
git commit -m "fix(data-structures): correct vector conj example

Previous example showed incorrect behavior for vector conj.
Updated to demonstrate proper vector appending."
```

### Updating Documentation
```bash
git commit -m "docs(readme): add troubleshooting section

Common issues with REPL setup and solutions.
Includes platform-specific guidance."
```

### Reorganizing Content
```bash
git commit -m "refactor(exercises): group problems by difficulty

Separates beginner, intermediate, and advanced exercises.
Improves learning progression and navigation."
```

### Adding Project Templates
```bash
git commit -m "feat(projects): add web scraper project template

Complete Ring/Compojure web scraping project.
Includes setup, dependencies, and step-by-step guide.
Suitable for intermediate learners."
```

## 🔍 Tools and Automation

### Commit Message Validation
Consider using these tools to enforce conventional commits:

1. **commitizen** - Interactive commit message helper
2. **conventional-changelog** - Generate changelogs automatically
3. **semantic-release** - Automated versioning and releases

### Git Hooks
Set up a commit-msg hook to validate format:

```bash
#!/bin/sh
# .git/hooks/commit-msg
conventional_commit_regex='^(feat|fix|docs|style|refactor|test|chore|perf|build|ci|revert)(\(.+\))?: .{1,50}'

if ! grep -qE "$conventional_commit_regex" "$1"; then
    echo "Invalid commit message format!"
    echo "Please use: type(scope): description"
    echo "See .github/CONVENTIONAL_COMMITS.md for guidelines"
    exit 1
fi
```

## 📊 Benefits for This Project

### For Contributors
- **Consistency**: Everyone follows the same format
- **Clarity**: Easy to understand what each commit does
- **Navigation**: Quickly find specific types of changes
- **Learning**: Commit history tells the story of the project

### For Maintainers
- **Automation**: Generate changelogs and releases automatically
- **Review**: Easier to review and categorize changes
- **Tracking**: Monitor progress on different learning areas
- **Quality**: Enforces thoughtful commit messages

### For Learners
- **Progress**: See how the memory bank evolves over time
- **Context**: Understand why changes were made
- **Contribution**: Clear examples of how to contribute
- **Standards**: Learn professional development practices

## ✅ Quick Checklist

Before committing, verify:
- [ ] Type is appropriate for the change
- [ ] Scope accurately represents the affected area
- [ ] Description is imperative, lowercase, under 50 chars
- [ ] Body explains why, not what (if needed)
- [ ] Footer references issues or breaking changes (if applicable)
- [ ] Message follows the conventional format

## 📚 Additional Resources

- [Conventional Commits Specification](https://www.conventionalcommits.org/)
- [Semantic Versioning](https://semver.org/)
- [How to Write a Git Commit Message](https://chris.beams.io/posts/git-commit/)
- [Angular Commit Message Guidelines](https://github.com/angular/angular/blob/main/CONTRIBUTING.md#commit)

---

Remember: Good commit messages are a gift to your future self and your collaborators. They make the project history a valuable learning resource! 🎯
