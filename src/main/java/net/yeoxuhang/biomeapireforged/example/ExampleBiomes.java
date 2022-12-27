package net.yeoxuhang.biomeapireforged.example;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.InclusiveRange;
import net.minecraft.world.level.biome.Biome;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.yeoxuhang.biomeapireforged.BiomeApiReforged;
import net.yeoxuhang.biomeapireforged.fabric.api.biome.TheEndBiomes;

import java.util.function.Supplier;

public class ExampleBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, BiomeApiReforged.MODID);

    public static final ResourceKey<Biome> EXAMPLE_END_BIOME = add("example_end_biome", EndBiome::make);

    public static void generateBiomes() {
        TheEndBiomes.addHighlandsBiome(EXAMPLE_END_BIOME, 5);
    }

    private static ResourceKey<Biome> add(String name, Supplier<Biome> biome) {
        ResourceLocation id = new ResourceLocation(BiomeApiReforged.MODID, name);
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, id);
        BIOMES.register(name, biome);
        return key;
    }
}
