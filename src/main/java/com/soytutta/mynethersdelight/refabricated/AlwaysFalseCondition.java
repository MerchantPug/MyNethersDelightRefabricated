package com.soytutta.mynethersdelight.refabricated;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

public class AlwaysFalseCondition implements LootItemCondition {
    public static final MapCodec<AlwaysFalseCondition> CODEC = MapCodec.unit(AlwaysFalseCondition::new);
    public static final LootItemConditionType TYPE = new LootItemConditionType(CODEC);

    @Override
    public boolean test(LootContext context) {
        return false;
    }

    @Override
    public LootItemConditionType getType() {
        return TYPE;
    }
}
