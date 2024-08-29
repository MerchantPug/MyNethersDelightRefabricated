package com.soytutta.mynethersdelight.integration.addonsdelight;

// TODO: Reintroduce if Miner's Delight gets a Fabric port.
/*
import com.sammy.minersdelight.setup.MDItems;
import com.soytutta.mynethersdelight.common.utility.MNDFoodValues;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class MNDItemsMD {
    public static final LazyRegistrar<Item> ITEMS = LazyRegistrar.create(Registries.ITEM, "miners_delight");

    public static final RegistryObject<Item> STRIDER_STEW_CUP;
    public static final RegistryObject<Item> SPICY_NOODLE_SOUP_CUP;
    public static final RegistryObject<Item> SPICY_HOGLIN_STEW_CUP;
    public static final RegistryObject<Item> ROCK_SOUP_CUP;

    public MNDItemsMD() {
    }

    public static Item.Properties CupFoodItem(FoodProperties food) {
        return (new Item.Properties()).food(food).craftRemainder(MDItems.COPPER_CUP.get()).stacksTo(16);
    }

    static {
        STRIDER_STEW_CUP = ITEMS.register("strider_stew_cup", ()  ->
                new ConsumableItem(CupFoodItem(MNDFoodValues.STRIDER_STEW_CUP), true)
        );
        SPICY_NOODLE_SOUP_CUP = ITEMS.register("spicy_noodle_soup_cup", ()  ->
                new ConsumableItem(CupFoodItem(MNDFoodValues.SPICY_NOODLE_SOUP_CUP), true)
        );
        SPICY_HOGLIN_STEW_CUP = ITEMS.register("spicy_hoglin_stew_cup", ()  ->
                new ConsumableItem(CupFoodItem(MNDFoodValues.SPICY_HOGLIN_STEW_CUP), true)
        );
        ROCK_SOUP_CUP = ITEMS.register("rock_soup_cup", ()  ->
                new ConsumableItem(CupFoodItem(MNDFoodValues.ROCK_SOUP_CUP), true)
        );
    }
}
 */