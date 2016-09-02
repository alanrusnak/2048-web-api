package com.alanrusnak.api2048.controller;

import com.alanrusnak.api2048.engine.GamesManager;
import com.alanrusnak.api2048.engine.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private GamesManager gamesManager;

    @RequestMapping(value="/2048/new", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String newGame() {
        String id = gamesManager.createNewGame();
        return "Your game id is: " + id + "\n" + gamesManager.getGame(id).getBoard().toString();
    }

    @RequestMapping(value="/2048/{gameId}", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String getGame(@PathVariable(value="gameId") String gameId) {
        return gamesManager.getGame(gameId).getBoard().toString();
    }

    @RequestMapping(value="/2048/{gameId}/{direction}", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String move(@PathVariable(value="gameId") String gameId, @PathVariable(value="direction") String direction) {
        gamesManager.move(gameId, direction);
        return gamesManager.getGame(gameId).getBoard().toString();
    }
}
