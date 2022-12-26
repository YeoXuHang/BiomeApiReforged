package net.yeoxuhang.biomeapireforged.mixin.biome;

import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.progress.ChunkProgressListener;
import net.minecraft.world.level.storage.WorldData;
import net.yeoxuhang.biomeapireforged.impl.biome.NetherBiomeData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {

    @Final
    protected WorldData saveProperties;

    @Final
    private RegistryAccess.Frozen registryManager;

    @Inject(method = "createLevels", at = @At("HEAD"))
    private void addNetherBiomes(ChunkProgressListener worldGenerationProgressListener, CallbackInfo ci) {
        // This is the last point where we can safely modify worldgen related things
        // plus, this is server-side only, and DRM is easily accessible
        // please blame Mojang for using dynamic registry
        this.saveProperties.worldGenSettings().dimensions().stream().forEach(dimensionOptions -> NetherBiomeData.modifyBiomeSource(this.registryManager.registryOrThrow(Registry.BIOME_REGISTRY), dimensionOptions.generator().getBiomeSource()));
    }
}
