package com.soytutta.mynethersdelight.common.registry;

import com.mojang.serialization.MapCodec;
import com.soytutta.mynethersdelight.MyNethersDelight;
import com.soytutta.mynethersdelight.common.loot.MNDEspecialLootModifier;
import com.soytutta.mynethersdelight.common.loot.RemplaceLootModifier;
import io.github.fabricators_of_create.porting_lib.loot.IGlobalLootModifier;
import io.github.fabricators_of_create.porting_lib.loot.PortingLibLoot;
import io.github.fabricators_of_create.porting_lib.util.DeferredRegister;

import java.util.function.Supplier;

public class MNDLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(PortingLibLoot.GLOBAL_LOOT_MODIFIER_SERIALIZERS_KEY, MyNethersDelight.MODID);

    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> ESPECIAL_DROP =
            LOOT_MODIFIERS.register("especial_drop", MNDEspecialLootModifier.CODEC);
    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> REMPLACE_LOOT =
            LOOT_MODIFIERS.register("remplace_item", RemplaceLootModifier.CODEC);
}