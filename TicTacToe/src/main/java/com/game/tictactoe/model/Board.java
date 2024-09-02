package com.game.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimention;
    private List<List<Cell>> grid;

    public Board(int dimention) {
        this.dimention = dimention;
        this.grid = new ArrayList<>();//outside list
        for(int i=0;i<dimention;i++){
            grid.add(new ArrayList<Cell>());//inside list
            for(int j=0;j<dimention;j++){
                grid.get(i).add(new Cell(i, j));
            }
        }
    }

    public int getDimention() {
        return dimention;
    }

    public void setDimention(int dimention) {
        this.dimention = dimention;
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public void setGrid(List<List<Cell>> grid) {
        this.grid = grid;
    }

    public void display(){
        for(List<Cell> lst: this.grid){
            for(Cell cell:lst){
                cell.printCell();
            }
            System.out.println();
        }
    }
}
