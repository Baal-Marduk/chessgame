package Pieces;

import Game.*;


public class Reine extends Piece {
    @Override
    public String toString() {
        return "D";
    }

    public Reine(int x, int y, boolean couleur) {
        super(x, y, couleur);
        this.setPieceType("reine");
    }

    @Override
    public int[][] move() {
        int[][] possibleMoves = new int[][]{
                {0,8},
                {8,0},
                {8,8}
        };

        return possibleMoves;

    }
}
