package com.soytutta.mynethersdelight.common.registry;

import com.soytutta.mynethersdelight.MyNethersDelight;
import com.soytutta.mynethersdelight.common.world.feature.PowderyCaneFeature;
import io.github.fabricators_of_create.porting_lib.util.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.function.Supplier;

public class MNDBiomeFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, MyNethersDelight.MODID);
    public static final Supplier<Feature<NoneFeatureConfiguration>> POWDERYCANE = FEATURES.register("powderycane", () -> new PowderyCaneFeature(NoneFeatureConfiguration.CODEC));
}