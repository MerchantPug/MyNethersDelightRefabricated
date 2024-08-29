//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package com.soytutta.mynethersdelight.common.registry;

import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import com.soytutta.mynethersdelight.common.entity.StriderRockEntity;

import java.util.function.Supplier;

public class MNDEntityTypes {

    public static final LazyRegistrar<EntityType<?>> ENTITIES = LazyRegistrar.create(Registries.ENTITY_TYPE, "mynethersdelight");
    public static final Supplier<EntityType<StriderRockEntity>> STRIDER_ROCK;

    static {
        STRIDER_ROCK = ENTITIES.register("strider_rock", () -> EntityType.Builder.<StriderRockEntity>of(StriderRockEntity::new, MobCategory.MISC)
                .sized(0.25F, 0.25F)
                .clientTrackingRange(4)
                .updateInterval(10)
                .build("strider_rock"));
    }
}
