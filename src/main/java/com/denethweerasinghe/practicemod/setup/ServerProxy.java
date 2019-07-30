package com.denethweerasinghe.practicemod.setup;

import net.minecraft.world.World;

public class ServerProxy implements IProxy {
    @Override
    public void init() { // server zide initialisation

    }

    @Override
    public World getClientWorld() {
        throw new IllegalStateException("This should only be run on the client");
    } // hence an error will be thrown if something tries to run client code server side!
}
