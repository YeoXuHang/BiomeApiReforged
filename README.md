# <a href=https://www.curseforge.com/minecraft/mc-mods/biomes-api-reforged>Biome Api Reforged</a>
Forge Port of Fabric Biome Api


You can find the Original project <a href=https://github.com/FabricMC/fabric/tree/1.19.2/fabric-biome-api-v1>Here</a>.

For Developers:
This guide should only be used if you are a developer wanting to using Biome Api Reforged in your mod. If you're a player, you may disregard this guide.
Adding Biome Api Reforged to your mod is quite simple! First off you need to add Biome Api Reforged as a dependency to access the library in code. To do so, add the following into your ``build.gradle``:

# Forge Gradle
```java
repositories {
        maven {
            url = "https://www.cursemaven.com"
            content {
                includeGroup "curse.maven"
            }
        }
        maven {
            url = "https://maven.jaackson.me"
        }
}


dependencies {
    implementation fg.deobf("curse.maven:biomeapi-779807:file-id")
}
```


# Loom Forge
```java
dependencies {
    include modImplementation("curse.maven:biomeapi-779807:file-id")
}
```

Next you need to add it as a dependecy on Forge to make your mod require Biome Api Reforged when loading. In your ``mods.toml`` add the following block to the file:

```java
[[dependencies.<modId>]]
modId = "biomeapireforged"
mandatory = true
versionRange = "[<version>,)"
ordering = "BEFORE"
side = "BOTH"
