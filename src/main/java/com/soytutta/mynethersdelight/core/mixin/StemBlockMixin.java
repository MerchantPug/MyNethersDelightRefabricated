package com.soytutta.mynethersdelight.core.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.soytutta.mynethersdelight.common.block.ResurgentSoilBlock;
import com.soytutta.mynethersdelight.common.block.ResurgentSoilFarmlandBlock;
import com.soytutta.mynethersdelight.common.tag.MNDTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/**
 * This is also the bare minimum to allow parity with Forge.
 * @see BushBlockMixin
 */
@Mixin(StemBlock.class)
public class StemBlockMixin {
    @ModifyExpressionValue(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z"))
    private boolean mynethersdelightrefabricated$modifyRandomTickCallForStems(boolean original, @Local(ordinal = 1) BlockState below) {
        if (below.getBlock() instanceof ResurgentSoilBlock)
            return !((Block)(Object)this).builtInRegistryHolder().is(MNDTags.DOES_NOT_SURVIVE_RESURGENT_SOIL);

        if (below.getBlock() instanceof ResurgentSoilFarmlandBlock)
            return ((Block)(Object)this).builtInRegistryHolder().is(MNDTags.SURVIVES_RESURGENT_SOIL_FARMLAND);

        return original;
    }
}
