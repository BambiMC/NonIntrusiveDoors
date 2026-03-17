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

- Minecraft **1.21.1**
- NeoForge **21.1.74+**

## Installation

Drop the `.jar` from the [releases page](../../releases) into your `mods/` folder.

## Building from Source

```bash
# Build the mod jar (output: build/libs/)
./gradlew build

# Run Minecraft client with the mod loaded
./gradlew runClient

# Run a dedicated server with the mod loaded
./gradlew runServer
```

## IDE Setup (VSCode)

Run `./gradlew build` first to download all dependencies, then reload the Java project:

`Ctrl+Shift+P` → **Java: Clean Java Language Server Workspace** → Restart

Requires the [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) (includes Gradle for Java). The `eclipse` task is not supported by NeoGradle.

## License

MIT — see [LICENSE](LICENSE)
