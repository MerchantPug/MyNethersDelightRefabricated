package com.soytutta.mynethersdelight.refabricated;

import com.soytutta.mynethersdelight.MyNethersDelight;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class MNDRefabricatedLootConditions {
    public static void registerLootConditions() {
        Registry.register(BuiltInRegistries.LOOT_CONDITION_TYPE, MyNethersDelight.res("always_false"), AlwaysFalseCondition.TYPE);
    }
}
