package com.denethweerasinghe.practicemod.customclass;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerDispatcher implements ICapabilitySerializable<CompoundNBT> {

    @CapabilityInject(ICustomClass.class)
    public static Capability<ICustomClass> PLAYER_COUNTER = null;
    private final LazyOptional<ICustomClass> instance = LazyOptional.of(PLAYER_COUNTER::getDefaultInstance);


    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == PLAYER_COUNTER ? instance.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundNBT serializeNBT() {
        return (CompoundNBT) PLAYER_COUNTER.getStorage().writeNBT(PLAYER_COUNTER, this.instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!")), null);
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        PLAYER_COUNTER.getStorage().readNBT(PLAYER_COUNTER, this.instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!")), null, nbt);
    }
}
