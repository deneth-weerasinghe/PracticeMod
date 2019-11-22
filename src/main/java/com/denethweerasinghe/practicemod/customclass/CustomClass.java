package com.denethweerasinghe.practicemod.customclass;

import net.minecraft.nbt.CompoundNBT;

public class CustomClass implements ICustomClass{

    private int counter = 20;

    @Override
    public void setCounter(int value) {
        this.counter = value;
    }

    @Override
    public int getCounter() {
        return counter;
    }

    @Override
    public void increment(int value) {
        counter += value;
    }

    @Override
    public void copyForRespawn(CustomClass deadPlayer) {
        counter = deadPlayer.counter;
    }

    @Override
    public CompoundNBT saveNBTData(CompoundNBT compound) {
        compound.putInt("counter", counter);
        return compound;
    }

    @Override
    public void loadNBTData(CompoundNBT compound) {
        counter = compound.getInt("counter");
    }

}
