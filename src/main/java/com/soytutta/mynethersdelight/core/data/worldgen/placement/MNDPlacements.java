package com.soytutta.mynethersdelight.core.data.worldgen.placement;

import com.soytutta.mynethersdelight.MyNethersDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class MNDPlacements {
    public static final ResourceKey<PlacedFeature> PATCH_POWDERY_CANE = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MyNethersDelight.MODID, "patch_powdery_cane"));

    /*
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureLookup = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> propelplantPatchConfiguredFeature = configuredFeatureLookup.getOrThrow(MNDConfiguredFeatures.PATCH_POWDERY_CANE);

        context.register(
                PATCH_POWDERY_CANE,
                new PlacedFeature(
                        propelplantPatchConfiguredFeature,
                        List.of(
                                CountPlacement.of(8),
                                InSquarePlacement.spread(),
                                PlacementUtils.FULL_RANGE,
                                BiomeFilter.biome()
                        )
                )
        );
    }
     */
}