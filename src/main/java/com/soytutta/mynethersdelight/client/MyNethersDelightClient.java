package com.soytutta.mynethersdelight.client;

import com.soytutta.mynethersdelight.client.event.ClientSetupEvents;
import com.soytutta.mynethersdelight.common.registry.MNDBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

// Refabricated: This is new.
public class MyNethersDelightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientSetupEvents.onRegisterRenderers();
        ClientSetupEvents.init();
        registerRenderLayers(BlockRenderLayerMap.INSTANCE);
    }

    public static void registerRenderLayers(BlockRenderLayerMap instance) {
        instance.putBlock(MNDBlocks.BULLET_PEPPER.get(), RenderType.cutout());
        instance.putBlock(MNDBlocks.COLD_STRIDERLOAF_BLOCK.get(), RenderType.cutout());
        instance.putBlock(MNDBlocks.CRIMSON_FUNGUS_COLONY.get(), RenderType.cutout());
        instance.putBlock(MNDBlocks.GHASTA_WITH_CREAM_BLOCK.get(), RenderType.cutout());
        instance.putBlock(MNDBlocks.HOGLIN_TROPHY.get(), RenderType.cutout());
        instance.putBlock(MNDBlocks.STRIDERLOAF_BLOCK.get(), RenderType.cutout());
        instance.putBlock(MNDBlocks.STUFFED_HOGLIN.get(), RenderType.cutout());
        instance.putBlock(MNDBlocks.POTTED_BULLET_PEPPER.get(), RenderType.cutout());
        instance.putBlock(MNDBlocks.POWDERY_CANE.get(), RenderType.cutout());
        instance.putBlock(MNDBlocks.POWDERY_CANNON.get(), RenderType.cutout());
        instance.putBlock(MNDBlocks.POWDERY_DOOR.get(), RenderType.cutout());
        instance.putBlock(MNDBlocks.POWDERY_TRAPDOOR.get(), RenderType.cutout());
        instance.putBlock(MNDBlocks.POWDERY_TORCH.get(), RenderType.cutout());
        instance.putBlock(MNDBlocks.WARPED_FUNGUS_COLONY.get(), RenderType.cutout());
        instance.putBlock(MNDBlocks.WALL_POWDERY_TORCH.get(), RenderType.cutout());
        instance.putBlock(MNDBlocks.ZOGLIN_TROPHY.get(), RenderType.cutout());
    }
}
