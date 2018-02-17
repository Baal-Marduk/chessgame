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

            int[][] possibleMoves = new int[][]{{1, 0}};

            return possibleMoves;


        } else {
            int[][] possibleMoves = new int[][]{{2, 0}};

            return possibleMoves;
        }

    }
}
