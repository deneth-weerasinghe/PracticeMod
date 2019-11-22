package com.denethweerasinghe.practicemod.customclass;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

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
//    @Override
//    public INBT writeNBT(Capability<ICustomClass> capability, ICustomClass instance, Direction side) {
//        CompoundNBT tag = new CompoundNBT();
//        tag.putInt("counter", instance.getCounter());
//        return tag;
//    }
//        return instance.saveNBTData(new CompoundNBT());
//}

//    @Override
//    public void readNBT(Capability<ICustomClass> capability, ICustomClass instance, Direction side, INBT nbt) {
//        CompoundNBT tag = (CompoundNBT) nbt;
//        instance.setCounter(tag.getInt("counter"));
//    }
//}
//        instance.loadNBTData((CompoundNBT) nbt);
//    }
}
