package com.denethweerasinghe.practicemod.customclass;

import com.denethweerasinghe.practicemod.network.PacketManager;
import com.denethweerasinghe.practicemod.network.SyncPacket;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;

public class CustomClass implements ICustomClass{

    private int counter;
    private byte version;

    public CustomClass(){
        this.counter = 20;
        this.version = (byte) 1;
    }

    @Override
    public void setVersion(byte version) {
        this.version = version;
    }

    @Override
    public byte getVersion() {
        return version;
    }

    @Override
    public void setCounter(int value) {
        this.counter = value;
    }

    @Override
    public int getCounter() {
        return counter;
    }

    @Override
    public void copyForRespawn(ICustomClass deadPlayer) {
        this.setCounter(deadPlayer.getCounter());
    }

    public static ICustomClass getFromPlayer(PlayerEntity player){
        return player.getCapability(PlayerDispatcher.PLAYER_COUNTER, null).orElseThrow(() -> new IllegalArgumentException(("LazyOptional must not be empty!")));
    }

    public static void updateClient(ServerPlayerEntity player, ICustomClass cap){
        PacketManager.sendTo(player, new SyncPacket(player.getEntityId(), (CompoundNBT) PlayerDispatcher.PLAYER_COUNTER.writeNBT(cap, null)));
    }
}
