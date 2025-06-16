# Release Process

This document describes how to build and release a new version of ACCENT.

## Version Management

Version numbers are managed in the following files:
- `deps.edn` - `:version` field
- `build.clj` - `version` definition  
- `src/server/mcp.clj` - `:version` field in server spec

## Release Steps

1. **Update version numbers** in all relevant files to the target version (e.g., "1.0.0")

2. **Create and push a git tag** for the new version:
   ```bash
   git tag v1.0.0
   git push origin v1.0.0
   ```

3. **GitHub Actions will automatically**:
   - Build the uberjar using `clojure -T:build uber`
   - Create a GitHub release
   - Upload the built JAR as a release asset
   - Mark releases as prerelease if the tag contains words like "test", "alpha", "beta", "rc", etc.

## Test Releases

To create a test release, use a tag name containing "test":
```bash
git tag test-v1.0.0
git push origin test-v1.0.0
```

This will be automatically marked as a prerelease in GitHub.

## Build Locally

To build locally for testing:
```bash
# Development build (no prebuilt graph)
clojure -T:build dev-build

# Full production build (with prebuilt graph)
clojure -T:build uber
```

## Current Version

Current version: **v1.0.0**