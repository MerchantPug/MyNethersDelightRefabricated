package com.soytutta.mynethersdelight.core.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.soytutta.mynethersdelight.common.block.LetiosCompostBlock;
import com.soytutta.mynethersdelight.common.block.ResurgentSoilBlock;
import com.soytutta.mynethersdelight.common.block.ResurgentSoilFarmlandBlock;
import com.soytutta.mynethersdelight.common.tag.MNDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import vectorwing.farmersdelight.common.block.MushroomColonyBlock;

/**
 * Fabric should <b>really</b> have an event for this...
 * This is the bare minimum to keep parity with Forge.
 */
@Mixin(MushroomColonyBlock.class)
public class MushroomColonyBlockMixin {
    @ModifyExpressionValue(method = "canSurvive", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;canSustainPlant(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;Lio/github/fabricators_of_create/porting_lib/common/util/IPlantable;)Z"))
    private boolean mynethersdelightrefabricated$allowPlantsOnMushroomColony(boolean original, BlockState state, LevelReader level, BlockPos pos) {
        if (!(state.getBlock() == (Object)this))
            return original;

        if (level.getBlockState(pos.below()).getBlock() instanceof ResurgentSoilBlock)
            return !((Block)(Object)this).builtInRegistryHolder().is(MNDTags.DOES_NOT_SURVIVE_RESURGENT_SOIL);

        if (level.getBlockState(pos.below()).getBlock() instanceof ResurgentSoilFarmlandBlock)
            return ((Block)(Object)this).builtInRegistryHolder().is(MNDTags.SURVIVES_RESURGENT_SOIL_FARMLAND);

        return original;
    }
}
