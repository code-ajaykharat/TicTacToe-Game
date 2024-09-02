package com.game.tictactoe.service;

import com.game.tictactoe.model.Board;
import com.game.tictactoe.model.Move;
import com.game.tictactoe.model.Player;

public interface BotPlayingLevel {
    Move makeMove(Board board, Player bot);
}
