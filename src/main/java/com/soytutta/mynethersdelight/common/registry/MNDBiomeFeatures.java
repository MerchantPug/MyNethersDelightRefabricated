package com.soytutta.mynethersdelight.common.registry;

import com.soytutta.mynethersdelight.MyNethersDelight;
import com.soytutta.mynethersdelight.common.world.feature.PowderyCaneFeature;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.function.Supplier;

public class MNDBiomeFeatures {
    public static final Supplier<Feature<NoneFeatureConfiguration>> POWDERYCANE = register("powderycane", () -> new PowderyCaneFeature(NoneFeatureConfiguration.CODEC));

    public static void register() {}

    private static <T extends FeatureConfiguration> Supplier<Feature<T>> register(String path, Supplier<Feature<T>> supp) {
        Feature<T> value = supp.get();
        Registry.register(BuiltInRegistries.FEATURE, MyNethersDelight.res(path), value);
        return () -> value;
    }
}