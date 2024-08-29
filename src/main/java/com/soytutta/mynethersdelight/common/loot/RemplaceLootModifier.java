package com.soytutta.mynethersdelight.common.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.fabricators_of_create.porting_lib.loot.IGlobalLootModifier;
import io.github.fabricators_of_create.porting_lib.loot.LootModifier;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class RemplaceLootModifier extends LootModifier {
    private final Item replacedItem;
    private final Item newItem;
    private final EntityType<?> entity;

    public static final Supplier<Codec<RemplaceLootModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst)
            .and(
                    inst.group(
                            BuiltInRegistries.ITEM.byNameCodec().fieldOf("replaces").forGetter((m) -> m.replacedItem),
                            BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter((m) -> m.newItem),
                            BuiltInRegistries.ENTITY_TYPE.byNameCodec().fieldOf("entity").forGetter((m) -> m.entity)
                    )
            )
            .apply(inst, RemplaceLootModifier::new)));

    protected RemplaceLootModifier(LootItemCondition[] conditionsIn, Item replacedItem, Item newItem, EntityType<?> entity) {
        super(conditionsIn);
        this.replacedItem = replacedItem;
        this.newItem = newItem;
        this.entity = entity;
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        Entity t = context.getParamOrNull(LootContextParams.THIS_ENTITY);
        if (t == null || t.getType() != this.entity) return generatedLoot;
        int amountOfItems = 0;
        for (ItemStack i : generatedLoot) {
            if (i.getItem() == replacedItem) {
                amountOfItems += i.getCount();
            }
        }
        generatedLoot.removeIf(i -> i.getItem() == replacedItem);
        generatedLoot.add(new ItemStack(newItem, amountOfItems));
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec()
    {
        return CODEC.get();
    }
}
