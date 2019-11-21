package com.denethweerasinghe.practicemod.customclass;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class CounterStorage implements Capability.IStorage<CustomClass> {

    @Override
    public INBT writeNBT(Capability<CustomClass> capability, CustomClass instance, Direction side){
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("counter", instance.getCounter());
        return tag;
    }

    @Override
    public void readNBT(Capability<CustomClass> capability, CustomClass instance, Direction side, INBT nbt){
        CompoundNBT tag = (CompoundNBT) nbt;
        instance.setCounter(tag.getInt("counter"));
    }
}
