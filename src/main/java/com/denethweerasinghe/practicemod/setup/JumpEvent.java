package com.denethweerasinghe.practicemod.setup;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber
public class JumpEvent {

    // ok to name all methods here as "onEvent" because the compiler treats them uniquely based on its parameters

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

    @SubscribeEvent
    public static  void onEvent(PlayerEvent event){
        PlayerEntity player = event.getPlayer();

    }
}