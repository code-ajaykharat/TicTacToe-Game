package com.game.tictactoe.controller;

import com.game.tictactoe.model.Game;
import com.game.tictactoe.model.GameState;
import com.game.tictactoe.model.Player;
import com.game.tictactoe.service.winner.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        return Game.builder()
                .dimension(dimension)
                .players(players)
                .winningStrategies(winningStrategies)
                .build();
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }

    public void executeMove(Game game) {
        game.executeMove();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public GameState currentGameState(Game game) {
        return game.getGameState();
    }

    public void undo(Game game) {
        game.undo();
    }

    //TODO: replay
    public void replay(Game game) {
        game.replayOfGame();
    }
}
