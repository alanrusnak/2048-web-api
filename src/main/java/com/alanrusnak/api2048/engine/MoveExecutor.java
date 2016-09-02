package com.alanrusnak.api2048.engine;

import com.alanrusnak.api2048.engine.model.Board;
import com.alanrusnak.api2048.engine.model.Tile;
import org.springframework.stereotype.Component;

@Component
public class MoveExecutor {

    public void move(Board board, int direction){
        switch(direction){
            case 0: boardMoveUp(board); break;
            case 1: boardMoveRight(board); break;
            case 2: boardMoveDown(board); break;
            case 3: boardMoveLeft(board); break;
            default: throw new IllegalArgumentException("Incorrect move direction " + direction);
        }
    }

    public void boardMoveUp(Board board){

    }

    public void columnMoveUp(Tile[] column){

    }

    public void boardMoveRight(Board board){

    }

    public void rowMoveRight(Tile[] row){

    }

    public void boardMoveDown(Board board){

    }

    public void columnMoveDown(Tile[] row){

    }

    public void boardMoveLeft(Board board){

    }

    public void rowMoveLeft(Tile[] column){

    }

    public void slideRight(Tile[] row){

    }

}
