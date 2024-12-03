package com.soytutta.mynethersdelight;

import com.soytutta.mynethersdelight.common.MNDCommonSetup;
import com.soytutta.mynethersdelight.common.events.CommonEvent;
import com.soytutta.mynethersdelight.common.item.HotCreamConeItem;
import com.soytutta.mynethersdelight.common.registry.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vectorwing.farmersdelight.common.registry.ModBlockEntityTypes;

public class MyNethersDelight implements ModInitializer
{
    public static final String MODID = "mynethersdelight";
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        // Refabricated: There's been some minor rearrangements.
        MNDEffects.EFFECTS.register();
        MNDBlocks.BLOCKS.register();
        MNDItems.ITEMS.register();
        MNDBlockEntityTypes.TILES.register();
        MNDEntityTypes.ENTITIES.register();
        MNDCreativeTab.TABS.register();
        MNDBiomeFeatures.FEATURES.register();
        MNDLootModifiers.LOOT_MODIFIERS.register();
        MNDEnchantmentComponents.ENCHANTMENT_EFFECT_COMPONENTS.register();

        MNDCommonSetup.init();

        // new stuff
        CommonEvent.init();
        HotCreamConeItem.StriderFoodEvent.init();
        MNDBiomeModifiers.init();
        addCabinets();
    }

    private static void addCabinets() {;
        ModBlockEntityTypes.CABINET.get().addSupportedBlock(MNDBlocks.BLACKSTONE_BRICKS_CABINET.get());
        ModBlockEntityTypes.CABINET.get().addSupportedBlock(MNDBlocks.NETHER_BRICKS_CABINET.get());
        ModBlockEntityTypes.CABINET.get().addSupportedBlock(MNDBlocks.POWDERY_CABINET.get());
        ModBlockEntityTypes.CABINET.get().addSupportedBlock(MNDBlocks.RED_NETHER_BRICKS_CABINET.get());
    }

    public static ResourceLocation res(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}