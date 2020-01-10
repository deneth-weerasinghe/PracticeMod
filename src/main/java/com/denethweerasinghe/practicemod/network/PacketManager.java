package com.denethweerasinghe.practicemod.network;

import com.denethweerasinghe.practicemod.setup.PracticeMod;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.play.client.CPlayerTryUseItemOnBlockPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketManager {

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(
            PracticeMod.MODID, "practicemod"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
            );

    public static void register(){
        int id = 0;
        INSTANCE.registerMessage(
                id++,
                UpdateClientHydration.class,
                UpdateClientHydration::encode,
                UpdateClientHydration::decode,
                UpdateClientHydration::handle);
    }

    public static void sendToServer(Object msg){
        INSTANCE.sendToServer(msg);
    }

    public static void sendTo(ServerPlayerEntity player, Object msg){
        INSTANCE.sendTo(msg, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
    }
}

