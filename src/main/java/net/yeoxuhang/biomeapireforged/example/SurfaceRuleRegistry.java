package net.yeoxuhang.biomeapireforged.example;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.yeoxuhang.biomeapireforged.BiomeApiReforged;

import java.util.function.Supplier;

public class SurfaceRuleRegistry {

    public static final DeferredRegister<Codec<? extends SurfaceRules.RuleSource>> SURFACE = DeferredRegister.create(Registry.RULE_REGISTRY, BiomeApiReforged.MODID);

    public static final RegistryObject<Codec<SurfaceRules.RuleSource>> TEST = SURFACE.register(ResourceLocation.tryParse("test"), addNetherSurfaceRules());
    private static final SurfaceRules.RuleSource REDSTONE_BLOCK = makeStateRule(Blocks.REDSTONE_BLOCK);
    private static final SurfaceRules.RuleSource REDSTONE_BLOCK_ = makeStateRule(Blocks.REDSTONE_BLOCK);
    private static final SurfaceRules.RuleSource DIAMOND_BLOCK = makeStateRule(Blocks.DIAMOND_BLOCK);
    private static final SurfaceRules.RuleSource HAY_BLOCK = makeStateRule(Blocks.HAY_BLOCK);
    private static final SurfaceRules.RuleSource MUD = makeStateRule(Blocks.MUD);
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);

    private static final SurfaceRules.RuleSource GLOWSTONE_CANYON = SurfaceRules.ifTrue(SurfaceRules.isBiome(ExampleBiomes.EXAMPLE_END_BIOME), SurfaceRules.sequence(
            SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(
                    SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, REDSTONE_BLOCK),
                    REDSTONE_BLOCK_)),
            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(3, false, CaveSurface.FLOOR), DIAMOND_BLOCK), MUD,
            HAY_BLOCK
    ));

    public static SurfaceRules.RuleSource addNetherSurfaceRules() {
        return SurfaceRules.sequence(GLOWSTONE_CANYON);
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }}
