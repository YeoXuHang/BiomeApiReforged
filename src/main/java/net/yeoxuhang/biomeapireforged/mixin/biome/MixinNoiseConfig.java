package net.yeoxuhang.biomeapireforged.mixin.biome;

import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.RandomState;
import net.yeoxuhang.biomeapireforged.impl.biome.MultiNoiseSamplerHooks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RandomState.class)
public class MixinNoiseConfig {

    @Final
    private Climate.Sampler multiNoiseSampler;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void init(NoiseGeneratorSettings chunkGeneratorSettings, Registry<?> noiseRegistry, long seed, CallbackInfo ci) {
        ((MultiNoiseSamplerHooks) (Object) multiNoiseSampler).fabric_setSeed(seed);
    }
}
