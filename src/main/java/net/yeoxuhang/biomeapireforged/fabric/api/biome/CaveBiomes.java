package net.yeoxuhang.biomeapireforged.fabric.api.biome;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.yeoxuhang.biomeapireforged.impl.biome.CaveBiomeData;
/**
 * API that exposes the internals of Minecraft's cave biome code.
 *
 * <p><b>Experimental feature</b>, may be removed or changed without further notice.
 */
public final class CaveBiomes {
    private CaveBiomes() {
    }

    /**
     * Adds a biome to the Nether generator.
     *
     * @param biome           The biome to add. Must not be null.
     * @param mixedNoisePoint data about the given {@link Biome}'s spawning information in the nether.
     * @see Climate.TargetPoint
     */
    public static void addCaveBiome(ResourceKey<Biome> biome, Climate.TargetPoint mixedNoisePoint) {
        CaveBiomeData.addCaveBiome(biome, Climate.parameters(
                mixedNoisePoint.temperature(),
                mixedNoisePoint.humidity(),
                mixedNoisePoint.continentalness(),
                mixedNoisePoint.erosion(),
                mixedNoisePoint.depth(),
                mixedNoisePoint.weirdness(),
                0
        ));
    }

    /**
     * Adds a biome to the Nether generator.
     *
     * @param biome           The biome to add. Must not be null.
     * @param mixedNoisePoint data about the given {@link Biome}'s spawning information in the nether.
     * @see Climate.ParameterPoint
     */
    public static void addCaveBiome(ResourceKey<Biome> biome, Climate.ParameterPoint mixedNoisePoint) {
        CaveBiomeData.addCaveBiome(biome, mixedNoisePoint);
    }

    /**
     * Returns true if the given biome can generate in the nether, considering the Vanilla nether biomes,
     * and any biomes added to the Nether by mods.
     */
    public static boolean canGenerateInOverworld(ResourceKey<Biome> biome) {
        return CaveBiomeData.canGenerateInOverworld(biome);
    }
}
