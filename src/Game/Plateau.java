package Game;


import Pieces.*;

import java.util.ArrayList;

public class Plateau {

    private ArrayList<ArrayList> lignes;


    // méthode to string pour afficher le tableau en console
    @Override
    public String toString() {
        String toPrint = "";
        for (int i = 0; i < lignes.size(); i++) {
            toPrint += "\n";
            for (int j = 0; j < lignes.get(i).size(); j++) {
                toPrint += lignes.get(i).get(j).toString() + "\t";
            }

        }
        return toPrint;
    }

    // création d'un tableau ayant pour coordonée de lignes x et colonnes y
    public Plateau() {

        lignes = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            ArrayList<Tiles> colonnes = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                //String position = "" + (char)('a' + i) + (j + 1);
                colonnes.add(new Tiles(i, j));
            }
            lignes.add(colonnes);
        }
        generationPlateau();
    }

    // création du plateau et attribution à chaque objet Tile d'un objet heritant de piece disposant de coordonnées et d'une couleur
    private void generationPlateau() {
        for (int i = 0; i < 8; i++) {

            ((Tiles) lignes.get(1).get(i)).setPiece(new Pion(1, i, false, this));
            ((Tiles) lignes.get(6).get(i)).setPiece(new Pion(6, i, true, this));
        }
        ((Tiles) lignes.get(0).get(0)).setPiece(new Tour(0, 0, false, this));
        ((Tiles) lignes.get(0).get(1)).setPiece(new Cavalier(0, 1, false, this));
        ((Tiles) lignes.get(0).get(2)).setPiece(new Fou(0, 2, false, this));
        ((Tiles) lignes.get(0).get(3)).setPiece(new Reine(0, 3, false, this));
        ((Tiles) lignes.get(0).get(4)).setPiece(new Roi(0, 4, false, this));
        ((Tiles) lignes.get(0).get(5)).setPiece(new Fou(0, 5, false, this));
        ((Tiles) lignes.get(0).get(6)).setPiece(new Cavalier(0, 6, false, this));
        ((Tiles) lignes.get(0).get(7)).setPiece(new Tour(0, 7, false, this));

        ((Tiles) lignes.get(7).get(0)).setPiece(new Tour(7, 0, true, this));
        ((Tiles) lignes.get(7).get(1)).setPiece(new Cavalier(7, 1, true, this));
        ((Tiles) lignes.get(7).get(2)).setPiece(new Fou(7, 2, true, this));
        ((Tiles) lignes.get(7).get(3)).setPiece(new Reine(7, 3, true, this));
        ((Tiles) lignes.get(7).get(4)).setPiece(new Roi(7, 4, true, this));
        ((Tiles) lignes.get(7).get(5)).setPiece(new Fou(7, 5, true, this));
        ((Tiles) lignes.get(7).get(6)).setPiece(new Cavalier(7, 6, true, this));
        ((Tiles) lignes.get(7).get(7)).setPiece(new Tour(7, 7, true, this));


    }

    public ArrayList<ArrayList> getLignes() {
        return lignes;
    }
}
//String.split to char array