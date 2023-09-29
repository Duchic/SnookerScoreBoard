package com.example.snookerscoreboard;

public class Player {

    private int points = 0;
    private int breakPoints = 0;
    private String name = "unknown";
    private int pottedRed = 0;
    private int pottedBlack = 0;
    private int pottedPink = 0;
    private int pottedBlue = 0;
    private int pottedBrown = 0;
    private int pottedGreen = 0;
    private int pottedYellow = 0;

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

    public int getPottedRed() {
        return pottedRed;
    }

    public void setPottedRed(int pottedRed) {
        this.pottedRed = pottedRed;
    }

    public int getPottedBlack() {
        return pottedBlack;
    }

    public void setPottedBlack(int pottedBlack) {
        this.pottedBlack = pottedBlack;
    }

    public int getPottedPink() {
        return pottedPink;
    }

    public void setPottedPink(int pottedPink) {
        this.pottedPink = pottedPink;
    }

    public int getPottedBlue() {
        return pottedBlue;
    }

    public void setPottedBlue(int pottedBlue) {
        this.pottedBlue = pottedBlue;
    }

    public int getPottedBrown() {
        return pottedBrown;
    }

    public void setPottedBrown(int pottedBrown) {
        this.pottedBrown = pottedBrown;
    }

    public int getPottedGreen() {
        return pottedGreen;
    }

    public void setPottedGreen(int pottedGreen) {
        this.pottedGreen = pottedGreen;
    }

    public int getPottedYellow() {
        return pottedYellow;
    }

    public void setPottedYellow(int pottedYellow) {
        this.pottedYellow = pottedYellow;
    }
}
