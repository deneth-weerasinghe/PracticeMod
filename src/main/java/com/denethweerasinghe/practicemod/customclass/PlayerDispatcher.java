package com.denethweerasinghe.practicemod.customclass;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerDispatcher implements ICapabilityProvider {

    @CapabilityInject(ICustomClass.class)
    public static final Capability<ICustomClass> PLAYER_COUNTER = null;

    private LazyOptional<ICustomClass> instance;

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (cap != PLAYER_COUNTER)
            return LazyOptional.empty();
        if (this.instance == null){
            this.instance = LazyOptional.of(PLAYER_COUNTER::getDefaultInstance);
        }
        return this.instance.cast();
    }

//    @Override
//    public CompoundNBT serializeNBT() {
//        return (CompoundNBT) PLAYER_COUNTER.getStorage().writeNBT(PLAYER_COUNTER, this.getCapability(PLAYER_COUNTER, null).orElse(null), null);
//    }
//
//    @Override
//    public void deserializeNBT(CompoundNBT nbt) {
//        PLAYER_COUNTER.getStorage().readNBT(PLAYER_COUNTER, this.getCapability(PLAYER_COUNTER, null).orElse(null), null, nbt);
//    }
}
