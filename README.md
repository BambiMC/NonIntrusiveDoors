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

```bash
# Build the mod jar (output: build/libs/)
./gradlew build

# If swiching branches, clean first to avoid leftover files
./gradlew clean build

# Run Minecraft client with the mod loaded
./gradlew runClient

# Run a dedicated server with the mod loaded
./gradlew runServer

# Generate IDE run configurations (IntelliJ)
./gradlew genIntellijRuns
```

## License

MIT — see [LICENSE](LICENSE)
