package com.game.tictactoe.model;

import com.game.tictactoe.exception.BotPlayerExceededException;
import com.game.tictactoe.exception.PlayerOutOfBoundException;
import com.game.tictactoe.exception.SameSymbolException;
import com.game.tictactoe.service.winner.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Player winner;
    private List<WinningStrategy> winningStrategies;
    private List<Move> moves;
    private GameState gameState;
    private int nextPlayerId;

    public Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder() {
            this.dimension = 3;
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
        }

        public Builder dimension(int dimension) {
            this.dimension = dimension;
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

        public Builder addPlayer(Player player) {
            this.players.add(player);
            return this;
        }

        public Builder addWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategies.add(winningStrategy);
            return this;
        }

        private void validateNumberOfPlayers() {
            if (this.players.size() != this.dimension - 1) {
                throw new PlayerOutOfBoundException("Number of players exceeded!");
            }
        }

        private void validateSymbol() {
            HashSet<Character> symbols = new HashSet<>();
            for (Player player : this.players) {
                if (player.getSymbol() == 'G' && player.getPlayerType().equals(PlayerType.HUMAN)) {
                    throw new SameSymbolException("Please do not use symbol 'G'. It is reserved.");
                }
                symbols.add(player.getSymbol());
            }
            if (symbols.size() != players.size()) {
                throw new SameSymbolException("Please use unique symbols for each player");
            }
        }

        private void validateBotPlayer() {
            int cnt = 0;
            for (Player player : this.players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    cnt++;
                }
            }
            if (cnt > 1) {
                throw new BotPlayerExceededException("Only one bot player is allowed!");
            }
        }

        private void validate() {
            validateBotPlayer();
            validateSymbol();
            validateNumberOfPlayers();
        }

        public Game build() {
            validate();
            return new Game(this.dimension, this.players, this.winningStrategies);
        }
    }

    public void displayBoard() {
        board.display();
    }

    private boolean validateMove(Move move) {
        if (move != null) {
            int row = move.getCell().getRow();
            int col = move.getCell().getCol();

            if (row < 0 || row >= board.getDimension() || col < 0 || col >= board.getDimension()) {
                System.out.println("Incorrect row or col number. Play again!");
                executeMove();
                return false;
            }

            Cell cell = this.board.getGrid().get(row).get(col);

            if (!cell.getCellState().equals(CellState.EMPTY)) {
                System.out.println("Cell is already occupied. Play again!");
                executeMove();
                return false;
            }
        }
        return true;
    }

    public void executeMove() {
        Player player = players.get(nextPlayerId);
        System.out.println("It's " + player.getName() + "'s turn!");
        Move move = player.makeMove(board);

        boolean isValid = validateMove(move);
        if (!isValid) return;

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cellToFill = board.getGrid().get(row).get(col);
        cellToFill.setCellState(CellState.FILLED);
        cellToFill.setPlayer(player);

        move.setPlayer(player);
        move.setCell(cellToFill);
        moves.add(new Move(new Cell(row,col,CellState.FILLED,player),player));

        nextPlayerId += 1;
        nextPlayerId %= this.players.size();

        if (checkWinner(board, move)) {
            this.setGameState(GameState.SUCCESS);
            this.winner = player;
        }else if(moves.size() >= (board.getDimension() * board.getDimension())) {
            this.setGameState(GameState.DRAW);
        }
    }

    public boolean checkWinner(Board board, Move move) {
        for (WinningStrategy winningStrategy : winningStrategies) {
            if (winningStrategy.checkWinner(board, move)) {
                return true;
            }
        }
        return false;
    }

    public void undo() {
        if (moves.isEmpty()) {
            System.out.println("Nothing to Undo!");
            return;
        }
        Move move = this.moves.get(moves.size() - 1);
        Cell moveCell = move.getCell();

        Cell boardCell = this.board.getGrid().get(moveCell.getRow()).get(moveCell.getCol());
        boardCell.setCellState(CellState.EMPTY);
        boardCell.setPlayer(null);

        moves.remove(moves.size() - 1);

        nextPlayerId -= 1;
        nextPlayerId = (nextPlayerId + players.size()) % players.size();

        for (WinningStrategy w : this.winningStrategies) {
            w.updateForUndo(this.board, move);
        }

    }

    public void replayOfGame(){
        int i = 0;
        Board board1 = new Board(board.getDimension());
        while(i<this.moves.size()){
            Move move = moves.get(i);
            Cell moveCell = move.getCell();
            int row = moveCell.getRow();
            int col = moveCell.getCol();
            Cell gridCell = board1.getGrid().get(row).get(col);
            gridCell.setPlayer(moveCell.getPlayer());
            gridCell.setCellState(moveCell.getCellState());
            System.out.println(gridCell.getPlayer().getName()+" played below move: ");
            board1.display();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }
}
