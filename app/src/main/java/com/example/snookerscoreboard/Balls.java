package com.example.snookerscoreboard;

public enum Balls {
    RED(1),
    BLACK(7),
    PINK(6),
    BLUE(5),
    BROWN(4),
    GREEN(3),
    YELLOW(2);

    private final int value;

    Balls(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
