package com.denethweerasinghe.practicemod.customclass;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class PlayerProperties {

    @CapabilityInject(CustomClass.class)
    public static Capability<CustomClass> PLAYER_COUNTER;
}
