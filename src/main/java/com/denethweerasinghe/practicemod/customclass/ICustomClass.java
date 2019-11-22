package com.denethweerasinghe.practicemod.customclass;

import net.minecraft.nbt.CompoundNBT;

public interface ICustomClass {

    void setCounter(int value);

    int getCounter();

    void increment(int value);

    void copyForRespawn(CustomClass deadPlayer);

    CompoundNBT saveNBTData(CompoundNBT compound);

    void loadNBTData(CompoundNBT compound);
}
