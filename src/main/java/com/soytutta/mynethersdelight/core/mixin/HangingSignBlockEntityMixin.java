package com.soytutta.mynethersdelight.core.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.soytutta.mynethersdelight.common.registry.MNDBlockEntityTypes;
import com.soytutta.mynethersdelight.common.registry.MNDBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(HangingSignBlockEntity.class)
public class HangingSignBlockEntityMixin {
    @ModifyArg(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/SignBlockEntity;<init>(Lnet/minecraft/world/level/block/entity/BlockEntityType;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V"))
    private static BlockEntityType mynethersdelightrefabricated$setMNDHangingSignBlockEntityType(BlockEntityType original, @Local(argsOnly = true) BlockState state) {
        if (state.is(MNDBlocks.POWDERY_HANGING_SIGN.get()) || state.is(MNDBlocks.POWDERY_WALL_HANGING_SIGN.get()))
            return MNDBlockEntityTypes.MND_HSIGN.get();
        return original;
    }
}
