package com.denethweerasinghe.practicemod.customclass;

import com.denethweerasinghe.practicemod.setup.PracticeMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;

@Mod.EventBusSubscriber(modid = PracticeMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerPropertiesEvent {

    @SubscribeEvent
    public static void onEntityConstruction(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity){
            event.addCapability(new ResourceLocation(PracticeMod.MODID, "counter"), new PlayerDispatcher());
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event){
        PlayerEntity deadPlayer = event.getOriginal();
        PlayerEntity newPlayer = event.getEntityPlayer();
        ICustomClass oldCounter = CustomClass.getFromPlayer(deadPlayer);
        ICustomClass newCounter = CustomClass.getFromPlayer(newPlayer);
        newCounter.copyForRespawn(oldCounter);
    }

    @SubscribeEvent
    public static void onPlayerLogIn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event){
        PlayerEntity player = event.getPlayer();
        ICustomClass cap = CustomClass.getFromPlayer(player);
        PracticeMod.LOGGER.info("Current value is: " + cap.getCounter());
        cap.setCounter(cap.getCounter());

        if (cap.getVersion() == 1) {
        CompoundNBT data = player.getEntity().getEntityData();
        int counter = data.getInt("counter");
        PracticeMod.LOGGER.debug("counter value: " + counter);
        PracticeMod.LOGGER.info("Array:" + Arrays.toString(data.keySet().toArray()));

//            data.putInt("counter", 785);
//            PracticeMod.LOGGER.debug(("" + data.getInt("counter")));
//            CompoundNBT tag = data.getCompound("practiceMod");
//            cap.setCounter(tag.getInt("counter"));
//            data.remove("practiceMod");
        }
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

