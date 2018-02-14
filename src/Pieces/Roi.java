package Pieces;
import Game.*;


public class Roi  extends Piece{
    public Roi(int x, int y, boolean couleur, Plateau plateau) {
        super(x, y, couleur, plateau);
    }

    @Override
    public boolean move() {
        return false;
    }

    @Override
    public String toString() {
        return "R";
    }
}
