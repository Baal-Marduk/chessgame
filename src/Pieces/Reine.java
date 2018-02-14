package Pieces;

import Game.*;


public class Reine extends Piece {
    @Override
    public String toString() {
        return "D";
    }

    public Reine(int x, int y, boolean couleur, Plateau plateau) {
        super(x, y, couleur, plateau);
    }



    @Override
    public boolean move() {
        return false;
    }
}
