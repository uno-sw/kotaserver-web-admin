# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Kotlin/Ktor web admin server application. Package: `jp.unosw`. Runs on Netty at `http://0.0.0.0:8080`.

## Tech Stack

- **Language:** Kotlin 2.3.0 (JVM toolchain 21)
- **Framework:** Ktor 3.4.0 (Server, Netty engine)
- **Build:** Gradle with Kotlin DSL, version catalog (`gradle/libs.versions.toml`)
- **Logging:** Logback

## Build & Run Commands

| Command | Description |
|---|---|
| `./gradlew run` | Run the server |
| `./gradlew build` | Build everything |
| `./gradlew test` | Run all tests |
| `./gradlew test --tests "jp.unosw.SomeTest"` | Run a single test class |
| `./gradlew buildFatJar` | Build executable JAR with all dependencies |

## Architecture

- **Entry point:** `src/main/kotlin/Application.kt` — `main()` starts embedded Netty server, `Application.module()` installs features
- **Routing:** `src/main/kotlin/Routing.kt` — `Application.configureRouting()` extension function defines routes
- **Ktor pattern:** Features are configured via `Application` extension functions called from `module()`. New features (authentication, serialization, etc.) should follow this pattern by creating a new `configure*()` extension function and calling it from `module()`
