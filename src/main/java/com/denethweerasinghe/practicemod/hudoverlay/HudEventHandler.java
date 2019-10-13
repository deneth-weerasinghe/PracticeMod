package com.denethweerasinghe.practicemod.hudoverlay;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class HudEventHandler {

    private CustomRenderer HUDrenderer;

    public HudEventHandler(CustomRenderer i_HUDrenderer){
        HUDrenderer = i_HUDrenderer;
    }

    @SubscribeEvent
    public void onEvent(RenderGameOverlayEvent.Pre event){
        HUDrenderer.renderBar(0,0);
    }
}
