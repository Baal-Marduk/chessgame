package Pieces;

import Game.*;


public class Tour extends Piece {


    public Tour(int x, int y, boolean couleur ) {
        super(x, y, couleur);
        this.setPieceType("tour");

    }


    @Override
    public String toString() {
        return "T";

    }

    @Override
    public int[][] move() {

        int[][] possibleMoves = new int[][]{
                {0,8},
                {8,0}
        };

        return possibleMoves;


    }
}
