package com.denethweerasinghe.practicemod.handlers;

import com.denethweerasinghe.practicemod.customclass.CustomClass;
import com.denethweerasinghe.practicemod.customclass.ICustomClass;
import com.denethweerasinghe.practicemod.setup.PracticeMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.world.IWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;


public class EventHandler {

    public static void init(){
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    @SubscribeEvent
    public void onRightClick(PlayerInteractEvent.RightClickItem event) {
        PlayerEntity player = event.getEntityPlayer();
        if (player instanceof ServerPlayerEntity) {
            PracticeMod.LOGGER.info("this **is** the server");
            ICustomClass cap = CustomClass.getFromPlayer(player);
            if (event.getItemStack().getItem() == Items.GUNPOWDER) {
                cap.setCounter(cap.getCounter() + 10);
                PracticeMod.LOGGER.info("new value is: " + cap.getCounter());
            }
        }
    }

    @SubscribeEvent
    public void onPlayerLogIn(PlayerEvent.PlayerLoggedInEvent event){

        PlayerEntity player = event.getPlayer();
        if (player instanceof ServerPlayerEntity) {
            PracticeMod.LOGGER.info("LOGGING IN");
            CustomClass.updateClient((ServerPlayerEntity) player, CustomClass.getFromPlayer(player));
        }
    }

//    @SubscribeEvent
//    public void onAirRightClick(PlayerInteractEvent.RightClickEmpty event) {
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
//    public void onRightClickWater(PlayerInteractEvent.RightClickBlock event){
//        if(event.getItemStack().isEmpty() && event.getHand() == Hand.MAIN_HAND){
//
//        }
//    }
}