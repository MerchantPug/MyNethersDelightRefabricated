package com.soytutta.mynethersdelight.common.effect;

import com.soytutta.mynethersdelight.common.registry.MNDEffects;
import com.soytutta.mynethersdelight.common.tag.MNDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class PungentEffect extends MobEffect {
    public PungentEffect() {
        super(MobEffectCategory.NEUTRAL, 0);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        MobEffectInstance fireResistanceEffect = entity.getEffect(MobEffects.FIRE_RESISTANCE);
        MobEffectInstance BPungentEffect = entity.getEffect(MNDEffects.BPUNGENT);
        MobEffectInstance GPungentEffect = entity.getEffect(MNDEffects.GPUNGENT);

        if (entity.fireImmune() || fireResistanceEffect != null) {
            switchEffect(entity, BPungentEffect, MNDEffects.GPUNGENT.value());
        } else {
            switchEffect(entity, GPungentEffect, MNDEffects.BPUNGENT.value());
        }

        if (isInFireCondition(entity) || entity.isInLava() || entity.isOnFire()) {
            float minHealth = (amplifier >= 2) ? 2.0F :
                    (amplifier == 1) ? (entity.getMaxHealth() / 2) :
                            (entity.getMaxHealth() - (entity.getMaxHealth() / 4));

            if (entity.getHealth() > minHealth) {
                entity.hurt(entity.damageSources().magic(), 1.0f);
            }

            if (isInFireCondition(entity)) {
                if (entity.getHealth() > minHealth) {
                    entity.setRemainingFireTicks(3);
                }
            } else if (entity.isOnFire()) {
                entity.setRemainingFireTicks(0);
                entity.clearFire();
            }

        }
        return true;
    }

    private void switchEffect(LivingEntity entity, MobEffectInstance currentEffect, MobEffect newEffect) {
        if (currentEffect != null) {
            int duration = currentEffect.getDuration();
            int level = currentEffect.getAmplifier();
            entity.removeEffect(currentEffect.getEffect());
            entity.addEffect(new MobEffectInstance((Holder<MobEffect>)newEffect, duration, level));
        }
    }

    private boolean isInFireCondition(LivingEntity entity) {
        Level world = entity.level();
        BlockPos entityPos = entity.blockPosition();
        boolean isOnFlame = false;

        int areaSize = 1;

        for (int x = -areaSize; x <= areaSize; x++) {
            for (int y = -areaSize; y <= areaSize; y++) {
                for (int z = -areaSize; z <= areaSize; z++) {
                    BlockPos pos = entityPos.offset(x, y, z);
                    BlockState blockState = world.getBlockState(pos);

                    if (blockState.is(MNDTags.LETIOS_FLAMES)) {
                        if (!blockState.hasProperty(BlockStateProperties.LIT) ||
                                (blockState.hasProperty(BlockStateProperties.LIT) && blockState.getValue(BlockStateProperties.LIT))) {
                            isOnFlame = true;
                            break;
                        }
                    }
                } if (isOnFlame) break;
            } if (isOnFlame) break;
        }

        return isOnFlame;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        int i = 25 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        } else {
            return true;
        }
    }
}
