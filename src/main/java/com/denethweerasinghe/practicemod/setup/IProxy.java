// Proxy needed to safely handle code that might be used for both client side and server side

package com.denethweerasinghe.practicemod.setup;

import net.minecraft.world.World;

public interface IProxy {

    void init();

    World getClientWorld(); // client side i.e. the player's world
}
