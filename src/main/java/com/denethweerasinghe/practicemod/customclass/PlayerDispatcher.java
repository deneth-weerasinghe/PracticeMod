package com.denethweerasinghe.practicemod.customclass;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PlayerDispatcher implements ICapabilitySerializable<CompoundNBT> {

    @CapabilityInject(ICustomClass.class)
    public static final Capability<ICustomClass> PLAYER_COUNTER = null;

    private ICustomClass instance = PLAYER_COUNTER.getDefaultInstance();

//    private CustomClass counter = new CustomClass();

    @SuppressWarnings("unchecked")
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, Direction side) {
        return (LazyOptional<T>) LazyOptional.of(() -> new CustomClass());
    }

//    @Nonnull
//    @Override
//    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
//        if (cap == PLAYER_COUNTER){
//            return LazyOptional.of(() -> (T) counter);
//        }
//        return LazyOptional.empty();
//    }


    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        return PLAYER_COUNTER.getDefaultInstance().saveNBTData(nbt);
//        return (CompoundNBT) PLAYER_COUNTER.getStorage().writeNBT(PLAYER_COUNTER, instance, null);
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        PLAYER_COUNTER.getDefaultInstance().loadNBTData(nbt);
//        PLAYER_COUNTER.getStorage().readNBT(PLAYER_COUNTER, instance, null, nbt);
    }
}
