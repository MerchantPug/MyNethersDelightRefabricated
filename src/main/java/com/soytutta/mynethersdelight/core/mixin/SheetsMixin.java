package com.soytutta.mynethersdelight.core.mixin;

import com.soytutta.mynethersdelight.common.block.utility.MNDWoodTypes;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

@Mixin(Sheets.class)
public abstract class SheetsMixin {
    @Mutable
    @Shadow @Final public static Map<WoodType, Material> SIGN_MATERIALS;

    @Mutable
    @Shadow @Final public static Map<WoodType, Material> HANGING_SIGN_MATERIALS;

    @Shadow
    public static Material createSignMaterial(WoodType woodType) {
        return null;
    }

    @Shadow
    public static Material createHangingSignMaterial(WoodType woodType) {
        return null;
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void mynethersdelightrefabricated$addPowderyWoodSheet(CallbackInfo ci) {
        Map<WoodType, Material> signMaterials = new HashMap<>(SIGN_MATERIALS);
        signMaterials.put(MNDWoodTypes.POWDERY, createSignMaterial(MNDWoodTypes.POWDERY));
        SIGN_MATERIALS = Map.copyOf(signMaterials);
        Map<WoodType, Material> hangingSignMaterials = new HashMap<>(HANGING_SIGN_MATERIALS);
        hangingSignMaterials.put(MNDWoodTypes.POWDERY, createHangingSignMaterial(MNDWoodTypes.POWDERY));
        HANGING_SIGN_MATERIALS = Map.copyOf(hangingSignMaterials);
    }
}
