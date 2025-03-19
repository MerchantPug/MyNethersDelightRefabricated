package com.soytutta.mynethersdelight.common.registry;

import com.soytutta.mynethersdelight.MyNethersDelight;
import com.soytutta.mynethersdelight.common.enchantment.PoachingData;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.List;
import java.util.function.Supplier;

public class MNDEnchantmentComponents {
    public static final Supplier<DataComponentType<List<PoachingData>>> POACHING = register("poaching", () -> DataComponentType.<List<PoachingData>>builder()
            .persistent(PoachingData.CODEC.listOf())
            .build());

    public static void register() {}

    private static <T> Supplier<DataComponentType<T>> register(String path, Supplier<DataComponentType<T>> supp) {
        DataComponentType<T> value = supp.get();
        Registry.register(BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, MyNethersDelight.res(path), value);
        return () -> value;
    }
}
