package com.example.snookerscoreboard;

public class Player {

    private int points = 0;
    private int breakPoints = 0;
    private String name = "unknown";

    public Player (String name) {
        this.name = name;
    }

    public Player(){

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getBreakPoints() {
        return breakPoints;
    }

    public void setBreakPoints(int breakPoints) {
        this.breakPoints = breakPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
