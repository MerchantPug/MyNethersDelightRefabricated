//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mynethersdelight.common.registry;

import com.soytutta.mynethersdelight.MyNethersDelight;
import com.soytutta.mynethersdelight.common.effect.GoodPungentEffect;
import com.soytutta.mynethersdelight.common.effect.PungentEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;

import java.util.function.Supplier;

public class MNDEffects {
    public static final Holder<MobEffect> GPUNGENT = register("g_pungent", GoodPungentEffect::new);
    public static final Holder<MobEffect> BPUNGENT = register("b_pungent", PungentEffect::new);

    public static void register() {}

    private static Holder<MobEffect> register(String path, Supplier<MobEffect> effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, MyNethersDelight.res(path), effect.get());
    }
}
