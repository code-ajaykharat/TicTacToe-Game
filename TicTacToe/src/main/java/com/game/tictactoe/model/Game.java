package com.game.tictactoe.model;

import com.game.tictactoe.service.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Player winner;
    private List<WinningStrategy> winningStrategies;
    private List<Move> moves;
    private GameState gameState;
    private int nextPlayerId;

    public Game(int dimention, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimention);
        this.players = players;
        this.winner = null;
        this.winningStrategies = winningStrategies;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerId = 0;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerId() {
        return nextPlayerId;
    }

    public void setNextPlayerId(int nextPlayerId) {
        this.nextPlayerId = nextPlayerId;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private int dimention;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder dimention(int dimention) {
            this.dimention = dimention;
            return this;
        }

        public Builder players(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder winningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        private void validate(){
            //validate number of players
            //validate unique symbols
            //validate only one bot player
        }

        public Game build(){
            validate();
            return new Game(this.dimention, this.players, this.winningStrategies);
        }
    }

    public void displayBoard(){
        board.display();
    }
}
