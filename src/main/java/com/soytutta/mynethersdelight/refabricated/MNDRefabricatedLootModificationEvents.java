package com.soytutta.mynethersdelight.refabricated;

import com.google.common.collect.Maps;
import com.soytutta.mynethersdelight.MyNethersDelight;
import com.soytutta.mynethersdelight.common.block.MagmaCakeBlock;
import com.soytutta.mynethersdelight.common.registry.MNDBlocks;
import com.soytutta.mynethersdelight.common.registry.MNDItems;
import com.soytutta.mynethersdelight.core.mixin.refabricated.LootItemAccessor;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.Map;

public class MNDRefabricatedLootModificationEvents {
    private static final ResourceKey<LootTable> ENTITIES_GHAST = vanillaKey("entities/ghast");
    private static final ResourceKey<LootTable> ENTITIES_HOGLIN = vanillaKey("entities/hoglin");
    private static final ResourceKey<LootTable> ENTITIES_STRIDER = vanillaKey("entities/strider");

    private static final ResourceKey<LootTable> BLOCKS_MAGMA_CAKE_BLOCK = key("blocks/magma_cake_block");

    public static final ResourceKey<LootTable> MND_BASTION_HOGLIN_STABLE = key("chests/mnd_bastion_hoglin_stable");
    public static final ResourceKey<LootTable> MND_BASTION_TREASURE = key("chests/mnd_bastion_treasure");

    public static void init() {
        LootTableEvents.MODIFY.register(MNDRefabricatedLootModificationEvents::modifyTable);
    }

    private static void modifyTable(ResourceKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, HolderLookup.Provider registries) {
        if (!source.isBuiltin()) // Will return if the loot table is modified via datapack.
            return;
        chestLoot(key, tableBuilder, source, registries);
        replaceLoot(key, tableBuilder, source, registries);
        scavengingLoot(key, tableBuilder, source, registries);
        slicingLoot(key, tableBuilder, source, registries);
    }

    private static void chestLoot(ResourceKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, HolderLookup.Provider registries) {
        if (key == BuiltInLootTables.BASTION_HOGLIN_STABLE)
            tableBuilder.withPool(LootPool.lootPool().add(NestedLootTable.lootTableReference(MND_BASTION_HOGLIN_STABLE)));

        if (key == BuiltInLootTables.BASTION_TREASURE)
            tableBuilder.withPool(LootPool.lootPool().add(NestedLootTable.lootTableReference(MND_BASTION_TREASURE)));
    }

    private static void replaceLoot(ResourceKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, HolderLookup.Provider registries) {
        if (key == ENTITIES_HOGLIN) {
            // remplace_hoglin_cooked_pork_loin and remplace_hoglin_pork_loin
            replaceItems(tableBuilder, Map.of(Items.PORKCHOP, MNDItems.HOGLIN_LOIN.get(), Items.COOKED_PORKCHOP, MNDItems.COOKED_LOIN.get()));
        }
    }

    public static void replaceItems(LootTable.Builder tableBuilder, Map<Item, Item> items) {
        Map<LootPool.Builder, LootPool.Builder> toAdd = Maps.newHashMap();
        tableBuilder.modifyPools(builder -> {
            LootPool oldLootPool = builder.build();
            boolean replaced = false;

            LootPool.Builder newPool = LootPool.lootPool();
            newPool.setRolls(oldLootPool.rolls);
            newPool.setBonusRolls(oldLootPool.bonusRolls);
            newPool.conditionally(oldLootPool.conditions);
            newPool.apply(oldLootPool.functions);

            for (LootPoolEntryContainer container : oldLootPool.entries) {
                if (container instanceof LootItem && container instanceof LootItemAccessor accessor &&
                        items.containsKey(accessor.mynethersdelightrefabricated$getItem().value())) {
                    newPool.add(LootItem.lootTableItem(items.get(accessor.mynethersdelightrefabricated$getItem().value())));
                    replaced = true;
                } else {
                    newPool.with(container);
                }
            }
            if (replaced) {
                builder.conditionally(new AlwaysFalseCondition());
                toAdd.put(builder, newPool);
            }
        });

        for (LootPool.Builder builder : toAdd.values()) {
            tableBuilder.withPool(builder);
        }
    }

