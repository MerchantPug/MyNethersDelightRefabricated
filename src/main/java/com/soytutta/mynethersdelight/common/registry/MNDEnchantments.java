package com.soytutta.mynethersdelight.common.registry;

import com.soytutta.mynethersdelight.MyNethersDelight;
import com.soytutta.mynethersdelight.common.enchantment.HuntingEnchantment;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class MNDEnchantments {
    public static final LazyRegistrar<Enchantment> DEF_REG = LazyRegistrar.create(Registries.ENCHANTMENT, MyNethersDelight.MODID);
    public static final EnchantmentCategory HUNTING_WEAPON = EnchantmentCategory.MY_NETHERS_DELIGHT_HUNTING_WEAPON;
    public static final RegistryObject<Enchantment> HUNTING = DEF_REG.register("poaching", () -> new HuntingEnchantment(Enchantment.Rarity.VERY_RARE, HUNTING_WEAPON, EquipmentSlot.MAINHAND));
}