package Game;

import Pieces.Piece;

public class Tiles {

    private String position;
    private int x;
    private int y;
    private boolean isOccupied;
    private Piece piece;


    public Tiles(int x, int y) {
        this.x = x;
        this.y = y;
        isOccupied = false;
        piece = null;
    }

    public Tiles(String position) {
        this.position = position;
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

    public String getPosition() {
        return position;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        if (piece == null) {
            isOccupied = false;
        } else {
            isOccupied = true;
        }
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        String valueToReturn = null;
        if (isOccupied) {
            return piece.toString();
        } else {
            valueToReturn = "" + (char) ('a' + x) + (y + 1);
        }
        return valueToReturn;
    }

    public void setPosition(String position) {
        this.position = position;
    }


}
