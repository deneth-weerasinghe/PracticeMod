package com.denethweerasinghe.practicemod.hudoverlay;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class HudEventHandler {
    @SubscribeEvent
    public static void setValue(PlayerEntity event){

    }
}
