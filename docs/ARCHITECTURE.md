# Architecture

## Current approach

Yellow Track Platform begins as a small Kotlin Multiplatform project with separate platform applications and one shared module:

```text
androidApp/
desktopApp/
iosApp/
shared/
```

The project will favor packages before additional Gradle modules. Modules will be extracted when they provide clear benefits such as dependency boundaries, build isolation, ownership, or reusable publication.

## Architectural style

The platform will use clean, hexagonal principles without forcing unnecessary ceremony.

```text
Platform UI
    ↓
Presentation
    ↓
Use cases
    ↓
Domain ports
    ↓
Adapters
```

Adapters may include:

- Local database
- Preferences
- File system
- Networking
- Lightroom launcher
- Cloud integrations

The domain layer must not depend on Compose, Android, AppKit, UIKit, SQL libraries, or networking implementations.

## Initial package direction

```text
com.yellowtrack.platform

foundation/
domain/
data/
presentation/
designsystem/
navigation/
```

Only `foundation` is introduced during the project-identity pull request.

## Dependency direction

Dependencies should point inward:

```text
platform apps
    → presentation
    → domain
    → foundation
```

Infrastructure adapters implement contracts owned by the domain or application layer.

## State management

- Coroutines and Flow will be used for asynchronous work and observable state.
- Presentation models should expose immutable state.
- Platform lifecycle details should remain outside domain logic.

## Persistence

Persistence will be introduced with explicit schema versions and tested migrations. Database entities must not leak directly into the UI.

## Platform-specific code

Use `expect`/`actual`, interfaces, or injected adapters only when sharing is beneficial. Native platform integrations should not be hidden behind abstractions that make them harder to use correctly.

## Testing

The project will prioritize:

- Domain unit tests
- Use-case tests
- Repository contract tests
- Migration tests
- Platform integration tests where necessary
- Compose UI tests for critical workflows
