package com.soytutta.mynethersdelight.core.data.worldgen.biome;

import com.soytutta.mynethersdelight.core.data.worldgen.placement.MNDPlacements;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class MNDBiomeModifiers {
    // private static final ResourceKey<BiomeModifier> FEATURE_PATCH_POWDERY_CANE = ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(MyNethersDelight.MODID, "patch_powdery_cane"));
    public static void bootstrap() {
        BiomeModifications.addFeature(ctx -> ctx.getBiomeRegistryEntry().is(Biomes.CRIMSON_FOREST), GenerationStep.Decoration.VEGETAL_DECORATION, MNDPlacements.PATCH_POWDERY_CANE);
    }
}