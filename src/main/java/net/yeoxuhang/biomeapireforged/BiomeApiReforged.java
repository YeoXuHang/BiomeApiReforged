package net.yeoxuhang.biomeapireforged;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(BiomeApiReforged.MODID)
public class BiomeApiReforged {
    public static final String MODID = "biomeapireforged";
    public static final Logger LOGGER = LogUtils.getLogger();
    public BiomeApiReforged() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
