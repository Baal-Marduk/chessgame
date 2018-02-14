package Pieces;

import Game.*;


public class Pion extends Piece {
    public Pion(int x, int y, boolean couleur, Plateau plateau) {
        super(x, y, couleur, plateau);
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean move() {
        return false;
    }
}
