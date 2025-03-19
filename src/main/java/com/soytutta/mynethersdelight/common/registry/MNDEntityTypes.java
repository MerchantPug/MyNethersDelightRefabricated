//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package com.soytutta.mynethersdelight.common.registry;

import com.soytutta.mynethersdelight.MyNethersDelight;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import com.soytutta.mynethersdelight.common.entity.StriderRockEntity;

import java.util.function.Supplier;

public class MNDEntityTypes {
    public static final Supplier<EntityType<StriderRockEntity>> STRIDER_ROCK =
            register("strider_rock", () ->
                    EntityType.Builder.<StriderRockEntity>of(StriderRockEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(4)
                            .updateInterval(10)
                            .build());

    public static void register() {}

    private static <T extends Entity> Supplier<EntityType<T>> register(String path, Supplier<EntityType<T>> supp) {
        EntityType<T> value = supp.get();
        Registry.register(BuiltInRegistries.ENTITY_TYPE, MyNethersDelight.res(path), value);
        return () -> value;
    }
}