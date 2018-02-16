package Pieces;

import Game.*;


public class Pion extends Piece {
    private boolean haveMoved;


    public Pion(int x, int y, boolean couleur) {
        super(x, y, couleur);
        haveMoved = false;
        this.setPieceType("pion");
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public int[][] move() {


        if (haveMoved) {

            int[][] possibleMoves = new int[][]{{0, 1}};

            return possibleMoves;


        } else {
            int[][] possibleMoves = new int[][]{{0, 2}};

            return possibleMoves;
        }

    }
}
