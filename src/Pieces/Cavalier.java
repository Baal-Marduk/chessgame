package Pieces;

import Game.*;


public class Cavalier extends Piece {
    public Cavalier(int x, int y, boolean couleur) {
        super(x, y, couleur);
        this.setPieceType("cavalier");
    }

    @Override
    public int[][] move() {
        return new int[0][];
    }

    @Override
    public String toString() {
        return "C";
    }
}
