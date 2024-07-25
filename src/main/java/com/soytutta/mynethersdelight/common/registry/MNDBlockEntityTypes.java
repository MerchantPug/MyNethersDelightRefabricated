package com.soytutta.mynethersdelight.common.registry;

import com.soytutta.mynethersdelight.common.block.entity.MNDSignBlockEntity;
import com.soytutta.mynethersdelight.common.block.entity.NetherStoveBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MNDBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "mynethersdelight");
    public static final RegistryObject<BlockEntityType<NetherStoveBlockEntity>> NETHER_STOVE;
    public static final RegistryObject<BlockEntityType<MNDSignBlockEntity>> MND_SIGN;

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
    }
}
