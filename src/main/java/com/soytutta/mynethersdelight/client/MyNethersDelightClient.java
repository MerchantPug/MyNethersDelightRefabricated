package com.soytutta.mynethersdelight.client;

import com.soytutta.mynethersdelight.client.event.ClientSetupEvents;
import net.fabricmc.api.ClientModInitializer;

// Refabricated: This is new.
public class MyNethersDelightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientSetupEvents.onEntityRendererRegister();
        ClientSetupEvents.onRegisterRenderers();
        ClientSetupEvents.init();
    }
}
