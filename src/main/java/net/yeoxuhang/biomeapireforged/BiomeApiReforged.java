package net.yeoxuhang.biomeapireforged;

import com.mojang.datafixers.util.Pair;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.yeoxuhang.biomeapireforged.example.ExampleBiomes;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BiomeApiReforged.MODID)
public class BiomeApiReforged {
    public static final String MODID = "biomeapireforged";
    public static final Logger LOGGER = LogUtils.getLogger();
    public BiomeApiReforged() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ExampleBiomes.BIOMES.register(modEventBus);
        modEventBus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ExampleBiomes::generateBiomes);
    }
}
