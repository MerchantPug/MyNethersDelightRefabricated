package com.soytutta.mynethersdelight.core.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.soytutta.mynethersdelight.common.block.ResurgentSoilBlock;
import com.soytutta.mynethersdelight.common.block.ResurgentSoilFarmlandBlock;
import com.soytutta.mynethersdelight.common.tag.MNDTags;
import com.soytutta.mynethersdelight.common.utility.MNDSoilUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/**
 * Fabric should <b>really</b> have an event for this...
 * This is the bare minimum to keep parity with Forge.
 */
@Mixin(StemBlock.class)
public class StemBlockMixin {
    @ModifyExpressionValue(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z"))
    private boolean mynethersdelightrefabricated$modifyRandomTickCallForStems(boolean original, @Local(ordinal = 1) BlockState below) {
        if (below.getBlock() instanceof ResurgentSoilBlock)
            return MNDSoilUtils.isAbleToPlaceResurgentSoil((Block)(Object)this);

        if (below.getBlock() instanceof ResurgentSoilFarmlandBlock)
            return MNDSoilUtils.isAbleToPlaceResurgentSoilFarmland((Block)(Object)this);
        return original;
    }
}
