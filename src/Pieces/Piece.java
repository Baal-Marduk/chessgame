package Pieces;

import Game.*;

public abstract class Piece {


    private int x, y;
    private boolean couleur;
    private String pieceType;
    private Plateau plateau;


    public Piece(int x, int y, boolean couleur) {
        setX(x);
        setY(y);
        setCouleur(couleur);
    }

    public String getPieceType() {
        return pieceType;
    }

    public void setPieceType(String pieceType) {
        this.pieceType = pieceType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCouleur(boolean couleur) {
        this.couleur = couleur;
    }

    public boolean getCouleur() {
        return couleur;
    }

    public abstract int [][] move();

    public String printAllData(){
        return("Type : " + this.pieceType + " Couleur :" + this.couleur + " X : " + this.x + " Y : " + this.y);
    }


}