package com.soytutta.mynethersdelight.core.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.soytutta.mynethersdelight.common.block.LetiosCompostBlock;
import com.soytutta.mynethersdelight.common.block.ResurgentSoilBlock;
import com.soytutta.mynethersdelight.common.block.ResurgentSoilFarmlandBlock;
import com.soytutta.mynethersdelight.common.tag.MNDTags;
import com.soytutta.mynethersdelight.common.utility.MNDSoilUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/**
 * Fabric should <b>really</b> have an event for this...
 * This is the bare minimum to keep parity with Forge.
 */
@Mixin(MushroomBlock.class)
public class MushroomBlockMixin {
    @ModifyExpressionValue(method = "canSurvive", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/MushroomBlock;mayPlaceOn(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)Z"))
    private boolean mynethersdelightrefabricated$allowPlantsOnMushroom(boolean original, BlockState state, LevelReader level, BlockPos pos) {
        if (state.getBlock() != (Object)this)
            return original;

        if (level.getBlockState(pos.below()).getBlock() instanceof ResurgentSoilBlock)
            return MNDSoilUtils.isAbleToPlaceResurgentSoil((Block)(Object)this);

        if (level.getBlockState(pos.below()).getBlock() instanceof ResurgentSoilFarmlandBlock)
            return MNDSoilUtils.isAbleToPlaceResurgentSoilFarmland((Block)(Object)this);

        return original;
    }
}
