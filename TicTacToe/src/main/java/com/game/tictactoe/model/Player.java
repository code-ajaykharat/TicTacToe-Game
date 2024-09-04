package com.game.tictactoe.model;

import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private PlayerType playerType;
    private char symbol;
    private Scanner scanner;

    public Player(int id, String name, PlayerType playerType, char symbol) {
        this.id = id;
        this.name = name;
        this.playerType = playerType;
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Move makeMove(Board board) {
        int row, col;
        System.out.println("Please provide row number: ");
        row = scanner.nextInt();
        System.out.println("Please provide col number: ");
        col = scanner.nextInt();
        return new Move(new Cell(row, col), this);
    }
}
