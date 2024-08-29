//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package com.soytutta.mynethersdelight.client.event;

import com.soytutta.mynethersdelight.client.renderer.NetherStoveRenderer;
import com.soytutta.mynethersdelight.common.block.utility.MNDWoodTypes;
import com.soytutta.mynethersdelight.common.registry.MNDBlockEntityTypes;
import com.soytutta.mynethersdelight.common.registry.MNDBlocks;
import com.soytutta.mynethersdelight.common.registry.MNDEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;

public class ClientSetupEvents {
    public ClientSetupEvents() {
    }

    public static void onEntityRendererRegister() {
        EntityRendererRegistry.register(MNDEntityTypes.STRIDER_ROCK.get(), ThrownItemRenderer::new);
    }

    public static void onRegisterRenderers() {
        BlockEntityRenderers.register(MNDBlockEntityTypes.NETHER_STOVE.get(), NetherStoveRenderer::new);
        BlockEntityRenderers.register(MNDBlockEntityTypes.MND_SIGN.get(), SignRenderer::new);
        BlockEntityRenderers.register(MNDBlockEntityTypes.MND_HSIGN.get(), HangingSignRenderer::new);
    }

    public static void init() {
        // Handled by the game.
        /*
        FlowerPotBlock pot = (FlowerPotBlock) Blocks.FLOWER_POT;
        pot.addPlant(MNDBlocks.POWDERY_CANNON.getId(), MNDBlocks.POTTED_POWDERY_CANNON::get);
        pot.addPlant(MNDBlocks.BULLET_PEPPER.getId(), MNDBlocks.POTTED_BULLET_PEPPER::get);
         */
        Sheets.createSignMaterial(MNDWoodTypes.POWDERY);
        Sheets.createHangingSignMaterial(MNDWoodTypes.POWDERY);
    }
}
