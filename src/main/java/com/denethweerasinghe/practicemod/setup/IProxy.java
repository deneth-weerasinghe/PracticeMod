package com.denethweerasinghe.practicemod.setup;

import net.minecraft.world.World;

public interface IProxy {

    void init();

    World getClientWorld(); // client side i.e. the player's world

}