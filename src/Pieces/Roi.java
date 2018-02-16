package Pieces;
import Game.*;


public class Roi  extends Piece{
    public Roi(int x, int y, boolean couleur) {
        super(x, y, couleur);
        this.setPieceType("roi");
    }

    @Override
    public int[][] move() {
        int[][] possibleMoves = new int[][]{
                {0,1},
                {1,0},
                {1,1}
        };

        return possibleMoves;
    }

    @Override
    public String toString() {
        return "R";
    }
}
