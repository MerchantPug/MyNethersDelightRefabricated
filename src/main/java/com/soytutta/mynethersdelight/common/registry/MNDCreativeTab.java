package com.soytutta.mynethersdelight.common.registry;

import com.soytutta.mynethersdelight.MyNethersDelight;
import com.soytutta.mynethersdelight.common.utility.MNDTextUtils;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.registries.*;
import net.minecraft.world.item.*;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class MNDCreativeTab {
    public static final LazyRegistrar<CreativeModeTab> TABS = LazyRegistrar.create(Registries.CREATIVE_MODE_TAB, MyNethersDelight.MODID);

    public static final Supplier<CreativeModeTab> MY_NETHERS_DELIGHT_TAB = TABS.register("main",
            () -> FabricItemGroup.builder()
                    .title(MNDTextUtils.getTranslation("itemGroup.main"))
                    .icon(MNDItems.NETHER_STOVE.get()::getDefaultInstance)
                    .displayItems((itemDisplayParameters, output) -> MNDMainTabContents(output::accept))
                    .build()
    );
    private static void MNDMainTabContents(Consumer<Item> event) {
        // if (event.getTab() != MY_NETHERS_DELIGHT_TAB.get()) return;

        event.accept(MNDItems.NETHER_BRICKS_CABINET.get());
        event.accept(MNDItems.NETHER_STOVE.get());
        event.accept(MNDItems.BULLET_PEPPER_CRATE.get());
        event.accept(MNDItems.LETIOS_COMPOST.get());
        event.accept(MNDItems.RESURGENT_SOIL.get());
        event.accept(MNDItems.RESURGENT_SOIL_FARMLAND.get());

        event.accept(MNDItems.POWDER_CANNON.get());
        event.accept(MNDItems.POWDERY_TORCH.get());
        event.accept(MNDItems.BLOCK_OF_POWDERY_CANNON.get());
        event.accept(MNDItems.BLOCK_OF_STRIPPED_POWDERY_CANNON.get());
        event.accept(MNDItems.POWDERY_CABINET.get());
        event.accept(MNDItems.POWDERY_PLANKS.get());
        event.accept(MNDItems.POWDERY_PLANKS_STAIRS.get());
        event.accept(MNDItems.POWDERY_PLANKS_SLAB.get());
        event.accept(MNDItems.POWDERY_MOSAIC.get());
        event.accept(MNDItems.POWDERY_MOSAIC_STAIRS.get());
        event.accept(MNDItems.POWDERY_MOSAIC_SLAB.get());

        event.accept(MNDItems.POWDERY_FENCE.get());
        event.accept(MNDItems.POWDERY_FENCE_GATE.get());

        event.accept(MNDItems.POWDERY_DOOR.get());
        event.accept(MNDItems.POWDERY_TRAPDOOR.get());
        event.accept(MNDItems.POWDERY_PRESSURE_PLATE.get());
        event.accept(MNDItems.POWDERY_BUTTON.get());
        event.accept(MNDItems.POWDERY_SIGN.get());
        event.accept(MNDItems.POWDERY_HANGING_SIGN.get());

        event.accept(MNDItems.CRIMSON_FUNGUS_COLONY.get());
        event.accept(MNDItems.WARPED_FUNGUS_COLONY.get());

        event.accept(MNDItems.HOGLIN_TROPHY.get());
        event.accept(MNDItems.WAXED_HOGLIN_TROPHY.get());
        event.accept(MNDItems.ZOGLIN_TROPHY.get());
        event.accept(MNDItems.SKOGLIN_TROPHY.get());

        event.accept(MNDItems.HOGLIN_HIDE.get());

        event.accept(MNDItems.HOGLIN_LOIN.get());
        event.accept(MNDItems.HOGLIN_SAUSAGE.get());
        event.accept(MNDItems.ROASTED_SAUSAGE.get());
        event.accept(MNDItems.HOTDOG.get());
        event.accept(MNDItems.SAUSAGE_AND_POTATOES.get());
        event.accept(MNDItems.BREAKFAST_SAMPLER.get());
        event.accept(MNDItems.COOKED_LOIN.get());
        event.accept(MNDItems.BLUE_TENDERLOIN_STEAK.get());
        event.accept(MNDItems.FRIED_HOGLIN_CHOP.get());

        event.accept(MNDItems.RAW_STUFFED_HOGLIN.get());
        event.accept(MNDItems.ROAST_STUFFED_HOGLIN.get());
        event.accept(MNDItems.ROAST_EAR.get());
        event.accept(MNDItems.PLATE_OF_STUFFED_HOGLIN_SNOUT.get());
        event.accept(MNDItems.PLATE_OF_STUFFED_HOGLIN_HAM.get());
        event.accept(MNDItems.PLATE_OF_STUFFED_HOGLIN.get());

        event.accept(MNDItems.STRIDER_ROCK.get());
        event.accept(MNDItems.STRIDER_EGG.get());
        event.accept(MNDItems.BOILED_EGG.get());
        event.accept(MNDItems.DEVILED_EGG.get());
        event.accept(MNDItems.STRIDER_SLICE.get());
        event.accept(MNDItems.MINCED_STRIDER.get());
        event.accept(MNDItems.BLEEDING_TARTAR.get());
        event.accept(MNDItems.STRIDER_WITH_GRILLED_FUNGUS.get());
        event.accept(MNDItems.STRIDER_STEW.get());
        event.accept(MNDItems.CRIMSON_STROGANOFF.get());
        event.accept(MNDItems.STRIDERLOAF_BLOCK.get());
        event.accept(MNDItems.STRIDERLOAF.get());
        event.accept(MNDItems.COLD_STRIDERLOAF.get());

        event.accept(MNDItems.GHASTA.get());
        event.accept(MNDItems.GHASMATI.get());
        event.accept(MNDItems.GHAST_DOUGH.get());
        event.accept(MNDItems.GHAST_SALAD.get());
        event.accept(MNDItems.SPICY_NOODLE_SOUP.get());
        event.accept(MNDItems.SPICY_COTTON.get());
        event.accept(MNDItems.GHASTA_WITH_CREAM_BLOCK.get());
        event.accept(MNDItems.GHASTA_WITH_CREAM.get());

        event.accept(MNDItems.BULLET_PEPPER.get());
        event.accept(MNDItems.SPICY_SKEWER.get());
        event.accept(MNDItems.CHILIDOG.get());
        event.accept(MNDItems.SPICY_HOGLIN_STEW.get());
        event.accept(MNDItems.HOT_WINGS.get());
        event.accept(MNDItems.HOT_WINGS_BUCKET.get());
        event.accept(MNDItems.SPICY_CURRY.get());

        event.accept(MNDItems.ROCK_SOUP.get());
        event.accept(MNDItems.BURNT_ROLL.get());
        event.accept(MNDItems.MAGMA_CAKE.get());
        event.accept(MNDItems.MAGMA_CAKE_SLICE.get());

        event.accept(MNDItems.HOT_CREAM.get());
        event.accept(MNDItems.HOT_CREAM_CONE.get());

        // TODO: Reimplement if MD gets a port.
        /*
        if (FabricLoader.getInstance().isModLoaded("miners_delight")) {
            event.accept(MNDItemsMD.SPICY_HOGLIN_STEW_CUP.get());
            event.accept(MNDItemsMD.STRIDER_STEW_CUP.get());
            event.accept(MNDItemsMD.SPICY_NOODLE_SOUP_CUP.get());
            event.accept(MNDItemsMD.ROCK_SOUP_CUP.get());
        }
         */
    }

    public static void buildContents(Consumer<Item> consumer) {
        MNDMainTabContents(consumer);
    }
}