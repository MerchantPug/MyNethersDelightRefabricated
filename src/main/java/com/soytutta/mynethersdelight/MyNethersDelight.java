package com.soytutta.mynethersdelight;

import com.soytutta.mynethersdelight.common.MNDCommonSetup;
import com.soytutta.mynethersdelight.common.events.CommonEvent;
import com.soytutta.mynethersdelight.common.item.HotCreamConeItem;
import com.soytutta.mynethersdelight.common.registry.*;
import com.soytutta.mynethersdelight.refabricated.MNDRefabricatedLootConditions;
import com.soytutta.mynethersdelight.refabricated.MNDRefabricatedLootModificationEvents;
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
        MNDEffects.register();
        MNDBlocks.register();
        MNDItems.register();
        MNDBlockEntityTypes.register();
        MNDEntityTypes.register();
        MNDCreativeTab.register();
        MNDBiomeFeatures.register();
        MNDEnchantmentComponents.register();

        MNDCommonSetup.init();

        // new stuff
        CommonEvent.init();
        HotCreamConeItem.StriderFoodEvent.init();
        MNDBiomeModifiers.init();
        MNDRefabricatedLootModificationEvents.init();
        MNDBlockEntityTypes.addCabinetsBlockEntities();
        MNDRefabricatedLootConditions.registerLootConditions();
    }

    public static ResourceLocation res(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}