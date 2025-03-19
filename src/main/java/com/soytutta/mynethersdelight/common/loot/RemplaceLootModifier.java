package com.soytutta.mynethersdelight.common.loot;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.refabricated.LootModifier;

@Deprecated
public class RemplaceLootModifier extends LootModifier {
    private final Item replacedItem;
    private final Item newItem;
    private final EntityType<?> entity;

    public RemplaceLootModifier(LootItemCondition[] conditionsIn, Item replacedItem, Item newItem, EntityType<?> entity) {
        super(conditionsIn);
        this.replacedItem = replacedItem;
        this.newItem = newItem;
        this.entity = entity;
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        Entity entity = context.getParamOrNull(LootContextParams.THIS_ENTITY);
        if (entity != null && entity.getType() == this.entity) {
            int amountOfItems = generatedLoot.stream()
                    .filter(itemStack -> itemStack.getItem() == replacedItem)
                    .mapToInt(ItemStack::getCount)
                    .sum();
            generatedLoot.removeIf(itemStack -> itemStack.getItem() == replacedItem);
            generatedLoot.add(new ItemStack(newItem, amountOfItems));
        }
        return generatedLoot;
    }

    public Item getReplacedItem() {
        return replacedItem;
    }

    public Item getNewItem() {
        return newItem;
    }

    public EntityType<?> getEntity() {
        return entity;
    }
}