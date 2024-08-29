package com.soytutta.mynethersdelight;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;

public class MyNethersDelightASM implements Runnable {
    public static final String HUNTING_WEAPON_ENCHANTMENT_CATEGORY = "MYNETHERSDELIGHT_HUNTING_WEAPON";

    @Override
    public void run() {
        MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
        String enchantmentTarget = remapper.mapClassName("intermediary", "net.minecraft.class_1886");
        ClassTinkerers.enumBuilder(enchantmentTarget).addEnumSubclass(HUNTING_WEAPON_ENCHANTMENT_CATEGORY, "com.soytutta.mynethersdelight.common.enchantment.category.HuntingWeaponEnchantmentCategory").build();
    }
}
