package com.denethweerasinghe.practicemod.customclass;

import net.minecraft.nbt.CompoundNBT;

public class CustomClass {
    private int counter;

    public CustomClass(){
    }

    public int getCounter(){
        return counter;
    }

    public void setCounter(){
        this.counter = 20;
    }

    public void copyForRespawn(CustomClass deadPlayer){
        counter = deadPlayer.counter;
    }

    public void saveNBTData(CompoundNBT compound){
        compound.putInt("counter", counter);
    }

    public void loadNBTData(CompoundNBT compound){
        counter = compound.getInt("counter");
    }

}
