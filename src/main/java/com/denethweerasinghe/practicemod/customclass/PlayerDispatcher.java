package com.denethweerasinghe.practicemod.customclass;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;

public class PlayerDispatcher implements ICapabilitySerializable<CompoundNBT> {

    @CapabilityInject(ICustomClass.class)
    public static final Capability<ICustomClass> PLAYER_COUNTER = null;
    private LazyOptional<ICustomClass> instance = LazyOptional.of(PLAYER_COUNTER::getDefaultInstance);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, Direction side) {
        return cap == PLAYER_COUNTER ? instance.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundNBT serializeNBT() {
//        CompoundNBT nbt = new CompoundNBT();
//        return PLAYER_COUNTER.getDefaultInstance().saveNBTData(nbt);
        return (CompoundNBT) PLAYER_COUNTER.getStorage().writeNBT(PLAYER_COUNTER, instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!")), null);
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
//        PLAYER_COUNTER.getDefaultInstance().loadNBTData(nbt);
        PLAYER_COUNTER.getStorage().readNBT(PLAYER_COUNTER, instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!")), null, nbt);
    }
}
