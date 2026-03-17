# Non Intrusive Doors

![Non Intrusive Doors Logo](logo/curseforge.png)

Tired of getting stuck at the edge of a door in Minecraft? This QOL mod makes all vanilla doors and trapdoors completely non-intrusive — they render normally but have **zero collision** when open, so you can walk through them freely.

## Features

- All 12 vanilla wood types (Oak, Birch, Spruce, Jungle, Acacia, Dark Oak, Mangrove, Cherry, Bamboo, Crimson, Warped) plus Iron
- Both **doors** and **trapdoors** covered
- Open doors/trapdoors are fully walk-through (no collision at all)
- Closed doors retain their normal collision
- Replaces vanilla blocks transparently — no recipe or placement changes

## Requirements

- Minecraft **1.20.1**
- Forge **47.0.19+**

## Installation

Drop the `.jar` from the [releases page](../../releases) into your `mods/` folder.

## Building from Source

> **First build on the `1.12.2` branch:** always run `./gradlew clean build` instead of just `./gradlew build`.
> RFG (RetroFuturaGradle) caches intermediate Minecraft source files. If a previous build exists (e.g. from the 1.7.10 branch), the stale cached sources will be used and the build will fail with `extends Packet` / `no interface expected here` errors. A clean wipes those stale artifacts.

```bash
# First build, or after switching branches — always clean first
./gradlew clean build

# Subsequent builds (no branch switch)
./gradlew build

# Run Minecraft client with the mod loaded
./gradlew runClient

# Run a dedicated server with the mod loaded
./gradlew runServer

# Generate IDE run configurations (IntelliJ)
./gradlew genIntellijRuns
```

## License

MIT — see [LICENSE](LICENSE)
