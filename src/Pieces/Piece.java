package Pieces;

import Game.*;

public abstract class Piece {


    private int x, y;
    private boolean couleur;
    private String pieceType;
    private Plateau plateau;


    public Piece(int x, int y, boolean couleur, Plateau plateau) {
        setX(x);
        setY(y);
        setCouleur(couleur);
        this.plateau = plateau;
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

    public abstract boolean move();


}