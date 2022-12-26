package net.yeoxuhang.biomeapireforged.mixin.biome;

import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;

@Mixin(BiomeSource.class)
public class MixinBiomeSource {
    // Not marked as @Final because of AW

    public Set<Holder<Biome>> biomes;

    @Inject(method = "possibleBiomes", at = @At("HEAD"))
    private void getBiomes(CallbackInfoReturnable<Set<Holder<Biome>>> ci) {
        fabric_modifyBiomeSet(biomes);
    }

    protected void fabric_modifyBiomeSet(Set<Holder<Biome>> biomes) {
    }
}
