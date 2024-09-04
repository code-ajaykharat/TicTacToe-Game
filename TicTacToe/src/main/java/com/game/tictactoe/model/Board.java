package com.game.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> grid;

    public Board(int dimension) {
        this.dimension = dimension;
        this.grid = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            grid.add(new ArrayList<Cell>());
            for (int j = 0; j < dimension; j++) {
                grid.get(i).add(new Cell(i, j));
            }
        }
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public void setGrid(List<List<Cell>> grid) {
        this.grid = grid;
    }

    public void display() {
        for (List<Cell> lst : this.grid) {
            for (Cell cell : lst) {
                cell.printCell();
            }
            System.out.println();
        }
    }
}
