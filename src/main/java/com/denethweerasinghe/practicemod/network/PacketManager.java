package com.denethweerasinghe.practicemod.network;

import com.denethweerasinghe.practicemod.setup.PracticeMod;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketManager {

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(PracticeMod.MODID, "practicemod"),
            () -> "1",
            "1"::equals,
            "1"::equals);

    public static void register(){
        int id = 0;
        INSTANCE.registerMessage(id++, SyncPacket.class, SyncPacket::encode, SyncPacket::decode, SyncPacket::handle);
    }

    public static void sendToServer(Object msg){
        INSTANCE.sendToServer(msg);
    }

    public static void sendTo(ServerPlayerEntity player, Object msg){
        INSTANCE.sendTo(msg, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
    }


}

