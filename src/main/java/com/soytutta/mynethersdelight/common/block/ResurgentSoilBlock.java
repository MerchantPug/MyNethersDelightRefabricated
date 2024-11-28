//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package com.soytutta.mynethersdelight.common.block;

import com.soytutta.mynethersdelight.common.registry.MNDBlocks;
import com.soytutta.mynethersdelight.common.tag.MNDTags;
import io.github.fabricators_of_create.porting_lib.tool.ItemAbilities;
import io.github.fabricators_of_create.porting_lib.tool.ItemAbility;
import net.fabricmc.fabric.api.registry.TillableBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.block.MushroomColonyBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.MathUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.minecraft.world.level.block.PinkPetalsBlock.FACING;

public class ResurgentSoilBlock extends Block {
    public ResurgentSoilBlock(BlockBehaviour.Properties properties) {
        super(properties);
        TillableBlockRegistry.register(this, context ->  context.getLevel().getBlockState(context.getClickedPos().above()).isAir(), MNDBlocks.RESURGENT_SOIL_FARMLAND.get().defaultBlockState());
    }

    @Override
    @SuppressWarnings("deprecation")
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
        if (!level.isClientSide) {
            BlockPos abovePos = pos.above();
            BlockState aboveState = level.getBlockState(abovePos);
            Block aboveBlock = aboveState.getBlock();

            BlockPos belowPos = pos.below();
            BlockState belowState = level.getBlockState(belowPos);
            Block belowBlock = belowState.getBlock();

            if (aboveBlock == Blocks.CRIMSON_FUNGUS) {
                level.setBlockAndUpdate(pos.above(), MNDBlocks.CRIMSON_FUNGUS_COLONY.get().defaultBlockState());
                return;
            }
            if (aboveBlock == Blocks.WARPED_FUNGUS) {
                level.setBlockAndUpdate(pos.above(), MNDBlocks.WARPED_FUNGUS_COLONY.get().defaultBlockState());
                return;
            }

            if (aboveBlock == Blocks.BROWN_MUSHROOM) {
                level.setBlockAndUpdate(pos.above(), ModBlocks.BROWN_MUSHROOM_COLONY.get().defaultBlockState());
                return;
            }
            if (aboveBlock == Blocks.RED_MUSHROOM) {
                level.setBlockAndUpdate(pos.above(), ModBlocks.RED_MUSHROOM_COLONY.get().defaultBlockState());
                return;
            }

            if (Configuration.RICH_SOIL_BOOST_CHANCE.get() == 0.0) {
                return;
            }

            if (aboveBlock == MNDBlocks.POWDERY_TORCH.get()
                    && MathUtils.RAND.nextFloat() <= (Configuration.RICH_SOIL_BOOST_CHANCE.get() / 15)) {
                if (level.isEmptyBlock(pos.above(2))) {
                    level.setBlockAndUpdate(pos.above(), MNDBlocks.POWDERY_CANE.get().defaultBlockState().setValue(PowderyCaneBlock.BASE, true));
                    level.setBlockAndUpdate(pos.above(2), MNDBlocks.BULLET_PEPPER.get().defaultBlockState().setValue(PowderyFlowerBlock.LIT, true).setValue(PowderyFlowerBlock.AGE, 2));
                    return;
                }
            }

            if (!aboveState.is(MNDTags.NOT_PROPAGATE_PLANT)) {
                if (aboveState.is(MNDTags.ABOVE_PROPAGATE_PLANT)
                        && MathUtils.RAND.nextFloat() <= (Configuration.RICH_SOIL_BOOST_CHANCE.get() * 0.6F)) {
                    propagateAboveIfPossible(aboveBlock, abovePos, level);
                    return;
                }

                if (aboveBlock instanceof FlowerBlock
                        && MathUtils.RAND.nextFloat() <= Configuration.RICH_SOIL_BOOST_CHANCE.get() * 0.8F) {
                    propagateAboveIfPossible(aboveBlock, abovePos, level);
                    return;
                }

                if ((aboveBlock instanceof FungusBlock
                        || aboveBlock instanceof MushroomBlock)
                        && MathUtils.RAND.nextFloat() <= Configuration.RICH_SOIL_BOOST_CHANCE.get() * 0.4F) {
                    propagateAboveIfPossible(aboveBlock, abovePos, level);
                    return;
                }

                if (aboveBlock instanceof MushroomColonyBlock) {
                    int age = aboveState.getValue(MushroomColonyBlock.COLONY_AGE);
                    if (age == 3) {
                        if (MathUtils.RAND.nextFloat() <= (Configuration.RICH_SOIL_BOOST_CHANCE.get() * 0.4F)) {
                            propagateAboveIfPossible(aboveBlock, abovePos, level);
                        }
                    }
                    return;
                }

                if (aboveBlock instanceof NetherWartBlock) {
                    int age = aboveState.getValue(NetherWartBlock.AGE);
                    if (age < 3) {
                        return;
                    } else if (age == 3) {
                        if (level.random.nextInt(8) == 0){
                            propagateAboveIfPossible(aboveBlock, abovePos, level);
                        }
                    }
                    return;
                }

                if (aboveBlock instanceof PinkPetalsBlock) {
                    int age = aboveState.getValue(PinkPetalsBlock.AMOUNT);
                    if (age != PinkPetalsBlock.MAX_FLOWERS) {
                    performBonemealIfPossible(aboveBlock, pos.above(), aboveState, level, 1);
                    } else if (level.random.nextInt(6) == 0) {
                        propagateAboveIfPossible(aboveBlock, abovePos, level);
                    }
                    return;
                }

                if ((aboveBlock instanceof DoublePlantBlock)
                    && MathUtils.RAND.nextFloat() <= (Configuration.RICH_SOIL_BOOST_CHANCE.get() / 2)) {
                    propagateAboveIfPossible(aboveBlock, abovePos, level);
                    return;
                }

                if ((aboveBlock instanceof BushBlock && !(aboveBlock instanceof DoublePlantBlock))
                        && MathUtils.RAND.nextFloat() <= (Configuration.RICH_SOIL_BOOST_CHANCE.get() / 3)) {
                    propagateAboveIfPossible(aboveBlock, abovePos, level);
                    return;
                }
            }

            if (!belowState.is(MNDTags.NOT_PROPAGATE_PLANT)) {
                if (belowState.is(MNDTags.BELOW_PROPAGATE_PLANT)
                    && MathUtils.RAND.nextFloat() <= (Configuration.RICH_SOIL_BOOST_CHANCE.get()) * 0.8F) {
                    propagateBelowIfPossible(belowBlock, belowPos, level);
                    return;
                }
            }

            if (!(belowBlock instanceof CaveVinesBlock || belowBlock instanceof CaveVinesPlantBlock)
                    && (belowBlock instanceof GrowingPlantHeadBlock || belowBlock instanceof GrowingPlantBodyBlock)
                    && MathUtils.RAND.nextFloat() <= (Configuration.RICH_SOIL_BOOST_CHANCE.get() * 0.2F)) {
                performBonemealIfPossible(belowBlock, pos.below(), belowState, level, 1);
            }

            if ((aboveBlock instanceof GrowingPlantHeadBlock || aboveBlock instanceof GrowingPlantBodyBlock)
                    && MathUtils.RAND.nextFloat() <= (Configuration.RICH_SOIL_BOOST_CHANCE.get() * 0.2F)) {
                performBonemealIfPossible(aboveBlock, pos.above(), aboveState, level, 1);
            }

            int BonemealChance = 1;
            if (MathUtils.RAND.nextFloat() <= 0.2f) {
                BonemealChance = 2;
                if (MathUtils.RAND.nextFloat() <= 0.01f) {
                    BonemealChance = 3;
                }
            }

            for (int i = 0; i < MathUtils.RAND.nextInt(BonemealChance) + 1; i++) {
                performBonemealIfPossible(aboveBlock, pos.above(), aboveState, level, 1);
                performBonemealIfPossible(belowBlock, pos.below(), belowState, level, 1);
            }
            growIfPossible(aboveState, abovePos, level, Blocks.SUGAR_CANE, 7);
            growIfPossible(aboveState, abovePos, level, Blocks.CACTUS, 7);
        }
    }

    private void performBonemealIfPossible(Block block, BlockPos position, BlockState state, ServerLevel level, int distance) {
        if (state.is(ModTags.UNAFFECTED_BY_RICH_SOIL) || block instanceof TallFlowerBlock) {
            return;
        }

        if (block instanceof BonemealableBlock growable && MathUtils.RAND.nextFloat() <= Configuration.RICH_SOIL_BOOST_CHANCE.get() / distance) {
            if (growable.isValidBonemealTarget(level, position.above(),state)) {
                growable.performBonemeal(level, level.random, position, state);
                for (int i = 0; i < 3; i++) {
                    double d0 = (double) position.getX() + level.getRandom().nextDouble();
                    double d1 = (double) position.getY() + level.getRandom().nextDouble();
                    double d2 = (double) position.getZ() + level.getRandom().nextDouble();
                    level.sendParticles(ParticleTypes.SOUL, d0, d1, d2, 1, 0.0D, 0.0D, 0.0D, 0.0D);
                    level.playSound(null, position, SoundEvents.SOUL_ESCAPE.value(), SoundSource.BLOCKS, 1.0F, 1.0F);
                }
            } else {
                BlockPos checkPos = position.above();
                BlockState checkState = level.getBlockState(checkPos);
                Block checkBlock = checkState.getBlock();
                while (checkBlock == block && distance <= 10) {
                    performBonemealIfPossible(checkBlock, checkPos, checkState, level, distance + 1);
                    distance++;
                    checkPos = checkPos.above();
                    checkState = level.getBlockState(checkPos);
                    checkBlock = checkState.getBlock();
                }

                checkPos = position.below();
                checkState = level.getBlockState(checkPos);
                checkBlock = checkState.getBlock();
                while (checkBlock == block && distance <= 10) {
                    performBonemealIfPossible(checkBlock, checkPos, checkState, level, distance + 1);
                    distance++;
                    checkPos = checkPos.below();
                    checkState = level.getBlockState(checkPos);
                    checkBlock = checkState.getBlock();
                }
            }
        }
    }

    public static void growIfPossible(BlockState aboveBlock, BlockPos abovePos, ServerLevel level, Block targetBlock, int maxHeight) {
        if (aboveBlock.getBlock() == targetBlock && MathUtils.RAND.nextFloat() <= (Configuration.RICH_SOIL_BOOST_CHANCE.get() * 0.6F)) {
            BlockPos topPos = abovePos;
            int height = 1;
            while (level.getBlockState(topPos.above()).getBlock() == targetBlock) {
                topPos = topPos.above();
                height++;
            }
            if (level.getBlockState(topPos.above()).isAir() && height < maxHeight) {
                level.setBlockAndUpdate(topPos.above(), targetBlock.defaultBlockState());
                for (int i = 0; i < 3; i++) {
                    double d0 = (double) topPos.above().getX() + level.getRandom().nextDouble();
                    double d1 = (double) topPos.above().getY() + level.getRandom().nextDouble();
                    double d2 = (double) topPos.above().getZ() + level.getRandom().nextDouble();
                    level.sendParticles(ParticleTypes.SOUL, d0, d1, d2, 1, 0.0D, 0.0D, 0.0D, 0.0D);
                    level.playSound(null, topPos.above(), SoundEvents.SOUL_ESCAPE.value(), SoundSource.BLOCKS, 1.0F, 1.0F);
                }
            }
        }
    }

    private void propagateAboveIfPossible(Block block, BlockPos position, ServerLevel level) {
        List<BlockPos> validPositions = new ArrayList<>();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    BlockPos newPos = position.offset(x, y, z);
                    BlockState newState = level.getBlockState(newPos);

                    if (canAboveBlockSurvive(block, newState, level, newPos)) {
                        validPositions.add(newPos);
                    }
                }
            }
        }

        if (!validPositions.isEmpty()) {
            BlockPos plantPos = validPositions.get(level.random.nextInt(validPositions.size()));
            BlockState targetState = level.getBlockState(plantPos);

            boolean canPropagate = (block instanceof LiquidBlockContainer && targetState.getBlock() == Blocks.WATER)
                    || (!(block instanceof LiquidBlockContainer) && targetState.getBlock() == Blocks.AIR)
                    || (block instanceof WitherRoseBlock && (targetState.is(BlockTags.SMALL_FLOWERS)
                    || targetState.getBlock() instanceof FungusBlock || targetState.getBlock() instanceof MushroomBlock))
                    || ((block instanceof SimpleWaterloggedBlock) && (targetState.getBlock() == Blocks.AIR || targetState.getBlock() == Blocks.WATER));

            if (canPropagate) {
                placeBlock(block, level, plantPos);
            }
        }
    }

    private boolean canAboveBlockSurvive(Block block, BlockState newState, ServerLevel level, BlockPos newPos) {
        BlockState blockBelowState = level.getBlockState(newPos.below());
        if (block instanceof WitherRoseBlock
                && ((newState.is(BlockTags.SMALL_FLOWERS)
                || newState.getBlock() instanceof FungusBlock
                || newState.getBlock() instanceof MushroomBlock)
                && !(newState.getBlock() instanceof WitherRoseBlock))) {
            return true;  // Wither Rose can replace other FlowerBlocks
        } else if (block instanceof DoublePlantBlock) {
            BlockState doublePlantState = block.defaultBlockState();
            if (!(block instanceof LiquidBlockContainer && !(block instanceof SimpleWaterloggedBlock)) && level.isEmptyBlock(newPos.above())) {
                return doublePlantState.canSurvive(level, newPos);
            } else if (level.getFluidState(newPos.above()).is(FluidTags.WATER) && level.getFluidState(newPos.above()).getAmount() == 8) {
                return doublePlantState.canSurvive(level, newPos);
            }
        } else if (block instanceof NetherWartBlock) {
            return blockBelowState.getBlock() == Blocks.SOUL_SAND
                    || blockBelowState.getBlock() == MNDBlocks.RESURGENT_SOIL.get()
                    || blockBelowState.getBlock() == MNDBlocks.RESURGENT_SOIL_FARMLAND.get();
        } else if (!(block instanceof WitherRoseBlock || block instanceof DoublePlantBlock)) {
            return blockBelowState.getBlock() == ModBlocks.RICH_SOIL.get()
                    || blockBelowState.getBlock() == MNDBlocks.RESURGENT_SOIL.get();
        }
        return false;
    }

    private void propagateBelowIfPossible(Block block, BlockPos position, ServerLevel level) {
        List<BlockPos> validPositions = new ArrayList<>();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    BlockPos newPos = position.offset(x, y, z);

                    if (canBelowBlockSurvive(level, newPos)) {
                        validPositions.add(newPos);
                    }
                }
            }
        }

        if (!validPositions.isEmpty()) {
            BlockPos plantPos = validPositions.get(level.random.nextInt(validPositions.size()));
            BlockState targetState = level.getBlockState(plantPos);

            boolean canPropagate = (block instanceof LiquidBlockContainer && targetState.getBlock() == Blocks.WATER)
                    || (!(block instanceof LiquidBlockContainer) && targetState.getBlock() == Blocks.AIR)
                    || ((block instanceof SimpleWaterloggedBlock) && (targetState.getBlock() == Blocks.AIR || targetState.getBlock() == Blocks.WATER));

            if (canPropagate) {
                placeBlock(block, level, plantPos);
            }
        }
    }

    private boolean canBelowBlockSurvive(ServerLevel level, BlockPos newPos) {
        BlockState blockAboveState = level.getBlockState(newPos.above());
        return blockAboveState.getBlock() == ModBlocks.RICH_SOIL.get()
                || blockAboveState.getBlock() == MNDBlocks.RESURGENT_SOIL.get()
                || blockAboveState.getBlock() ==ModBlocks.RICH_SOIL_FARMLAND.get()
                || blockAboveState.getBlock() == MNDBlocks.RESURGENT_SOIL_FARMLAND.get();
    }

    private void placeBlock(Block block, ServerLevel level, BlockPos pos) {
        BlockState state = block.defaultBlockState();
        if (block instanceof SimpleWaterloggedBlock) {
            FluidState fluidState = level.getFluidState(pos);
            if (fluidState.getType() == Fluids.WATER) {
                state = state.setValue(BlockStateProperties.WATERLOGGED, true);
            } else {
                state = state.setValue(BlockStateProperties.WATERLOGGED, false);
            }
        }
        if (block instanceof PinkPetalsBlock) {
            Random random = new Random();
            Direction[] allowedDirections = {Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};
            Direction randomDirection = allowedDirections[random.nextInt(allowedDirections.length)];
            level.setBlockAndUpdate(pos, state.setValue(FACING, randomDirection));
        } else if (block instanceof DoublePlantBlock) {
            DoublePlantBlock.placeAt(level, state, pos, 3);
        } else {
            level.setBlockAndUpdate(pos, state);
        }
        for (int i = 0; i < 3; i++) {
            double d0 = (double) pos.getX() + level.getRandom().nextDouble();
            double d1 = (double) pos.getY() + level.getRandom().nextDouble();
            double d2 = (double) pos.getZ() + level.getRandom().nextDouble();
            level.sendParticles(ParticleTypes.SOUL, d0, d1, d2, 1, 0.0D, 0.0D, 0.0D, 0.0D);
            level.playSound(null, pos, SoundEvents.SOUL_ESCAPE.value(), SoundSource.BLOCKS, 1.0F, 1.0F);
        }
    }

    @Nullable
    @Deprecated
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility toolAction, boolean simulate) {
        if (toolAction.equals(ItemAbilities.HOE_TILL) && context.getLevel().getBlockState(context.getClickedPos().above()).isAir()) {
            return  MNDBlocks.RESURGENT_SOIL_FARMLAND.get().defaultBlockState();
        }
        return null;
    }
}