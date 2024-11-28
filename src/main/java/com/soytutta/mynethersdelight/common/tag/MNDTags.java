package com.soytutta.mynethersdelight.common.tag;

import com.soytutta.mynethersdelight.MyNethersDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class MNDTags {
    public static final TagKey<Item> BLOCK_OF_POWDERY = modItemTag("block_of_powdery");

    public static final TagKey<Block> RESURGENT_SOIL_PLANT = modBlockTag("resurgent_soil_plant");

    public static final TagKey<Block> NOT_PROPAGATE_PLANT = modBlockTag("not_propagate_plant");
    public static final TagKey<Block> ABOVE_PROPAGATE_PLANT = modBlockTag("above_propagate_plant");
    public static final TagKey<Block> BELOW_PROPAGATE_PLANT = modBlockTag("below_propagate_plant");

    public static final TagKey<Block> LETIOS_ACTIVATORS = modBlockTag("letios_activators");
    public static final TagKey<Block> LETIOS_FLAMES = modBlockTag("letios_flames");
    public static final TagKey<Block> SHOWCASE_ACTIVATORS = modBlockTag("showcase_activators");
    public static final TagKey<Block> SHOWCASE_FLAMES = modBlockTag("showcase_flames");

    public static final TagKey<Item> STOVE_SOUL_FUEL = modItemTag("stove_soul_fuel");
    public static final TagKey<Item> STOVE_FIRE_FUEL = modItemTag("stove_fire_fuel");

    public static final TagKey<Item> HOGLIN_CURE = modItemTag("hoglin_cure");
    public static final TagKey<Item> HOGLIN_WAXED = modItemTag("hoglin_waxed");

    public static final TagKey<Block> POWDERY_CANNON_PLANTABLE_ON = modBlockTag("powdery_cannon_plantable_on");
    public static final TagKey<Block> POWDERY_CANE = modBlockTag("powdery_cane");

    public static final TagKey<Item> STUFFED_HOGLIN_ITEMS = modItemTag("stuffed_hoglin_items");

    public static final TagKey<Item> BOILED_EGG_CANDIDATE = modItemTag("boiled_egg_candidate");
    public static final TagKey<Item> HOT_SPICE = modItemTag("hot_spice");
    public static final TagKey<EntityType<?>> SPECIAL_HUNT = modEntityTag("special_hunt");
    public static final TagKey<Enchantment> POACHING_ENCHANTMENT = TagKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(MyNethersDelight.MODID, "poaching"));

    // Refabricated Tags
    public static final TagKey<Block> SURVIVES_RESURGENT_SOIL = modBlockTag("survives/resurgent_soil");
    public static final TagKey<Block> DOES_NOT_SURVIVE_RESURGENT_SOIL = modBlockTag("does_not_survive/resurgent_soil");
    public static final TagKey<Block> SURVIVES_RESURGENT_SOIL_FARMLAND = modBlockTag("survives/resurgent_soil_farmland");
    public static final TagKey<Block> DOES_NOT_SURVIVE_RESURGENT_SOIL_FARMLAND = modBlockTag("does_not_survive/resurgent_soil_farmland");

    public static final TagKey<Biome> POWDERY_CANE_WHITELIST = modBiomeTag("powdery_cane_whitelist");
    public static final TagKey<Biome> POWDERY_CANE_BLACKLIST = modBiomeTag("powdery_cane_blacklist");

    private static TagKey<Item> modItemTag(String path) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("mynethersdelight", path));
    }
    private static TagKey<Block> modBlockTag(String path) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("mynethersdelight", path));
    }
    private static TagKey<EntityType<?>> modEntityTag(String path) {
        return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath("mynethersdelight", path));
    }
    private static TagKey<Biome> modBiomeTag(String path) {
        return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("mynethersdelight", path));
    }

}