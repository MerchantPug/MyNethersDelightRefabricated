package com.soytutta.mynethersdelight.common.registry;

import com.soytutta.mynethersdelight.common.block.entity.MNDHangingSignBlockEntity;
import com.soytutta.mynethersdelight.common.block.entity.MNDSignBlockEntity;
import com.soytutta.mynethersdelight.common.block.entity.NetherStoveBlockEntity;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class MNDBlockEntityTypes {

    public static final LazyRegistrar<BlockEntityType<?>> TILES = LazyRegistrar.create(Registries.BLOCK_ENTITY_TYPE, "mynethersdelight");
    public static final Supplier<BlockEntityType<NetherStoveBlockEntity>> NETHER_STOVE;
    public static final Supplier<BlockEntityType<MNDSignBlockEntity>> MND_SIGN;
    public static final Supplier<BlockEntityType<MNDHangingSignBlockEntity>> MND_HSIGN;

    public MNDBlockEntityTypes() {
    }

    static {
        NETHER_STOVE = TILES.register("nether_stove", () ->
                BlockEntityType.Builder.of(NetherStoveBlockEntity::new,
                        new Block[]{MNDBlocks.NETHER_STOVE.get()}).build(null)
        );
        MND_SIGN = TILES.register("mnd_sign", () ->
                BlockEntityType.Builder.of(MNDSignBlockEntity::new,
                        MNDBlocks.POWDERY_SIGN.get(), MNDBlocks.POWDERY_WALL_SIGN.get()).build((null))
        );
        MND_HSIGN = TILES.register("mnd_hsign", () ->
                BlockEntityType.Builder.of(MNDHangingSignBlockEntity::new,
                        MNDBlocks.POWDERY_HANGING_SIGN.get(), MNDBlocks.POWDERY_WALL_HANGING_SIGN.get()).build((null))
        );
    }
}
