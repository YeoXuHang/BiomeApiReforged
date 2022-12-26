package net.yeoxuhang.biomeapireforged.example;

import net.minecraft.data.worldgen.features.EndFeatures;
import net.minecraft.data.worldgen.placement.EndPlacements;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ExampleBiome {

    public static Biome make() {

        BiomeGenerationSettings.Builder biomeGenSettings = (new BiomeGenerationSettings.Builder());
        biomeGenSettings.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, EndPlacements.END_GATEWAY_RETURN);

        return exampleBiome(biomeGenSettings);
    }

    // Winterfest
    public static Biome exampleBiome(BiomeGenerationSettings.Builder pGenerationSettingsBuilder) {
        MobSpawnSettings.Builder mobspawninfo$builder = new MobSpawnSettings.Builder();
        return (new Biome.BiomeBuilder())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(0.5F).downfall(0.5F)
                .mobSpawnSettings(mobspawninfo$builder.build())
                .generationSettings(pGenerationSettingsBuilder.build()).build();
    }
}
