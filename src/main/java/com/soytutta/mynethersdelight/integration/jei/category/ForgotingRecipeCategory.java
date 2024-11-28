//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mynethersdelight.integration.jei.category;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.soytutta.mynethersdelight.common.utility.MNDTextUtils;
import com.soytutta.mynethersdelight.common.registry.MNDBlocks;
import com.soytutta.mynethersdelight.common.registry.MNDItems;
import com.soytutta.mynethersdelight.common.tag.MNDTags;
import com.soytutta.mynethersdelight.integration.jei.MNDRecipeTypes;
import com.soytutta.mynethersdelight.integration.jei.resource.ForgotingDummy;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.FarmersDelight;

// thanks Umpaz for letting me use this code <3
public class ForgotingRecipeCategory implements IRecipeCategory<ForgotingDummy> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(FarmersDelight.MODID, "composition");
    private static final int slotSize = 22;
    private final Component title = MNDTextUtils.getTranslation("jei.forgoting");

    private final IDrawable background;
    private final IDrawable slotIcon;
    private final IDrawable icon;
    private final ItemStack letiosCompost;
    private final ItemStack resurgentSoil;

    public ForgotingRecipeCategory(IGuiHelper helper) {
        ResourceLocation backgroundImage = ResourceLocation.fromNamespaceAndPath("mynethersdelight", "textures/gui/jei/composition.png");
        this.background = helper.createDrawable(backgroundImage, 0, 0, 118, 80);
        this.letiosCompost = new ItemStack(MNDBlocks.LETIOS_COMPOST.get());
        this.resurgentSoil = new ItemStack(MNDItems.RESURGENT_SOIL.get());
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, this.resurgentSoil);
        this.slotIcon = helper.createDrawable(backgroundImage, 119, 0, 22, 22);
    }

    public RecipeType<ForgotingDummy> getRecipeType() {
        return MNDRecipeTypes.FORGOTING;
    }

    public Component getTitle() {
        return this.title;
    }

    public IDrawable getBackground() {
        return this.background;
    }

    public IDrawable getIcon() {
        return this.icon;
    }

    public void setRecipe(IRecipeLayoutBuilder builder, ForgotingDummy recipe, IFocusGroup focusGroup) {
        List<ItemStack> accelerators = new ArrayList<>();
        List<ItemStack> flames = new ArrayList<>();
        BuiltInRegistries.BLOCK.getTag(MNDTags.SHOWCASE_ACTIVATORS).ifPresent(s -> s.forEach(f -> accelerators.add(new ItemStack(f.value()))));
        BuiltInRegistries.BLOCK.getTag(MNDTags.SHOWCASE_FLAMES).ifPresent(s -> s.forEach(f -> flames.add(new ItemStack(f.value()))));
        builder.addSlot(RecipeIngredientRole.INPUT, 9, 26).addItemStack(this.letiosCompost);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 93, 26).addItemStack(this.resurgentSoil);
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 64, 54).addItemStacks(accelerators);
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 38, 54).addItemStacks(flames);
    }

    public void draw(ForgotingDummy recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.slotIcon.draw(guiGraphics, 63, 53);
        this.slotIcon.draw(guiGraphics, 37, 53);
    }

    public List<Component> getTooltipStrings(ForgotingDummy recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY) {
        if (inIconAt(40, 38, mouseX, mouseY)) {
            return ImmutableList.of(translateKey(".light"));
        } else if (inIconAt(53, 38, mouseX, mouseY)) {
            return ImmutableList.of(translateKey(".fluid"));
        } else if (inIconAt(67, 38, mouseX, mouseY)) {
            return ImmutableList.of(translateKey(".accelerators"));
        } else {
            return inIconOn(49, 9, mouseX, mouseY) ? ImmutableList.of(translateKey(".nether")) : Collections.emptyList();
        }
    }

    private static boolean inIconAt(int iconX, int iconY, double mouseX, double mouseY) {
        boolean icon_size = true;
        return (double)iconX <= mouseX && mouseX < (double)(iconX + 11) && (double)iconY <= mouseY && mouseY < (double)(iconY + 11);
    }

    private static boolean inIconOn(int iconX, int iconY, double mouseX, double mouseY) {
        return (double)iconX <= mouseX && mouseX < (double)(iconX + 16) && (double)iconY <= mouseY && mouseY < (double)(iconY + 19);
    }

    private static MutableComponent translateKey(@NotNull String suffix) {
        return Component.translatable("mynethersdelight.jei.forgoting" + suffix);
    }
}
