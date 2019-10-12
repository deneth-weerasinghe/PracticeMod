package com.denethweerasinghe.practicemod.setup;

import javafx.geometry.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientProxy implements IProxy {

    @Override // client side initialisation
    public void init() {
    }

    @Override
    public World getClientWorld(){
        return Minecraft.getInstance().world; // overrides server side code with client side code
    }



}
