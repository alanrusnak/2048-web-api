package com.alanrusnak.api2048.engine.model;

public class Tile {

    private int value;
    private boolean isAlreadyMerged;

    public Tile() {
        this(0);
    }

    public Tile(int value) {
        this.value = value;
        this.isAlreadyMerged = false;
    }

    public boolean isEmpty(){
        return value == 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isMergedAlready() {
        return isAlreadyMerged;
    }

    public void setMergedAlready(boolean mergedAlready) {
        isAlreadyMerged = mergedAlready;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}