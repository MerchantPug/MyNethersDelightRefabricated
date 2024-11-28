package com.soytutta.mynethersdelight.integration.rei.categories;

import com.soytutta.mynethersdelight.common.registry.MNDBlocks;
import com.soytutta.mynethersdelight.common.registry.MNDItems;
import com.soytutta.mynethersdelight.common.tag.MNDTags;
import com.soytutta.mynethersdelight.integration.rei.MNDREICategoryIdentifiers;
import com.soytutta.mynethersdelight.integration.rei.display.ForgotingDisplay;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ForgotingCategory implements DisplayCategory<ForgotingDisplay> {
    private static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath("mynethersdelight", "textures/gui/jei/composition.png");

    @Override
    public CategoryIdentifier<? extends ForgotingDisplay> getCategoryIdentifier() {
        return MNDREICategoryIdentifiers.FORGOTING;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("farmersdelight.jei.decomposition");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(MNDBlocks.LETIOS_COMPOST.get());
    }

    @Override
    public int getDisplayHeight() {
        return 102;
    }

    @Override
    public int getDisplayWidth(ForgotingDisplay display) {
        return 150;
    }

    @Override
    public List<Widget> setupDisplay(ForgotingDisplay display, Rectangle bounds) {
        List<Widget> widgets = new ArrayList<>();

        Point startPoint = new Point(bounds.getCenterX() - 59, bounds.getCenterY() - 40);

        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createTexturedWidget(BACKGROUND, startPoint.x, startPoint.y, 0, 0, 118, 80));

        widgets.add(Widgets.createSlot(new Point( startPoint.x + 9, startPoint.y + 26)).entry(EntryStacks.of(MNDBlocks.LETIOS_COMPOST.get())));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 93, startPoint.y + 26)).entry(EntryStacks.of(MNDItems.RESURGENT_SOIL.get())));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 64, startPoint.y + 54)).entries(EntryIngredients.ofItemTag(MNDTags.SHOWCASE_ACTIVATORS)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 38, startPoint.y + 54)).entries(EntryIngredients.ofItemTag(MNDTags.SHOWCASE_FLAMES)));

        widgets.add(Widgets.createTooltip(new Rectangle( startPoint.x + 40, startPoint.y + 38, 11, 11), translateKey(".light")));
        widgets.add(Widgets.createTooltip(new Rectangle(startPoint.x + 53, startPoint.y + 38, 11, 11), translateKey(".fluid")));
        widgets.add(Widgets.createTooltip(new Rectangle(startPoint.x + 67, startPoint.y + 38, 11, 11), translateKey(".accelerators")));
        widgets.add(Widgets.createTooltip(new Rectangle(startPoint.x + 49, startPoint.y + 9, 16, 19), translateKey(".nether")));

        return widgets;
    }

    private static MutableComponent translateKey(@NotNull String suffix) {
        return Component.translatable("mynethersdelight.jei.forgoting" + suffix);
    }

    @Override
    public int getFixedDisplaysPerPage() {
        return 1;
    }

}
