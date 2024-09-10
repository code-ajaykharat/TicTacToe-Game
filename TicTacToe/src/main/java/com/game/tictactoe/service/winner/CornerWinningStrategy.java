package com.game.tictactoe.service.winner;

import com.game.tictactoe.model.Board;
import com.game.tictactoe.model.Move;

import java.util.HashMap;

public class CornerWinningStrategy implements WinningStrategy {
    HashMap<Character, Integer> cornerData = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        int row = move.getCell().getRow();
        char symbol = move.getPlayer().getSymbol();
        int size = board.getDimension();
        //corners - 0 0 | 0 size -1 | size-1 0 | size-1 size-1
        if ((row == 0 && col == 0) || (row == 0 && col == size - 1) || (row == size - 1 && col == 0) || (row == size - 1 && col == size - 1)) {
            if(!cornerData.containsKey(symbol)){
                cornerData.put(symbol, 1);
            }else{
                cornerData.put(symbol, cornerData.get(symbol)+1);
            }
            return cornerData.get(symbol)==4;
        }
        return false;
    }

    @Override
    public void updateForUndo(Board board, Move move) {
        int col = move.getCell().getCol();
        int row = move.getCell().getRow();
        char symbol = move.getPlayer().getSymbol();
        int size = board.getDimension();
        if ((row == 0 && col == 0) || (row == 0 && col == size - 1) || (row == size - 1 && col == 0) || (row == size - 1 && col == size - 1)) {
            cornerData.put(symbol, cornerData.get(symbol) - 1);
        }
    }
}
