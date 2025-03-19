//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mynethersdelight.common.registry;

import com.soytutta.mynethersdelight.MyNethersDelight;
import com.soytutta.mynethersdelight.common.block.*;
import com.soytutta.mynethersdelight.common.block.PowderyCannonSaplingBlock;
import com.soytutta.mynethersdelight.common.block.MNDStandingSignBlock;
import com.soytutta.mynethersdelight.common.block.MNDWallSignBlock;
import com.soytutta.mynethersdelight.common.block.utility.MNDWoodTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import vectorwing.farmersdelight.common.block.*;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class MNDBlocks {
    public static final Supplier<Block> NETHER_BRICKS_CABINET = register("nether_bricks_cabinet", () ->
                new CabinetBlock(Properties.ofFullCopy(Blocks.NETHER_BRICKS))
        );
    public static final Supplier<Block> RED_NETHER_BRICKS_CABINET = register("red_nether_bricks_cabinet", () ->
            new CabinetBlock(Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS))
    );
    public static final Supplier<Block> BLACKSTONE_BRICKS_CABINET = register("blackstone_bricks_cabinet", () ->
            new CabinetBlock(Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS))
    );
    public static final Supplier<Block> NETHER_STOVE = register("nether_stove", () ->
            new NetherStoveBlock(Properties.ofFullCopy(Blocks.NETHER_BRICKS)
                    .lightLevel(litBlockEmission(13)))
    );
    public static final Supplier<Block> BULLET_PEPPER_CRATE = register("bullet_pepper_crate", () ->
            new PepperCrateBlock(Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .mapColor(MapColor.FIRE).strength(2.0F, 3.0F)
                    .sound(SoundType.BAMBOO_WOOD).lightLevel((light) -> 15))
    );
    public static final Supplier<Block> LETIOS_COMPOST = register("letios_compost", () ->
            new LetiosCompostBlock(Properties.ofFullCopy(Blocks.SOUL_SOIL)
                    .mapColor(MapColor.COLOR_BROWN).strength(1.2F).speedFactor(0.4F))
    );
    // Re-order Resurgent Soil and Resurgent Soil Farmland.
    public static final Supplier<Block> RESURGENT_SOIL_FARMLAND = register("resurgent_soil_farmland", () ->
            new ResurgentSoilFarmlandBlock(Properties.ofFullCopy(Blocks.FARMLAND)
                    .sound(SoundType.SOUL_SAND)
                    .mapColor(MapColor.COLOR_BROWN).speedFactor(0.4F)
                    .lightLevel(FlameBlockEmission(10)))
    );
    public static final Supplier<Block> RESURGENT_SOIL = register("resurgent_soil", () ->
            new ResurgentSoilBlock(Properties.ofFullCopy(Blocks.SOUL_SOIL)
                    .sound(SoundType.SOUL_SAND)
                    .mapColor(MapColor.COLOR_BROWN).speedFactor(0.4F).randomTicks())
    );
    public static final Supplier<Block> WARPED_FUNGUS_COLONY = register("warped_fungus_colony", () ->
            new MushroomColonyBlock(Items.WARPED_FUNGUS.builtInRegistryHolder(),
                    Properties.ofFullCopy(Blocks.BROWN_MUSHROOM).sound(SoundType.FUNGUS))
    );
    public static final Supplier<Block> CRIMSON_FUNGUS_COLONY = register("crimson_fungus_colony", () ->
            new MushroomColonyBlock(Items.CRIMSON_FUNGUS.builtInRegistryHolder(),
                    Properties.ofFullCopy(Blocks.RED_MUSHROOM).sound(SoundType.FUNGUS))
    );
    public static final Supplier<Block> POWDERY_CHUBBY_SAPLING = register("powdery_chubby_sapling", () ->
            new PowderyCannonSaplingBlock(Properties.ofFullCopy(Blocks.BAMBOO_SAPLING)
                    .mapColor(MapColor.TERRACOTTA_BLACK).strength(2.0F, 3.0F))
    );
    public static final Supplier<Block> POWDERY_CANNON = register("powdery_cannon", () ->
            new PowderyCannonBlock(Properties.ofFullCopy(Blocks.BAMBOO)
                    .mapColor(MapColor.TERRACOTTA_BLACK).strength(3.0F, 3.0F)
                    .lightLevel(litBlockEmission(12)))
    );
    public static final Supplier<Block> POWDERY_CANE = register("powdery_cane", () ->
            new PowderyCaneBlock(Properties.ofFullCopy(Blocks.BAMBOO)
                    .mapColor(MapColor.TERRACOTTA_BLACK).noCollission()
                    .instabreak().lightLevel(litBlockEmission(12)))
    );
    public static final Supplier<Block> BULLET_PEPPER = register("bullet_pepper", () ->
            new PowderyFlowerBlock(Properties.ofFullCopy(Blocks.BAMBOO_SAPLING)
                    .mapColor(MapColor.TERRACOTTA_BLACK).noCollission()
                    .instabreak().lightLevel(litBlockEmission(8)))
    );
    public static final Supplier<Block> POWDERY_TORCH = register("powdery_torch", () ->
            new TorchBlock(ParticleTypes.FLAME, Properties.of()
                    .noCollission().instabreak().lightLevel((light) -> 8)
                    .sound(SoundType.BAMBOO))
    );
    public static final Supplier<Block> WALL_POWDERY_TORCH = register("wall_powdery_torch", () ->
            new WallTorchBlock(ParticleTypes.FLAME, Properties.of().dropsLike(POWDERY_TORCH.get())
                    .noCollission().instabreak().lightLevel((light) -> 8)
                    .sound(SoundType.BAMBOO)));
    // POWDERY_POTS
    public static final Supplier<Block> POTTED_POWDERY_CANNON = register("potted_powdery_cannon", () ->
            new FlowerPotBlock(POWDERY_CANNON.get(), Properties.of()
                    .instabreak().noOcclusion())
    );
    public static final Supplier<Block> POTTED_BULLET_PEPPER = register("potted_bullet_pepper", () ->
            new FlowerPotBlock(BULLET_PEPPER.get(), Properties.of()
                    .instabreak().noOcclusion().lightLevel((light) ->  8))
    );
    // POWDERY_BLOCKS
    public static final Supplier<Block> POWDERY_CABINET = register("powdery_cabinet", () ->
            new CabinetBlock(Properties.ofFullCopy(Blocks.BARREL)
                .sound(SoundType.BAMBOO_WOOD).mapColor(MapColor.TERRACOTTA_GRAY))
    );
    // Refabricated: Re-ordered Block of Stripped Powdery Cannon and Block of Powdery Cannon
    public static final Supplier<Block> BLOCK_OF_STRIPPED_POWDERY_CANNON = register("stripped_powdery_block", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STEM).sound(SoundType.BAMBOO_WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .mapColor(MapColor.TERRACOTTA_GRAY))
    );
    public static final Supplier<Block> BLOCK_OF_POWDERY_CANNON = register("powdery_block", () ->
            new StrippableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STEM).sound(SoundType.BAMBOO_WOOD)
                    .instrument(NoteBlockInstrument.BASS).explosionResistance(300.0F)
                    .mapColor(MapColor.TERRACOTTA_BLACK))
    );
    public static final Supplier<Block> POWDERY_PLANKS = register("powdery_planks", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
                    .sound(SoundType.BAMBOO_WOOD)
                    .mapColor(MapColor.TERRACOTTA_GRAY))
    );
    public static final Supplier<Block> POWDERY_PLANKS_STAIRS = register("powdery_stairs", () ->
            new StairBlock(POWDERY_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STAIRS)
                    .sound(SoundType.BAMBOO_WOOD)
                    .mapColor(MapColor.TERRACOTTA_GRAY))
    );
    public static final Supplier<Block> POWDERY_PLANKS_SLAB = register("powdery_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SLAB)
                    .sound(SoundType.BAMBOO_WOOD)
                    .mapColor(MapColor.TERRACOTTA_GRAY))
    );
    public static final Supplier<Block> POWDERY_MOSAIC = register("powdery_mosaic", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
                    .sound(SoundType.BAMBOO_WOOD)
                    .mapColor(MapColor.TERRACOTTA_GRAY))
    );
    public static final Supplier<Block> POWDERY_MOSAIC_STAIRS = register("powdery_mosaic_stairs", () ->
            new StairBlock(POWDERY_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STAIRS)
                    .sound(SoundType.BAMBOO_WOOD)
                    .mapColor(MapColor.TERRACOTTA_GRAY))
    );
    public static final Supplier<Block> POWDERY_MOSAIC_SLAB = register("powdery_mosaic_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SLAB)
                    .sound(SoundType.BAMBOO_WOOD)
                    .mapColor(MapColor.TERRACOTTA_GRAY))
    );
    public static final Supplier<Block> POWDERY_FENCE = register("powdery_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE)
                    .sound(SoundType.BAMBOO_WOOD)
                    .mapColor(MapColor.TERRACOTTA_GRAY))
    );
    public static final Supplier<Block> POWDERY_FENCE_GATE = register("powdery_fence_gate", () ->
            new FenceGateBlock(WoodType.BAMBOO, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE_GATE)
                    .mapColor(MapColor.TERRACOTTA_GRAY))
    );
    public static final Supplier<Block> POWDERY_DOOR = register("powdery_door", () ->
            new DoorBlock(BlockSetType.BAMBOO, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_DOOR)
                    .mapColor(MapColor.TERRACOTTA_GRAY))
    );
    public static final Supplier<Block> POWDERY_TRAPDOOR = register("powdery_trapdoor", () ->
            new TrapDoorBlock(BlockSetType.BAMBOO, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_TRAPDOOR)
                    .mapColor(MapColor.TERRACOTTA_GRAY))
    );
    public static final Supplier<Block> POWDERY_BUTTON = register("powdery_button", () ->
            new ButtonBlock(BlockSetType.BAMBOO, 30,BlockBehaviour.Properties.ofFullCopy(POWDERY_PLANKS.get())
                    .noCollission().strength(0.5F).mapColor(MapColor.TERRACOTTA_GRAY))
    );
    public static final Supplier<Block> POWDERY_PRESSURE_PLATE = register("powdery_pressure_plate", () ->
            new PressurePlateBlock(BlockSetType.BAMBOO, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PRESSURE_PLATE)
                    .mapColor(MapColor.TERRACOTTA_GRAY))
    );
    public static final Supplier<Block> POWDERY_SIGN = register("powdery_sign", () ->
            new MNDStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SIGN),
                    MNDWoodTypes.POWDERY)
    );
    public static final Supplier<Block> POWDERY_WALL_SIGN = register("powdery_wall_sign", () ->
            new MNDWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_WALL_SIGN),
                    MNDWoodTypes.POWDERY)
    );
    public static final Supplier<Block> POWDERY_HANGING_SIGN = register("powdery_hanging_sign", () ->
            new MNDHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_HANGING_SIGN),
                    MNDWoodTypes.POWDERY)
    );
    public static final Supplier<Block> POWDERY_WALL_HANGING_SIGN = register("powdery_wall_hanging_sign", () ->
            new MNDWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_WALL_HANGING_SIGN),
                    MNDWoodTypes.POWDERY)
    );
    public static final Supplier<Block> STRIDERLOAF_BLOCK = register("striderloaf_block", () ->
            new StriderloafBlock(Properties.ofFullCopy(Blocks.CAKE), () -> MNDItems.STRIDERLOAF.get(), true)
    );
    public static final Supplier<Block> COLD_STRIDERLOAF_BLOCK = register("cold_striderloaf_block", () ->
            new StriderloafBlock(Properties.ofFullCopy(Blocks.CAKE), () -> MNDItems.COLD_STRIDERLOAF.get(), true)
    );
    public static final Supplier<Block> GHASTA_WITH_CREAM_BLOCK = register("ghasta_with_cream_block", () ->
            new GhastaWithCreamBlock(Properties.ofFullCopy(Blocks.CAKE).lightLevel((light) ->  3)
                    , () -> MNDItems.GHASTA_WITH_CREAM.get(), true)
    );
    public static final Supplier<Block> MAGMA_CAKE_BLOCK = register("magma_cake_block", () ->
            new MagmaCakeBlock (Block.Properties.ofFullCopy(Blocks.CAKE).lightLevel((light) ->  3)
                    , () -> MNDItems.MAGMA_CAKE_SLICE.get())
    );
    public static final Supplier<Block> STUFFED_HOGLIN = register("stuffed_hoglin", () ->
            new StuffedHoglinBlock(Properties.ofFullCopy(Blocks.CAKE)
                    .mapColor(MapColor.TERRACOTTA_PINK)
                    .pushReaction(PushReaction.DESTROY))
    );
    public static final Supplier<Block> HOGLIN_TROPHY = register("hoglin_trophy", () ->
            new TrophyBlock(Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
                    .mapColor(MapColor.TERRACOTTA_PINK))
    );
    public static final Supplier<Block> WAXED_HOGLIN_TROPHY = register("waxed_hoglin_trophy", () ->
            new TrophyBlock(Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
                    .mapColor(MapColor.TERRACOTTA_PINK))
    );
    public static final Supplier<Block> ZOGLIN_TROPHY = register("zoglin_trophy", () ->
            new TrophyBlock(Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
                    .mapColor(MapColor.TERRACOTTA_GREEN))
    );
    public static final Supplier<Block> SKOGLIN_TROPHY = register("skoglin_trophy", () ->
            new TrophyBlock(Properties.ofFullCopy(Blocks.BONE_BLOCK)
                    .mapColor(MapColor.TERRACOTTA_WHITE))
    );

    private static ToIntFunction<BlockState> FlameBlockEmission(int lightValue) {
        return (state) -> state.getValue(BlockStateProperties.MOISTURE) == 7 ? lightValue : 0;
    }
    private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

    public static void register() {}

    private static <T extends Block> Supplier<T> register(String path, Supplier<T> supp) {
        T value = supp.get();
        Registry.register(BuiltInRegistries.BLOCK, MyNethersDelight.res(path), value);
        return () -> value;
    }
}
