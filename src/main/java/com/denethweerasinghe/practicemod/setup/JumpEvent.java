package com.denethweerasinghe.practicemod.setup;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class JumpEvent {

    @SubscribeEvent(priority= EventPriority.HIGHEST, receiveCanceled=true)
    public static void onEvent(LivingEvent.LivingJumpEvent event) {
        // DEBUG
        if (event.getEntity() instanceof PlayerEntity) {
            System.out.println("Boing");
        }
    }
}
