import com.mojang.logging.LogUtils;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.EndPlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.yeoxuhang.biomeapireforged.fabric.api.biome.TheEndBiomes;
import org.slf4j.Logger;

import java.util.function.Supplier;

@Mod(ExampleBiomeMod.MODID)
public class ExampleBiomeMod {
    public static final String MODID = "examplebiome";
    public static final Logger LOGGER = LogUtils.getLogger();
    public ExampleBiomeMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BIOMES.register(modEventBus);
        modEventBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
       event.enqueueWork(ExampleBiomeMod::generateBiomes);
    }



    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, ExampleBiomeMod.MODID);

    public static final ResourceKey<Biome> EXAMPLE_END_BIOME = add("example_end_biome", ExampleBiomeMod::make);

    public static void generateBiomes() {
        TheEndBiomes.addHighlandsBiome(ExampleBiomeMod.EXAMPLE_END_BIOME, 5);
    }

    private static ResourceKey<Biome> add(String name, Supplier<Biome> biome) {
        ResourceLocation id = new ResourceLocation(ExampleBiomeMod.MODID, name);
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, id);
        BIOMES.register(name, biome);
        return key;
    }


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
