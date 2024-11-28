package com.soytutta.mynethersdelight.common;

import com.soytutta.mynethersdelight.common.registry.MNDItems;
import net.minecraft.world.level.block.DispenserBlock;

public class MNDCommonSetup {

    public static void init() {
        MNDCommonSetup.registerDispenserBehaviors();
    }

    public static void registerDispenserBehaviors() {
        DispenserBlock.registerProjectileBehavior(MNDItems.STRIDER_ROCK.get());
    }
}

