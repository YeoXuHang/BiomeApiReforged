package net.yeoxuhang.biomeapireforged;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.yeoxuhang.biomeapireforged.example.ExampleBiomes;

import static net.yeoxuhang.biomeapireforged.example.ExampleBiomes.BIOMES;
import static net.yeoxuhang.biomeapireforged.example.SurfaceRuleRegistry.SURFACE;

@Mod(BiomeApiReforged.MODID)
public class BiomeApiReforged {
    public static final String MODID = "biomeapireforged";

    public BiomeApiReforged() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BIOMES.register(modEventBus);
        SURFACE.register(modEventBus);
        modEventBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ExampleBiomes::generateBiomes);
    }
}
