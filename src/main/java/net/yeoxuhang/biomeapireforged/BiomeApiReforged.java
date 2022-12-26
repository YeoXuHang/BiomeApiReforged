package net.yeoxuhang.biomeapireforged;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yeoxuhang.biomeapireforged.example.ExampleBiomes;
import org.checkerframework.checker.signature.qual.Identifier;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BiomeApiReforged.MODID)
public class BiomeApiReforged {
    public static final String MODID = "biomeapireforged";
    public static final Logger LOGGER = LogUtils.getLogger();
    public BiomeApiReforged() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ExampleBiomes.generateBiomes(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
