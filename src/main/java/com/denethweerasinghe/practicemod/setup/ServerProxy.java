package com.denethweerasinghe.practicemod.setup;

import net.minecraft.world.World;

public class ServerProxy implements IProxy {

    @Override
    public void init(){
    }

    @Override
    public void eventInit() {

    }

    @Override
    public World getClientWorld(){
        throw new IllegalStateException("This should only run on the client side");
    }
}
