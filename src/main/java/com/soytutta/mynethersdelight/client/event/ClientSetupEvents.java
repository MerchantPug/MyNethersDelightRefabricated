//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package com.soytutta.mynethersdelight.client.event;

import com.soytutta.mynethersdelight.client.renderer.NetherStoveRenderer;
import com.soytutta.mynethersdelight.common.registry.MNDBlockEntityTypes;
import com.soytutta.mynethersdelight.common.registry.MNDEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class ClientSetupEvents {

    public static void onRegisterRenderers() {
        EntityRendererRegistry.register(MNDEntityTypes.STRIDER_ROCK.get(), ThrownItemRenderer::new);
        BlockEntityRenderers.register(MNDBlockEntityTypes.NETHER_STOVE.get(), NetherStoveRenderer::new);
    }

    public static void init() {
        BlockEntityRenderers.register(MNDBlockEntityTypes.MND_SIGN.get(), SignRenderer::new);
        BlockEntityRenderers.register(MNDBlockEntityTypes.MND_HSIGN.get(), HangingSignRenderer::new);
        // Refabricated, moved wood type registry to mixin.
        /*
        event.enqueueWork(() -> {
            FlowerPotBlock pot = (FlowerPotBlock) Blocks.FLOWER_POT;
            pot.addPlant(BuiltInRegistries.BLOCK.getKey(MNDBlocks.POWDERY_CANNON.get()), MNDBlocks.POTTED_POWDERY_CANNON::get);
            pot.addPlant(BuiltInRegistries.BLOCK.getKey(MNDBlocks.BULLET_PEPPER.get()), MNDBlocks.POTTED_BULLET_PEPPER::get);
            Sheets.addWoodType(MNDWoodTypes.POWDERY);
        });
         */
    }
}
