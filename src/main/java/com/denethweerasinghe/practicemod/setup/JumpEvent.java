package com.denethweerasinghe.practicemod.setup;

import com.denethweerasinghe.practicemod.customclass.CustomClass;
import com.denethweerasinghe.practicemod.customclass.PlayerProperties;
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

    @SubscribeEvent
    public static void onPlayerLogIn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event){
        event.getPlayer().getCapability(PlayerProperties.PLAYER_COUNTER).ifPresent(CustomClass::setCounter);
        System.out.println("Set counter to 20");
    }

    @SubscribeEvent
    public static void onTest(PlayerInteractEvent event){
        if (event.getItemStack().getItem() == Items.GUNPOWDER){
            System.out.println("detecting item gunpowder");
            event.getEntityPlayer().getCapability(PlayerProperties.PLAYER_COUNTER).ifPresent(customClass -> {
                int test = customClass.getCounter();
                System.out.println("Test value is: "+test);
            });
        }
    }
}