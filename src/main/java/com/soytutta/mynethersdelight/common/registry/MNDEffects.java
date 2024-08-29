//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mynethersdelight.common.registry;

import com.soytutta.mynethersdelight.common.effect.GoodPungentEffect;
import com.soytutta.mynethersdelight.common.effect.PungentEffect;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;

import java.util.function.Supplier;

public class MNDEffects {
    public static final LazyRegistrar<MobEffect> EFFECTS = LazyRegistrar.create(Registries.MOB_EFFECT, "mynethersdelight");
    public static final Supplier<MobEffect> GPUNGENT;
    public static final Supplier<MobEffect> BPUNGENT;

    public MNDEffects() {
    }

    static {
        GPUNGENT = EFFECTS.register("g_pungent", GoodPungentEffect::new);
        BPUNGENT = EFFECTS.register("b_pungent", PungentEffect::new);
    }
}
