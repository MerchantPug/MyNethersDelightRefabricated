package com.soytutta.mynethersdelight.common.registry;

import com.soytutta.mynethersdelight.MyNethersDelight;
import com.soytutta.mynethersdelight.common.tag.MNDTags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class MNDBiomeModifiers {

    private static final ResourceKey<PlacedFeature> POWDERY_CANE = modFeature("patch_powdery_cane");

    @NotNull
    private static ResourceKey<PlacedFeature> modFeature(String path) {
        return ResourceKey.create(Registries.PLACED_FEATURE, MyNethersDelight.res(path));
    }

    public static void init() {
        BiomeModifications.addFeature(new MNDBiomeSelector(-4f, 4f,
                        MNDTags.POWDERY_CANE_WHITELIST, MNDTags.POWDERY_CANE_BLACKLIST),
                GenerationStep.Decoration.VEGETAL_DECORATION, POWDERY_CANE);
    }

    //TODO: use humidity too? for rice
    public record MNDBiomeSelector(float minTemperature, float maxTemperature, TagKey<Biome> allowed,
                                  @Nullable TagKey<Biome> denied) implements Predicate<BiomeSelectionContext> {

        public MNDBiomeSelector(TagKey<Biome> tagKey) {
            this(-4f, 4f, tagKey, null);
        }

        @Override
        public boolean test(BiomeSelectionContext context) {
            Holder<Biome> biome = context.getBiomeRegistryEntry();
            float temp = biome.value().getBaseTemperature();
            if (denied != null && biome.is(denied)) return false;
            return biome.is(allowed) && temp >= minTemperature && temp <= maxTemperature;
        }
    }
}