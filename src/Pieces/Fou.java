package Pieces;

import Game.*;

public class Fou extends Piece {

    public Fou(int x, int y, boolean couleur) {
        super(x, y, couleur);
        this.setPieceType("fou");
    }

    @Override
    public int[][] move() {

        int[][] possibleMoves = new int[][]{{8,8}};

        return possibleMoves;


    }

    @Override
    public String toString() {
        return "F";
    }
}


