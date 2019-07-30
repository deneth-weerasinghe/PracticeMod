package com.denethweerasinghe.practicemod.setup;

import net.minecraft.client.Minecraft; // client side class
import net.minecraft.world.World;

public class ClientProxy implements IProxy {
    @Override
    public void init() { // client side intialisation

    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world; // if the code is client side then it will go on as usual
        // refer to ServerProxy.java for what happens if client side code is run server side
    }
}
