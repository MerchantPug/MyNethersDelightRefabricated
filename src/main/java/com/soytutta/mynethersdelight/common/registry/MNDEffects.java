//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mynethersdelight.common.registry;

import com.soytutta.mynethersdelight.common.effect.GoodPungentEffect;
import com.soytutta.mynethersdelight.common.effect.PungentEffect;
import io.github.fabricators_of_create.porting_lib.util.DeferredRegister;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;

public class MNDEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, "mynethersdelight");
    public static final Holder<MobEffect> GPUNGENT = EFFECTS.register("g_pungent", GoodPungentEffect::new);
    public static final Holder<MobEffect> BPUNGENT = EFFECTS.register("b_pungent", PungentEffect::new);
}
