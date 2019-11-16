package com.denethweerasinghe.practicemod.setup;

import net.minecraft.world.World;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ServerProxy implements IProxy {

    @Override
    public void init(){
    }

    @Override
    public void setup(FMLCommonSetupEvent event) {

    }

    @Override
    public World getClientWorld(){
        throw new IllegalStateException("This should only run on the client side");
    }
}
