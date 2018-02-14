package Pieces;

import Game.*;


public class Cavalier extends Piece {
    public Cavalier(int x, int y, boolean couleur, Plateau plateau) {
        super(x, y, couleur, plateau);
    }



    @Override
    public boolean move() {
        return false;
    }

    @Override
    public String toString() {
        return "C";
    }
}
