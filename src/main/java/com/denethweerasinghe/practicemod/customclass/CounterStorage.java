package com.denethweerasinghe.practicemod.customclass;

import com.denethweerasinghe.practicemod.setup.PracticeMod;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class CounterStorage implements Capability.IStorage<ICustomClass> {

    @Override
    public INBT writeNBT(Capability<ICustomClass> capability, ICustomClass instance, Direction side) {
        PracticeMod.LOGGER.info("writing NBT!");
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("counter", instance.getCounter());
        tag.putByte("version", instance.getVersion());
        PracticeMod.LOGGER.info("writing NBT data: " + tag.getInt("counter"));
        return tag;
    }

    @Override
    public void readNBT(Capability<ICustomClass> capability, ICustomClass instance, Direction side, INBT nbt) {
        PracticeMod.LOGGER.info("reading NBT!");
        CompoundNBT tag = (CompoundNBT) nbt;
        instance.setCounter(tag.getInt("counter"));
        instance.setVersion(tag.getByte("version"));
        PracticeMod.LOGGER.info("NBT Data: " + tag.getInt("counter"));
        PracticeMod.LOGGER.info("Instance Data: " + instance.getCounter());
    }
}
