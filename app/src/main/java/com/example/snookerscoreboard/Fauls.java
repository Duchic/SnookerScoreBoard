package com.example.snookerscoreboard;

public enum Fauls {
    FAUL2(2),
    FAUL3(3),
    FAUL4(4),
    FAUL5(5),
    FAUL6(6),
    FAUL7(7);

    private final int value;

    Fauls(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
