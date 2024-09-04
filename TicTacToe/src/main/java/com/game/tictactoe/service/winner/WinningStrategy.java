package com.game.tictactoe.service.winner;

import com.game.tictactoe.model.Board;
import com.game.tictactoe.model.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
