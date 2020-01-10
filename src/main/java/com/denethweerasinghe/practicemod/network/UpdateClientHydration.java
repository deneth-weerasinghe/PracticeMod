package com.denethweerasinghe.practicemod.network;

import com.denethweerasinghe.practicemod.customclass.CustomClass;
import com.denethweerasinghe.practicemod.customclass.ICustomClass;
import com.denethweerasinghe.practicemod.customclass.PlayerDispatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdateClientHydration {

    private final CompoundNBT nbt;

    public UpdateClientHydration(int entityId, CompoundNBT nbt){
        nbt.putInt("entityId", entityId);
        this.nbt = nbt;
    }

    public UpdateClientHydration(CompoundNBT nbt){
        this.nbt = nbt;
    }

    public static void encode(UpdateClientHydration msg, PacketBuffer buf){
        buf.writeCompoundTag(msg.nbt);
    }

    public static UpdateClientHydration decode(PacketBuffer buf){
        return new UpdateClientHydration(buf.readCompoundTag());
    }

    public static void  handle(UpdateClientHydration msg, Supplier<NetworkEvent.Context> ctx){
        ctx.get().enqueueWork(() -> {
            PlayerEntity player = (PlayerEntity) Minecraft.getInstance().world.getEntityByID(msg.nbt.getInt("entityId"));
            ICustomClass cap = CustomClass.getFromPlayer(player);

            PlayerDispatcher.PLAYER_COUNTER.readNBT(cap, null, msg.nbt);
        });
        ctx.get().setPacketHandled(true);
    }

}