    private static void scavengingLoot(ResourceKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, HolderLookup.Provider registries) {
        HolderLookup<Enchantment> enchantments = registries.lookupOrThrow(Registries.ENCHANTMENT);
        if (key == ENTITIES_GHAST) {
            // scavenging_extra_ghasta0
            tableBuilder.withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(MNDItems.GHASTA.get()))
                    .when(() -> new LootItemRandomChanceWithEnchantedBonusCondition(0.25F, LevelBasedValue.perLevel(0.25F, 0.1F), enchantments.getOrThrow(Enchantments.LOOTING))));
            // scavenging_extra_ghasta1
            tableBuilder.withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(MNDItems.GHASTA.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0F))))
                    .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity()
                            .equipment(EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.KNIVES))))));
            // scavenging_ghasta
            tableBuilder.withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(MNDItems.GHASTA.get()))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(registries, 0.5F, 0.1F)));
            // scavenging_onion_from_ghast
            tableBuilder.withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(ModItems.ONION.get()))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(registries, 0.025F, 0.01F)));
        }
        if (key == ENTITIES_HOGLIN) {
            // scavenging_hoglin_hide
            tableBuilder.withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(MNDItems.HOGLIN_HIDE.get()))
                    .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity()
                                    .equipment(EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.KNIVES))))
                            .and(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(false))))
                            .and(() -> new LootItemRandomChanceWithEnchantedBonusCondition(0.35F, LevelBasedValue.perLevel(0.25F, 0.1F), enchantments.getOrThrow(Enchantments.LOOTING)))));
        }
        if (key == ENTITIES_STRIDER) {
            // scavenging_extra_strider_egg0
            tableBuilder.withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(MNDItems.STRIDER_ROCK.get()))
                    .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity()
                                    .equipment(EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.KNIVES))))
                            .and(() -> new LootItemRandomChanceWithEnchantedBonusCondition(0.2F, LevelBasedValue.perLevel(0.25F, 0.1F), enchantments.getOrThrow(Enchantments.LOOTING)))));
            // scavenging_extra_strider_egg1
            tableBuilder.withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(MNDItems.STRIDER_ROCK.get()))
                    .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity()
                                    .equipment(EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.KNIVES))))
                            .and(() -> new LootItemRandomChanceWithEnchantedBonusCondition(0.25F, LevelBasedValue.perLevel(0.25F, 0.1F), enchantments.getOrThrow(Enchantments.LOOTING)))));
            // scavenging_extra_strider_egg2
            tableBuilder.withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(MNDItems.STRIDER_ROCK.get()))
                    .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity()
                                    .equipment(EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.KNIVES))))
                            .and(() -> new LootItemRandomChanceWithEnchantedBonusCondition(0.3F, LevelBasedValue.perLevel(0.25F, 0.1F), enchantments.getOrThrow(Enchantments.LOOTING)))));
            // scavenging_extra_strider_slice0
            tableBuilder.withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(MNDItems.STRIDER_SLICE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))))
                    .when(() -> new LootItemRandomChanceWithEnchantedBonusCondition(0.25F, LevelBasedValue.perLevel(0.25F, 0.1F), enchantments.getOrThrow(Enchantments.LOOTING))));
            // scavenging_extra_strider_slice1
            tableBuilder.withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(MNDItems.STRIDER_SLICE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F))))
                    .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity()
                                    .equipment(EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.KNIVES))))
                            .and(() -> new LootItemRandomChanceWithEnchantedBonusCondition(0.25F, LevelBasedValue.perLevel(0.25F, 0.1F), enchantments.getOrThrow(Enchantments.LOOTING)))));
            // scavenging_strider_egg
            tableBuilder.withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(MNDItems.STRIDER_ROCK.get()))
                    .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity()
                                    .equipment(EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.KNIVES))))
                            .and(() -> new LootItemRandomChanceWithEnchantedBonusCondition(0.5F, LevelBasedValue.perLevel(0.5F, 0.1F), enchantments.getOrThrow(Enchantments.LOOTING)))));
            // scavenging_strider_slice
            tableBuilder.withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(MNDItems.STRIDER_SLICE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))));
        }
    }

    private static void slicingLoot(ResourceKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, HolderLookup.Provider registries) {
        // slicing_magma_cake
        if (key == BLOCKS_MAGMA_CAKE_BLOCK) {
            for (int state = 0; state < 7; ++state) {
                for (int i = 0; i < 2; ++i) {
                    float amount = (i * 7) - state;
                    tableBuilder.withPool(LootPool.lootPool().add(LootItem.lootTableItem(MNDItems.MAGMA_CAKE_SLICE.get())
                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(amount))))
                            .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(MNDBlocks.MAGMA_CAKE_BLOCK.get())
                                    .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MagmaCakeBlock.BITES, state).hasProperty(MagmaCakeBlock.SECOND_CAKE, i == 1))));
                }
            }
        }
    }

    private static ResourceKey<LootTable> vanillaKey(String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace(path));
    }

    private static ResourceKey<LootTable> key(String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, MyNethersDelight.res(path));
    }
}