package com.soytutta.mynethersdelight.common.block.utility;

import com.soytutta.mynethersdelight.MyNethersDelight;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class MNDWoodTypes {
    public static final WoodType POWDERY =
            new WoodTypeBuilder()
                    .soundGroup(SoundType.BAMBOO_WOOD)
                    .hangingSignSoundGroup(SoundType.BAMBOO_WOOD_HANGING_SIGN)
                    .fenceGateCloseSound(SoundEvents.BAMBOO_WOOD_FENCE_GATE_CLOSE)
                    .fenceGateOpenSound(SoundEvents.BAMBOO_WOOD_FENCE_GATE_OPEN)
                    .register(ResourceLocation.parse(MyNethersDelight.MODID + ":powdery"), BlockSetType.BAMBOO);
}
