package com.denethweerasinghe.practicemod.customclass;

public interface ICustomClass {

    void setVersion(byte newVersion);
    byte getVersion();
    void setCounter(int value);
    int getCounter();
//    void addHydrationAttribute(PlayerEntity player, )
    void copyForRespawn(ICustomClass deadPlayer);

}
