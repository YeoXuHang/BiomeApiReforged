package net.yeoxuhang.biomeapireforged.example;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yeoxuhang.biomeapireforged.BiomeApiReforged;
import net.yeoxuhang.biomeapireforged.fabric.api.biome.TheEndBiomes;

import java.util.function.Supplier;

public class ExampleBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, BiomeApiReforged.MODID);

    public static final RegistryObject<Biome> EXAMPLE_END_BIOME =
            add("example_end_biome", ExampleBiome::make);

    public static void generateBiomes(IEventBus modEventBus) {
        TheEndBiomes.addHighlandsBiome(EXAMPLE_END_BIOME.getKey(), 5);
        BIOMES.register(modEventBus);
    }

    private static RegistryObject<Biome> add(String name, Supplier<Biome> biome) {
        ResourceLocation id = new ResourceLocation(BiomeApiReforged.MODID, name);
        RegistryObject<Biome> key = RegistryObject.create(id, ForgeRegistries.BIOMES);
        BIOMES.register(name, biome);
        return key;
    }
}
