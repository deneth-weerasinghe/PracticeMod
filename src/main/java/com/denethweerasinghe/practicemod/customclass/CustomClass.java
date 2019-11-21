package com.denethweerasinghe.practicemod.customclass;

public class CustomClass {
    private int counter = 20;

    public CustomClass(){
    }

    public int getCounter(){
        return counter;
    }

    public void setCounter(int value){
        this.counter = value;
    }

    public void copyForRespawn(CustomClass deadPlayer){
        counter = deadPlayer.counter;
    }

}
