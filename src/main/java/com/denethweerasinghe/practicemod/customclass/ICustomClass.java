package com.denethweerasinghe.practicemod.customclass;

public interface ICustomClass {

    void setVersion(int value);

    int getVersion();

    void setCounter(int value);

    int getCounter();

    void copyForRespawn(ICustomClass deadPlayer);

}
