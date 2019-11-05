package com.denethweerasinghe.practicemod.customclass;

public class CustomClass {
    private final int maxValue = 20;
    private int counter;

    public CustomClass() {
        counter = maxValue;
    }

    public void incrementCounter(){
        counter ++;
    }

    public void decay(){
        counter -= 1;
    }

    public int getCounter(){
        return counter;
    }
}
