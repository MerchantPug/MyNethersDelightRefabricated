package com.soytutta.mynethersdelight.common.enchantment.category;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@SuppressWarnings("all")
@Mixin(EnchantmentCategory.class)
public abstract class AbstractEnchantmentCategory {

    @Shadow
    public abstract boolean canEnchant(Item item);

}
