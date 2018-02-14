package Pieces;

import Game.*;


public class Tour extends Piece {


    public Tour(int x, int y, boolean couleur, Plateau plateau) {
        super(x, y, couleur, plateau);
    }

    @Override
    public String toString() {
        return "T";

    }

    @Override
    public boolean move() {


        return false;
    }
}
