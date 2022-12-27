package net.yeoxuhang.biomeapireforged.example;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.EndPlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class EndBiome {
    public static Biome make() {
        BiomeGenerationSettings.Builder $$0 = (new BiomeGenerationSettings.Builder())
                .addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, EndPlacements.END_SPIKE)
                .addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, NetherPlacements.WARPED_FOREST_VEGETATION);
        MobSpawnSettings.Builder $$1 = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.addSurfaceFreezing($$0);
        $$0.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, MiscOverworldPlacements.ICE_SPIKE);
        $$0.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, MiscOverworldPlacements.ICE_PATCH);

        BiomeDefaultFeatures.endSpawns($$1);
        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.NONE)
                .temperature(0.5F).downfall(0.5F).specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4159204).waterFogColor(329011).fogColor(10518688).skyColor(0)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings($$1.build())
                .generationSettings($$0.build()).build();
    }
}
