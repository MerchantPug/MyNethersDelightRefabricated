package com.soytutta.mynethersdelight;

import com.mojang.serialization.Codec;
import com.soytutta.mynethersdelight.common.MNDCommonSetup;
import com.soytutta.mynethersdelight.common.block.ResurgentSoilBlock;
import com.soytutta.mynethersdelight.common.events.CommonEvent;
import com.soytutta.mynethersdelight.common.item.HotCreamConeItem;
import com.soytutta.mynethersdelight.common.loot.MNDPastrySlicingModifier;
import com.soytutta.mynethersdelight.common.loot.RemplaceLootModifier;
import com.soytutta.mynethersdelight.common.registry.*;
import com.soytutta.mynethersdelight.core.data.worldgen.biome.MNDBiomeModifiers;
import com.soytutta.mynethersdelight.integration.MNDEveryCompat;
import io.github.fabricators_of_create.porting_lib.loot.IGlobalLootModifier;
import io.github.fabricators_of_create.porting_lib.loot.PortingLibLoot;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class MyNethersDelight implements ModInitializer
{
    public static final String MODID = "mynethersdelight";
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        MNDCommonSetup.init();
        MNDItems.ITEMS.register();
        // TODO: I don't think there is a Miner's Delight Fabric.
        /*
        if (FabricLoader.getInstance().isModLoaded("miners_delight")) {
            MNDItemsMD.ITEMS.register();
        }
         */
        MNDBlocks.BLOCKS.register();
        MNDEffects.EFFECTS.register();
        MNDEnchantments.DEF_REG.register();
        MNDBlockEntityTypes.TILES.register();
        MNDEntityTypes.ENTITIES.register();
        MNDCreativeTab.TABS.register();
        MNDBiomeFeatures.FEATURES.register();
        registerLootSerializers();
        if (FabricLoader.getInstance().isModLoaded("moonlight")) {
            MNDEveryCompat.registerCompat();
        }

        // Refabricated
        MNDBiomeModifiers.bootstrap();
        HotCreamConeItem.init();
        ResurgentSoilBlock.init();
        CommonEvent.init();
    }

    void registerLootSerializers() {
        LazyRegistrar<Codec<? extends IGlobalLootModifier>> LOOT = LazyRegistrar.create(PortingLibLoot.GLOBAL_LOOT_MODIFIER_SERIALIZERS_KEY, MyNethersDelight.MODID);
        Supplier<Codec<RemplaceLootModifier>> REMPLACE_ITEM = LOOT.register("remplace_item", RemplaceLootModifier.CODEC);
        Supplier<Codec<MNDPastrySlicingModifier>> PASTRY_SLICING= LOOT.register("pastry_slicing", MNDPastrySlicingModifier.CODEC);

        LOOT.register();
    }

    public static ResourceLocation res(String path) {
        return new ResourceLocation(MODID, path);
    }
}