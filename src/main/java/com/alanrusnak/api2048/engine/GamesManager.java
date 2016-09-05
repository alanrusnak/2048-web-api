package com.alanrusnak.api2048.engine;

import com.alanrusnak.api2048.engine.model.Board;
import com.alanrusnak.api2048.engine.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GamesManager {

    @Autowired
    private MoveExecutor moveExecutor;

    @Autowired
    private RandomStateGenerator randomStateGenerator;

    private Map<String, Game> activeGames = new HashMap<String, Game>();

    public Game createNewGame() {
        String id = randomStateGenerator.generateGameId();
        Board board = randomStateGenerator.generateNewBoard();
        Game newGame = new Game(id, board);
        activeGames.put(id, newGame);
        return newGame;
    }

    public Game getGame(String id){
        return activeGames.get(id);
    }

    public void move(String id, String direction){
        Board board = activeGames.get(id).getBoard();
        moveExecutor.move(board, Integer.parseInt(direction));
        randomStateGenerator.generateNextRandomTile(board);
    }
}
