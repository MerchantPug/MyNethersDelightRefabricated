package com.soytutta.mynethersdelight.core.mixin.refabricated;

import com.soytutta.mynethersdelight.common.events.CommonEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "dropAllDeathLoot", at = @At("HEAD"), cancellable = true)
    private void mynethersdelightrefabricated$dropCapturedDrops(ServerLevel level, DamageSource damageSource, CallbackInfo ci) {
        if (!CommonEvent.onMobDrop((LivingEntity)(Object)this))
            ci.cancel();
    }
}
