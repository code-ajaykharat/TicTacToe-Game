package com.game.tictactoe.service.bot;

import com.game.tictactoe.model.Board;
import com.game.tictactoe.model.Cell;
import com.game.tictactoe.model.CellState;
import com.game.tictactoe.model.Move;

import java.util.List;

public class EasyBotPlayingLevel implements BotPlayingLevel {
    @Override
    public Move makeMove(Board board) {
        for (List<Cell> cells : board.getGrid()) {
            for (Cell cell : cells) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(cell, null);
                }
            }
        }
        return null;
    }
}
