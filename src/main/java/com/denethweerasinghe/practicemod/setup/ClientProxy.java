package com.denethweerasinghe.practicemod.setup;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ClientProxy implements IProxy {

    @Override // client side initialisation
    public void init() {
    }

    @Override
    public World getClientWorld(){
        return Minecraft.getInstance().world; // overrides server side code with client side code
    }



}
