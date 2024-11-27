package com.soytutta.mynethersdelight.integration.emi;

import com.soytutta.mynethersdelight.MyNethersDelight;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiRenderable;
import net.minecraft.resources.ResourceLocation;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.integration.emi.FDRecipeWorkstations;

public class MNDRecipeCategories {
    private static final ResourceLocation SIMPLIFIED_TEXTURES = MyNethersDelight.res("textures/gui/emi/simplified.png");

    public static final EmiRecipeCategory FORGOTING = new EmiRecipeCategory(MyNethersDelight.res("forgoting"), MNDRecipeWorkstations.LETIOS_COMPOST, simplifiedRenderer(0, 0));

    private static EmiRenderable simplifiedRenderer(int u, int v) {
        return (draw, x, y, delta) -> {
            draw.blit(SIMPLIFIED_TEXTURES, x, y, u, v, 16, 16, 16, 16);
        };
    }
}
