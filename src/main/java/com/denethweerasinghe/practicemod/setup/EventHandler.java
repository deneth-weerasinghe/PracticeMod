package com.denethweerasinghe.practicemod.setup;

import com.denethweerasinghe.practicemod.customclass.CustomClass;
import com.denethweerasinghe.practicemod.customclass.ICustomClass;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventHandler {

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.RightClickItem event) {
            PlayerEntity player = event.getEntityPlayer();
            PracticeMod.LOGGER.info("this **is** the server");
            ICustomClass cap = CustomClass.getFromPlayer(player);
            if (event.getItemStack().getItem() == Items.GUNPOWDER) {
                cap.setCounter(cap.getCounter() + 10);
                PracticeMod.LOGGER.info("new value is: " + cap.getCounter());
            } else {
                PracticeMod.LOGGER.info("gunpowder failure");
            }
        }
//    @SubscribeEvent
//    public static void onAirRightClick(PlayerInteractEvent.RightClickEmpty event) {
//        if (!event.getWorld().isRemote) {
//            PlayerEntity player = event.getEntityPlayer();
//            ICustomClass cap = CustomClass.getFromPlayer(player);
//            ItemStack item = player.getHeldItemMainhand();
//            if (item.isEmpty()) {
//                PracticeMod.LOGGER.info("Current value is: " + cap.getCounter());
//            }
//        }else {PracticeMod.LOGGER.info("right click failure");}
//    }
//    @SubscribeEvent
//    public static void onRightClickWater(PlayerInteractEvent.RightClickBlock event){
//        if(event.getItemStack().isEmpty() && event.getHand() == Hand.MAIN_HAND){
//
//        }
//    }
}