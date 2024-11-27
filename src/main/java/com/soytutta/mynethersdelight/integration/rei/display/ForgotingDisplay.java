package com.soytutta.mynethersdelight.integration.rei.display;

import com.soytutta.mynethersdelight.common.registry.MNDItems;
import com.soytutta.mynethersdelight.integration.rei.MNDREICategoryIdentifiers;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;

import java.util.List;

public class ForgotingDisplay implements Display {

    @Override
    public List<EntryIngredient> getInputEntries() {
        return List.of(EntryIngredients.of(MNDItems.LETIOS_COMPOST.get()));
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return List.of(EntryIngredients.of(MNDItems.RESURGENT_SOIL.get()));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return MNDREICategoryIdentifiers.FORGOTING;
    }

}
