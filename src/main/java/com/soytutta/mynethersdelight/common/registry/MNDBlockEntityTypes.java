package com.soytutta.mynethersdelight.common.registry;

import com.soytutta.mynethersdelight.MyNethersDelight;
import com.soytutta.mynethersdelight.common.block.entity.MNDHangingSignBlockEntity;
import com.soytutta.mynethersdelight.common.block.entity.MNDSignBlockEntity;
import com.soytutta.mynethersdelight.common.block.entity.NetherStoveBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import vectorwing.farmersdelight.common.registry.ModBlockEntityTypes;

import java.util.function.Supplier;

public class MNDBlockEntityTypes {
    public static final Supplier<BlockEntityType<NetherStoveBlockEntity>> NETHER_STOVE = register("nether_stove", () ->
            BlockEntityType.Builder.of(NetherStoveBlockEntity::new,
                    new Block[]{MNDBlocks.NETHER_STOVE.get()}).build(null)
    );
    public static final Supplier<BlockEntityType<MNDSignBlockEntity>> MND_SIGN = register("mnd_sign", () ->
            BlockEntityType.Builder.of(MNDSignBlockEntity::new,
                    MNDBlocks.POWDERY_SIGN.get(), MNDBlocks.POWDERY_WALL_SIGN.get()).build((null))
    );
    public static final Supplier<BlockEntityType<MNDHangingSignBlockEntity>> MND_HSIGN = register("mnd_hsign", () ->
            BlockEntityType.Builder.of(MNDHangingSignBlockEntity::new,
                    MNDBlocks.POWDERY_HANGING_SIGN.get(), MNDBlocks.POWDERY_WALL_HANGING_SIGN.get()).build((null))
    );

    public static void register() {}

    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> register(String path, Supplier<BlockEntityType<T>> supp) {
        BlockEntityType<T> value = supp.get();
        Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, MyNethersDelight.res(path), value);
        return () -> value;
    }

    public static void addCabinetsBlockEntities() {
        ModBlockEntityTypes.CABINET.get().addSupportedBlock(MNDBlocks.BLACKSTONE_BRICKS_CABINET.get());
        ModBlockEntityTypes.CABINET.get().addSupportedBlock(MNDBlocks.NETHER_BRICKS_CABINET.get());
        ModBlockEntityTypes.CABINET.get().addSupportedBlock(MNDBlocks.POWDERY_CABINET.get());
        ModBlockEntityTypes.CABINET.get().addSupportedBlock(MNDBlocks.RED_NETHER_BRICKS_CABINET.get());
    }
}
