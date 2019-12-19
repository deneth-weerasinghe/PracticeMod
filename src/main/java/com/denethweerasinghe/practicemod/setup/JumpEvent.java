package com.denethweerasinghe.practicemod.setup;

import com.denethweerasinghe.practicemod.customclass.CustomClass;
import com.denethweerasinghe.practicemod.customclass.ICustomClass;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;

//@Mod.EventBusSubscriber
public class JumpEvent {

    // ok to name all methods here as "onEvent" because the compiler treats them uniquely based on its parameters
    @SubscribeEvent
    public static void onPlayerLogIn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event){
        PlayerEntity player = event.getPlayer();
        ICustomClass cap = CustomClass.getFromPlayer(player);
        PracticeMod.LOGGER.info("Current value is: " + cap.getCounter());
        cap.setCounter(cap.getCounter());

//        if (cap.getVersion() == 1) {
            CompoundNBT data = player.getEntityData();
            data.putInt("test", 189);
            String keyArray = Arrays.toString(data.keySet().toArray());
            PracticeMod.LOGGER.debug("key list: " + keyArray);
            int counter = data.getInt("counter");
            PracticeMod.LOGGER.debug("counter value: " + counter);
//            data.putInt("counter", 785);
//            PracticeMod.LOGGER.debug(("" + data.getInt("counter")));
//            CompoundNBT tag = data.getCompound("practiceMod");
//            cap.setCounter(tag.getInt("counter"));
//            data.remove("practiceMod");
//        }
    }

    @SubscribeEvent
    public static void onGunPowRightClick(PlayerInteractEvent.RightClickItem event) {

        PlayerEntity player = event.getEntityPlayer();
        ICustomClass cap = CustomClass.getFromPlayer(player);

        if (event.getItemStack().getItem() == Items.GUNPOWDER) {
            cap.setCounter(cap.getCounter() + 10);
            PracticeMod.LOGGER.info("new value is: " + cap.getCounter());
        }
    }

    @SubscribeEvent
    public static void onAirRightClick(PlayerInteractEvent.RightClickEmpty event) {

        PlayerEntity player = event.getEntityPlayer();
        CompoundNBT data = player.getEntityData();
        ICustomClass cap = CustomClass.getFromPlayer(player);
        ItemStack item = player.getHeldItemMainhand();

        if (item.isEmpty()) {
            PracticeMod.LOGGER.info("Current value is: " + cap.getCounter());
//            PracticeMod.LOGGER.info("Array:" + Arrays.toString(data.keySet().toArray()));
//            PracticeMod.LOGGER.info("Test value is:" + data.getInt("test"));
        }
    }
}