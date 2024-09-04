package com.game.tictactoe.service.bot;

import com.game.tictactoe.model.Board;
import com.game.tictactoe.model.Move;

public interface BotPlayingLevel {
    Move makeMove(Board board);
}
