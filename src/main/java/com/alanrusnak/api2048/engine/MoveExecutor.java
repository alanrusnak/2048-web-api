package com.alanrusnak.api2048.engine;

import com.alanrusnak.api2048.engine.model.Board;
import com.alanrusnak.api2048.engine.model.Tile;
import org.apache.commons.lang3.ArrayUtils;
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

    private void boardMoveUp(Board board){
        for(int i = 0; i < 4; i++){
            columnMoveUp(board.getColumn(i));
        }
    }

    private void columnMoveUp(Tile[] column){
        ArrayUtils.reverse(column);
        slideRight(column);
        ArrayUtils.reverse(column);
    }

    private void boardMoveRight(Board board){
        for(int i = 0; i < 4; i++){
            rowMoveRight(board.getRow(i));
        }
    }

    private void rowMoveRight(Tile[] row){
        slideRight(row);
    }

    private void boardMoveDown(Board board){
        for(int i = 0; i < 4; i++){
            columnMoveDown(board.getColumn(i));
        }
    }

    private void columnMoveDown(Tile[] column){
        slideRight(column);
    }

    private void boardMoveLeft(Board board){
        for(int i = 0; i < 4; i++){
            rowMoveLeft(board.getRow(i));
        }
    }

    private void rowMoveLeft(Tile[] row){
        ArrayUtils.reverse(row);
        slideRight(row);
        ArrayUtils.reverse(row);
    }

    public void slideRight(Tile[] row){
        for(int i = 2; i >= 0; i--){
            if(!row[i].isEmpty()){
                slideTileRight(row, i);
            }
        }
        clearAlreadyMergedFlags(row);
    }

    private void slideTileRight(Tile[] row, int index) {
        for(int i = index; i <= 2; i++){
            if(row[i+1].isEmpty()){
                row[i+1].setValue(row[i].getValue());
                row[i].setValue(0);
            } else if(row[i].getValue() == row[i+1].getValue() && !row[i+1].isAlreadyMerged()){
                row[i+1].setValue(row[i+1].getValue() * 2);
                row[i+1].setAlreadyMerged(true);
                row[i].setValue(0);
                return;
            } else {
                return;
            }
        }
    }

    private void clearAlreadyMergedFlags(Tile[] row) {
        for(int i = 0; i < 4; i++){
            row[i].setAlreadyMerged(false);
        }
    }

}
