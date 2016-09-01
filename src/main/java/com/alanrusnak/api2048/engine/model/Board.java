package com.alanrusnak.api2048.engine.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int[][] tiles;

    public Board() {
        this.tiles = new int[4][4];
    }

    public int[][] getTiles() {
        return tiles;
    }

    public int getTileAtIndex(int index){
        return tiles[index % 4][index / 4];
    }

    public void setTileAtIndex(int index, int value){
        tiles[index % 4][index / 4] = value;
    }

    public List<Integer> getFreeIndexList(){
        List<Integer> freeIndexes = new ArrayList<Integer>();
        for(int i = 0; i < 16; i++){
            if(getTileAtIndex(i) == 0) {
                freeIndexes.add(i);
            }
        }
        return freeIndexes;
    }
}
