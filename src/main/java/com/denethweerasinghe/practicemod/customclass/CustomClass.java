package com.denethweerasinghe.practicemod.customclass;

public class CustomClass implements ICustomClass{

    private int counter = 20;

    @Override
    public int getCounter() {
        return counter;
    }

    @Override
    public void setCounter(int value) {
        this.counter = value;
    }

    @Override
    public void copyForRespawn(CustomClass deadPlayer) {
        counter = deadPlayer.counter;
    }

}
