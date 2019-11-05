package com.denethweerasinghe.practicemod.setup;

import com.denethweerasinghe.practicemod.hudoverlay.HudEventHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {

    @Override // client side initialisation
    public void init() {
    }

    @Override
    public void eventInit() {
        HudEventHandler.init();
    }


    @Override
    public World getClientWorld(){
        return Minecraft.getInstance().world; // overrides server side code with client side code
    }



}
