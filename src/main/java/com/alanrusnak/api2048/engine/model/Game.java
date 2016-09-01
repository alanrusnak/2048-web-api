package com.alanrusnak.api2048.engine.model;

public class Game {

    private String id;
    private long score;
    private Board board;

    public Game(String id, Board board) {
        this.id = id;
        this.score = 0;
        this.board = board;
    }

    public String getId() {
        return id;
    }

    public long getScore() {
        return score;
    }

    public Board getBoard() {
        return board;
    }
}
