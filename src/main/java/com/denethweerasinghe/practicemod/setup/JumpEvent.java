package com.denethweerasinghe.practicemod.setup;

import com.denethweerasinghe.practicemod.customclass.CustomClass;
import com.denethweerasinghe.practicemod.customclass.ICustomClass;
import com.denethweerasinghe.practicemod.customclass.PlayerDispatcher;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class JumpEvent {

    // ok to name all methods here as "onEvent" because the compiler treats them uniquely based on its parameters
    @SubscribeEvent
    public static void onPlayerLogIn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event){

        PlayerEntity player = event.getPlayer();
        World world = player.world;

        if (!world.isRemote){
            ICustomClass cap = CustomClass.getFromPlayer(player);
            PlayerDispatcher.PLAYER_COUNTER.getStorage().readNBT(PlayerDispatcher.PLAYER_COUNTER, cap, null, player.getEntityData().getCompound(PlayerDispatcher.PLAYER_COUNTER.getName()));
        }



//        ICustomClass cap = CustomClass.getFromPlayer(player);
//        PracticeMod.LOGGER.info("Current value is: " + cap.getCounter());
//        cap.setCounter(cap.getCounter());

//        CompoundNBT data = player.getEntity().getEntityData();
//        CompoundNBT tag = data.getCompound("practiceMod");
//        cap.setCounter(tag.getInt("counter"));
//        data.remove("practiceMod");
    }

    @SubscribeEvent
    public static void onTest(PlayerInteractEvent.RightClickItem event) {

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
        ICustomClass cap = CustomClass.getFromPlayer(player);
        ItemStack item = player.getHeldItemMainhand();

        if (item.isEmpty()) {
            PracticeMod.LOGGER.info("Current value is: " + cap.getCounter());
        }
    }
}