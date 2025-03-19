package com.soytutta.mynethersdelight.common.block;

import com.soytutta.mynethersdelight.common.registry.MNDBlocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class StrippableBlock extends RotatedPillarBlock {

    public StrippableBlock(Properties properties) {
        super(properties);
        StrippableBlockRegistry.register(this, MNDBlocks.BLOCK_OF_STRIPPED_POWDERY_CANNON.get());
    }

    @Deprecated
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return false;
    }
}