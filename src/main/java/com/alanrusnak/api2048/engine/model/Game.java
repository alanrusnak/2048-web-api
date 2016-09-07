package com.alanrusnak.api2048.engine.model;

public class Game {

    private String id;
    private long score;
    private Board board;
    private boolean isGameOver;

    public Game(String id, Board board) {
        this.id = id;
        this.score = 0;
        this.board = board;
        isGameOver = false;
    }

    public String getId() {
        return id;
    }

    public long getScore() {
        return score;
    }

    public void addScore(int score){
        this.score = this.score + score;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }
}
