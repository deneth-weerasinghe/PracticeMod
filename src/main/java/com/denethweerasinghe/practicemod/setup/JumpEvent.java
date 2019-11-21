package com.denethweerasinghe.practicemod.setup;

import com.denethweerasinghe.practicemod.customclass.PlayerDispatcher;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class JumpEvent {

    // ok to name all methods here as "onEvent" because the compiler treats them uniquely based on its parameters
    @SubscribeEvent
    public static void onPlayerLogIn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event){
        PlayerEntity player = event.getPlayer();
        player.getCapability(PlayerDispatcher.capability).ifPresent(customClass -> {
            int test = customClass.getCounter();
            System.out.println("Test value is: "+test);
        });
    }

//    @SubscribeEvent
//    public static void onTest(PlayerInteractEvent.RightClickItem event){
//        if (event.getItemStack().getItem() == Items.GUNPOWDER){
//            event.getEntityPlayer().getCapability(PlayerDispatcher.capability).ifPresent(customClass -> {
//                customClass.setCounter(customClass.getCounter() + 10);
//                System.out.println("Current value is: " + customClass.getCounter());
//            });
//        }
//    }
//
//    @SubscribeEvent
//    public static void onAirRightClick(PlayerInteractEvent.RightClickEmpty event){
//        event.getEntityPlayer().getCapability(PlayerDispatcher.capability).ifPresent(customClass -> {
//            System.out.println("Current value is: " + customClass.getCounter());
//        });
//    }


}