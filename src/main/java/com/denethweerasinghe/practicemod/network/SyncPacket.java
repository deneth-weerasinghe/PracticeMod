package com.denethweerasinghe.practicemod.network;

import com.denethweerasinghe.practicemod.customclass.CustomClass;
import com.denethweerasinghe.practicemod.customclass.ICustomClass;
import com.denethweerasinghe.practicemod.customclass.PlayerDispatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class SyncPacket {

    private final CompoundNBT nbt;

    public  SyncPacket(int entityID, CompoundNBT nbt){
        nbt.putInt("entityid", entityID);
        this.nbt = nbt;
    }

    private SyncPacket(CompoundNBT nbt) {
        this.nbt = nbt;
    }

    public static void encode(SyncPacket msg, PacketBuffer buf){
        buf.writeCompoundTag(msg.nbt);
    }

    public static SyncPacket decode(PacketBuffer buf){
        return new SyncPacket(buf.readCompoundTag());
    }

    public static void handle(SyncPacket msg, Supplier<NetworkEvent.Context> ctx){
        ctx.get().enqueueWork(() -> {
            PlayerEntity player = (PlayerEntity) Minecraft.getInstance().world.getEntityByID(msg.nbt.getInt("entityid"));
            ICustomClass cap = CustomClass.getFromPlayer(player);
            PlayerDispatcher.PLAYER_COUNTER.readNBT(cap, null, msg.nbt);
        });

        ctx.get().setPacketHandled(true);
    }
}
