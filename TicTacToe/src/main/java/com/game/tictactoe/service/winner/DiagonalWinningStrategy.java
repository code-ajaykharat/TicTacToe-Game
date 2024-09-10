package com.game.tictactoe.service.winner;

import com.game.tictactoe.model.Board;
import com.game.tictactoe.model.Move;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy{
    HashMap<Character, Integer> leftDiagonalData = new HashMap<>();
    HashMap<Character, Integer> rightDiagonalData = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        int row = move.getCell().getRow();
        char symbol = move.getPlayer().getSymbol();
        int size = board.getDimension();
        boolean flag = false;
        if(row==col){//left
           leftDiagonalData.put(symbol, leftDiagonalData.getOrDefault(symbol,0)+1);
           flag = leftDiagonalData.get(symbol)==size;
        }
        if(row+col==size-1){
            rightDiagonalData.put(symbol, rightDiagonalData.getOrDefault(symbol,0)+1);
            flag = rightDiagonalData.get(symbol)==size;
        }
        return flag;
    }

    @Override
    public void updateForUndo(Board board, Move move) {
        int col = move.getCell().getCol();
        int row = move.getCell().getRow();
        char symbol = move.getPlayer().getSymbol();
        int size = board.getDimension();
        if(row==col){//left
            leftDiagonalData.put(symbol, leftDiagonalData.get(symbol)-1);
        }
        if(row+col==size-1){
            rightDiagonalData.put(symbol, rightDiagonalData.get(symbol)-1);
        }
    }
}
