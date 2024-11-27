//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mynethersdelight.integration.emi.recipe;


import com.google.common.collect.ImmutableList;
import com.soytutta.mynethersdelight.MyNethersDelight;
import com.soytutta.mynethersdelight.common.registry.MNDItems;
import com.soytutta.mynethersdelight.common.tag.MNDTags;
import com.soytutta.mynethersdelight.integration.emi.MNDRecipeCategories;
import com.soytutta.mynethersdelight.integration.emi.MNDRecipeWorkstations;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.SlotWidget;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.integration.emi.FDRecipeWorkstations;

import java.util.Collections;
import java.util.List;

public class ForgotingEmiRecipe implements EmiRecipe {
    private static final ResourceLocation BACKGROUND = new ResourceLocation(MyNethersDelight.MODID, "textures/gui/jei/composition.png");

    private static final EmiStack RESURGENT_SOIL = EmiStack.of(MNDItems.RESURGENT_SOIL.get());
    private static final EmiIngredient ACCELERATORS = EmiIngredient.of(MNDTags.SHOWCASE_ACTIVATORS);
    private static final EmiIngredient FLAMES = EmiIngredient.of(MNDTags.SHOWCASE_FLAMES);

    @Override
    public EmiRecipeCategory getCategory() {
        return MNDRecipeCategories.FORGOTING;
    }

    @Override
    public @Nullable ResourceLocation getId() {
        return MyNethersDelight.res("/forgoting/dummy");
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return List.of(MNDRecipeWorkstations.LETIOS_COMPOST);
    }

    @Override
    public List<EmiStack> getOutputs() {
        return List.of(RESURGENT_SOIL);
    }

    @Override
    public int getDisplayWidth() {
        return 102;
    }

    @Override
    public int getDisplayHeight() {
        return 62;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(BACKGROUND, 0, 0, 102, 41, 8, 9);

        addSlot(widgets, MNDRecipeWorkstations.LETIOS_COMPOST, 0, 16);
        addSlot(widgets, RESURGENT_SOIL, 84, 16).recipeContext(this);
        addSlot(widgets, ACCELERATORS, 54, 44);
        addSlot(widgets, FLAMES, 28, 44);

        widgets.addTooltip((mouseX, mouseY) -> {
            if (inIconAt(31, 29, mouseX, mouseY)) {
                return ImmutableList.of(createTooltip(".light"));
            } else if (inIconAt(44, 29, mouseX, mouseY)) {
                return ImmutableList.of(createTooltip(".fluid"));
            } else if (inIconAt(58, 29, mouseX, mouseY)) {
                return ImmutableList.of(createTooltip(".accelerators"));
            } else {
                return inIconOn(49, 9, mouseX, mouseY) ? ImmutableList.of(createTooltip(".nether")) : Collections.emptyList();
            }
        }, 0, 0, widgets.getWidth(), widgets.getHeight());
    }

    private SlotWidget addSlot(WidgetHolder widgets, EmiIngredient ingredient, int x, int y) {
        return widgets.addSlot(ingredient, x, y).backgroundTexture(BACKGROUND, 119, 0);
    }

    private static boolean inIconAt(int iconX, int iconY, double mouseX, double mouseY) {
        return (double)iconX <= mouseX && mouseX < (double)(iconX + 11) && (double)iconY <= mouseY && mouseY < (double)(iconY + 11);
    }

    private static boolean inIconOn(int iconX, int iconY, double mouseX, double mouseY) {
        return (double)iconX <= mouseX && mouseX < (double)(iconX + 16) && (double)iconY <= mouseY && mouseY < (double)(iconY + 19);
    }

    private static ClientTooltipComponent createTooltip(@NotNull String suffix) {
        return ClientTooltipComponent.create(Component.translatable(MyNethersDelight.MODID + ".jei.forgoting" + suffix).getVisualOrderText());
    }
}
