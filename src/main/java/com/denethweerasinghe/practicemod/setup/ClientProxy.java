package com.denethweerasinghe.practicemod.setup;

import com.denethweerasinghe.practicemod.handlers.HudEventHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ClientProxy implements IProxy {

    @Override // client side initialisation
    public void init() {
    }

    @Override
    public void setup(FMLCommonSetupEvent event) {
    }

    public static void eventInit() {
        HudEventHandler.init();
    }


    @Override
    public World getClientWorld(){
        return Minecraft.getInstance().world; // overrides server side code with client side code
    }



}
