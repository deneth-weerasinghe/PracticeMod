package com.denethweerasinghe.practicemod.customclass;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class CounterStorage implements Capability.IStorage<CustomClass> {

    @Override
    public void readNBT(Capability<CustomClass> capability, CustomClass instance, Direction facing, INBT nbt) {
        instance.loadNBTData((CompoundNBT)nbt);
    }

    @Override
    public CompoundNBT writeNBT(Capability<CustomClass> capability, CustomClass instance, Direction side) {
        CompoundNBT nbttag = new CompoundNBT();
        instance.saveNBTData(nbttag);
        return nbttag;
    }

}
