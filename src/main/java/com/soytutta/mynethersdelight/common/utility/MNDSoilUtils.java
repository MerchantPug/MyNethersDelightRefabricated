package com.soytutta.mynethersdelight.common.utility;

import com.soytutta.mynethersdelight.common.tag.MNDTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.PitcherCropBlock;

public class MNDSoilUtils {
    public static boolean isAbleToPlaceResurgentSoil(Block block) {
        if (block.builtInRegistryHolder().is(MNDTags.DOES_NOT_SURVIVE_RESURGENT_SOIL))
            return false;

        if (block.builtInRegistryHolder().is(MNDTags.SURVIVES_RESURGENT_SOIL))
            return true;

        return !(block instanceof CropBlock || block instanceof PitcherCropBlock);
    }

    public static boolean isAbleToPlaceResurgentSoilFarmland(Block block) {
        if (block.builtInRegistryHolder().is(MNDTags.DOES_NOT_SURVIVE_RESURGENT_SOIL_FARMLAND))
            return false;

        if (block.builtInRegistryHolder().is(MNDTags.DOES_NOT_SURVIVE_RESURGENT_SOIL_FARMLAND))
            return true;

        return !(block == Blocks.DEAD_BUSH || block == Blocks.LILY_PAD || block == Blocks.RED_MUSHROOM || block == Blocks.BROWN_MUSHROOM);
    }
}
