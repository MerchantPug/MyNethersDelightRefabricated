package com.soytutta.mynethersdelight.core.mixin;

import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import vectorwing.farmersdelight.common.item.KnifeItem;

@Mixin(EnchantmentCategory.class)
public enum EnchantmentCategoryMixin {
	MY_NETHERS_DELIGHT_HUNTING_WEAPON() {
		public boolean canEnchant(Item item) {
			return item instanceof AxeItem || item instanceof SwordItem;
		}
	}
}
