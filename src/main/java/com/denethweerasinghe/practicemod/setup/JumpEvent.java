package com.denethweerasinghe.practicemod.setup;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class JumpEvent {

    // ok to name all methods here as "onEvent" because the compiler treats them uniquely based on its parameters
    @SubscribeEvent(priority= EventPriority.HIGHEST, receiveCanceled=true)
    public static void onEvent(LivingEvent.LivingJumpEvent event) {
        // DEBUG
        if (event.getEntity() instanceof PlayerEntity) {
            System.out.println("Boing");
            Minecraft.getInstance().player.sendChatMessage("lmao");
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void onEvent(FillBucketEvent event){
        event.setCanceled(true);
    }

    @SubscribeEvent
    public static void onEvent(PlayerInteractEvent.RightClickItem event){
        if (event.getItemStack().getItem() == Items.SUGAR){
            System.out.println("Item Found!");
        }
    }
}