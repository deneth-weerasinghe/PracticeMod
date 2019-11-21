package com.denethweerasinghe.practicemod.customclass;

import com.denethweerasinghe.practicemod.setup.PracticeMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerPropertiesEvent {

    @SubscribeEvent
    public void onEntityConstruction(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity){
            if (!event.getObject().getCapability(PlayerDispatcher.capability).isPresent()) {
                event.addCapability(new ResourceLocation(PracticeMod.MODID, "properties"), new PlayerDispatcher());
            }
        }
    }

    @SubscribeEvent
    public void onPlayerCloned(PlayerEvent.Clone event){
        if (event.isWasDeath()){
            LazyOptional<CustomClass> capability = event.getOriginal().getCapability(PlayerDispatcher.capability);
            capability.ifPresent(oldStore -> {
                event.getEntityPlayer().getCapability(PlayerDispatcher.capability).ifPresent(newStore -> {
                    newStore.copyForRespawn(oldStore);
                });
            });
        }
    }
}

