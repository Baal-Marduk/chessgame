package Pieces;
import Game.*;

public class Fou extends Piece {

    public Fou(int x, int y, boolean couleur, Plateau plateau) {
        super(x, y, couleur, plateau);
    }

    @Override
    public boolean move() {
        return false;
    }

    @Override
    public String toString() {
        return "F";
    }
}
/*
    public boolean isValidPath(int finalX, int finalY )
    {
        int x_diff = Math.abs(finalX - this.x);
        int y_diff = Math.abs(finalY - this.y);

        return x_diff == y_diff;
    }

    public int [][] drawPath(int startX, int startY, int finalX, int finalY)
    {
        int pairs = Math.abs(finalX - startX); //longueur du chemin

        int x_dir = 1, y_dir = 1; //détermine une direction
        if (finalX - startX < 0)
            x_dir = -1;
        if (finalY - startY <0)
            y_dir = -1;

        int [][] path = new int[2][pairs-1]; //remplissage du tableau de paires

        if (pairs-1 >0)
        {
            for (int i=0;i<pairs - 1;i++)
            {
                path[0][i]= startX + x_dir*1;
                path[0][i]= startY + y_dir*1;
            }
        }
        return path;
    }
}
