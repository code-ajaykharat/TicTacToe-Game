package com.game.tictactoe.service.winner;

import com.game.tictactoe.model.Board;
import com.game.tictactoe.model.Move;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy {
    HashMap<Integer, HashMap<Character, Integer>> rowData = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        char symbol = move.getPlayer().getSymbol();

        if (!rowData.containsKey(row)) {
            rowData.put(row, new HashMap<Character, Integer>());
        }

        HashMap<Character, Integer> currentRow = rowData.get(row);

        if (!currentRow.containsKey(symbol)) {
            currentRow.put(symbol, 0);
        }
        currentRow.put(symbol, currentRow.get(symbol) + 1);

        return currentRow.get(symbol) == board.getDimension();
    }

    @Override
    public void updateForUndo(Move move) {
        int row = move.getCell().getRow();
        char symbol = move.getPlayer().getSymbol();
        HashMap<Character, Integer> currentRow = rowData.get(row);
        currentRow.put(symbol, currentRow.get(symbol) - 1);
    }
}
