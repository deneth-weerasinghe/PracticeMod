package com.denethweerasinghe.practicemod.setup;

import com.denethweerasinghe.practicemod.handlers.EventHandler;
import net.minecraft.world.World;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ServerProxy implements IProxy {

    @Override
    public void init(){
    }

    @Override
    public void setup(FMLCommonSetupEvent event) {
    }

    public static void eventInit(){
    }

    @Override
    public World getClientWorld(){
        throw new IllegalStateException("This should only run on the client side");
    }
}
