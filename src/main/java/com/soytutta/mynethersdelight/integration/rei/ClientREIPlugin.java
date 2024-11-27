package com.soytutta.mynethersdelight.integration.rei;

import com.soytutta.mynethersdelight.common.registry.MNDItems;
import com.soytutta.mynethersdelight.common.utility.MNDTextUtils;
import com.soytutta.mynethersdelight.integration.rei.categories.ForgotingCategory;
import com.soytutta.mynethersdelight.integration.rei.display.ForgotingDisplay;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.plugin.common.displays.DefaultInformationDisplay;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.List;

public class ClientREIPlugin implements REIClientPlugin {

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.add(new ForgotingDisplay());

        registry.add((DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(MNDItems.BULLET_PEPPER.get(), MNDItems.POWDER_CANNON.get())), MNDTextUtils.getTranslation("jei.info.wild_powdery"))));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(MNDItems.RESURGENT_SOIL_FARMLAND.get(), MNDItems.RESURGENT_SOIL.get())), MNDTextUtils.getTranslation("jei.info.r_soil")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(ModItems.BROWN_MUSHROOM_COLONY.get(), ModItems.RED_MUSHROOM_COLONY.get())), MNDTextUtils.getTranslation("jei.info.mushroom_colony")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(Items.NETHER_WART, MNDItems.WARPED_FUNGUS_COLONY.get(), MNDItems.CRIMSON_FUNGUS_COLONY.get())), MNDTextUtils.getTranslation("jei.info.fungus_colony")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.of(MNDItems.STRIDER_ROCK.get()), MNDTextUtils.getTranslation("jei.info.strider_egg")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.of(MNDItems.HOGLIN_HIDE.get()), MNDTextUtils.getTranslation("jei.info.hoglin_hide")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(MNDItems.HOT_CREAM_CONE.get(), MNDItems.HOT_CREAM.get())), MNDTextUtils.getTranslation("jei.info.hot_cream")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(MNDItems.ROAST_STUFFED_HOGLIN.get(), MNDItems.ROAST_EAR.get(), MNDItems.PLATE_OF_STUFFED_HOGLIN_SNOUT.get(), MNDItems.PLATE_OF_STUFFED_HOGLIN_HAM.get(), MNDItems.PLATE_OF_STUFFED_HOGLIN.get())), MNDTextUtils.getTranslation("jei.info.plate_of_stuffed_hoglin")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(MNDItems.GHASTA_WITH_CREAM_BLOCK.get(), MNDItems.GHASTA_WITH_CREAM.get())), MNDTextUtils.getTranslation("jei.info.plate_of_ghasta")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(MNDItems.STRIDERLOAF_BLOCK.get(), MNDItems.STRIDERLOAF.get(), MNDItems.COLD_STRIDERLOAF.get())), MNDTextUtils.getTranslation("jei.info.plate_of_striderloaf")));
    }

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new ForgotingCategory());
    }
}
