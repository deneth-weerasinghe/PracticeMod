package com.denethweerasinghe.practicemod.setup;

import net.minecraft.world.World;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public interface IProxy {

    void init();

    void setup(FMLCommonSetupEvent event);

    World getClientWorld(); // client side i.e. the player's world

}
