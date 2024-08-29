package com.soytutta.mynethersdelight.common.enchantment.category;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

/**
 * @see com.soytutta.mynethersdelight.common.registry.MNDEnchantments#HUNTING_WEAPON
 */
@SuppressWarnings("unused")
public class HuntingWeaponEnchantmentCategory extends AbstractEnchantmentCategory {

    @Override
    public boolean canEnchant(Item item) {
        return item instanceof SwordItem || item instanceof AxeItem;
    }

}
