package com.denethweerasinghe.practicemod.customclass;

import com.denethweerasinghe.practicemod.setup.PracticeMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerPropertiesEvent {

    @SubscribeEvent
    public void onEntityConstruction(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity){
            event.addCapability(new ResourceLocation(PracticeMod.MODID, "counter"), new PlayerDispatcher());
        }
    }

    @SubscribeEvent
    public void onPlayerCloned(PlayerEvent.Clone event){
        PlayerEntity deadPlayer = event.getOriginal();
        PlayerEntity newPlayer = event.getEntityPlayer();
        ICustomClass oldCounter = CustomClass.getFromPlayer(deadPlayer);
        ICustomClass newCounter = CustomClass.getFromPlayer(newPlayer);
        newCounter.copyForRespawn(oldCounter);
    }

}

