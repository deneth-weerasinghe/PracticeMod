package com.denethweerasinghe.practicemod.customclass;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerProperties {

    @CapabilityInject(CustomClass.class)
    public static Capability<CustomClass> PLAYER_COUNTER;

    public static LazyOptional<CustomClass> getPlayerCounter(PlayerEntity player){
        return player.getCapability(PLAYER_COUNTER, null); //gets the capability from the player object
    }
}
