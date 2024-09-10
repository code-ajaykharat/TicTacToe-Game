package com.game.tictactoe.service.winner;

import com.game.tictactoe.model.Board;
import com.game.tictactoe.model.Move;

import java.util.HashMap;

public class ColWinningStrategy implements WinningStrategy {
    HashMap<Integer, HashMap<Character, Integer>> colData = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();

        if (!colData.containsKey(col)) {
            colData.put(col, new HashMap<Character, Integer>());
        }

        HashMap<Character, Integer> currentCol = colData.get(col);

        if (!currentCol.containsKey(symbol)) {
            currentCol.put(symbol, 0);
        }
        currentCol.put(symbol, currentCol.get(symbol) + 1);

        return currentCol.get(symbol) == board.getDimension();
    }

    @Override
    public void updateForUndo(Board board, Move move) {
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();
        HashMap<Character, Integer> currentCol = colData.get(col);
        currentCol.put(symbol, currentCol.get(symbol) - 1);
    }
}
