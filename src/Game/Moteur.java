package Game;

import Pieces.Piece;

import java.util.Scanner;

public class Moteur {
    private Plateau plateau;
    private boolean isWhiteTurn;
    public static boolean DEBUGMODE = true;

    public Plateau getPlateau() {
        return plateau;
    }

    public Moteur() {
        this.plateau = new Plateau();
        this.isWhiteTurn = true;
    }

    public boolean checkMove(int x1, int y1, int x2, int y2) {
        if (DEBUGMODE)
            System.out.println("CHECK MOVE STATUS :");
        Piece piece = plateau.getPieceFromPosition(x1, y1);
        if (piece == null) {
            System.out.println("Pas de pièces à cette coordonées");
            return false;
        }
        if (!(isWhiteTurn == piece.getCouleur())) {
            System.out.println("Joue avec tes pions enculé !");
            return false;
        }
        boolean isReachable = false;
        int[] choosenDirection = null;
        for (int i = 0; i < piece.move().length; i++) {
            if (DEBUGMODE)
                System.out.println("X2 - X1 :  " + Math.abs(x2 - x1) + " PIECE MOVE X : " + piece.move()[i][0] + " Y2 - Y1 " + Math.abs(y2 - y1) + " PIECE MOVE Y : " + piece.move()[i][1]);

            if ((Math.abs(x2 - x1) <= piece.move()[i][0]) && (Math.abs(y2 - y1) <= piece.move()[i][1])) {
                if ((Math.abs(x2 - x1) != Math.abs(y2 - y1) && piece.getPieceType().equals("fou"))) // Si les valeurs différentielles ne sont pas les même alors ce n'est pas un déplacement en diagonale
                    return false;

                isReachable = true;
                choosenDirection = piece.move()[i];
                break;
            }
        }
        if (DEBUGMODE)
            System.out.println("+ isReachable " + isReachable + " +");
        if (!isReachable) {
            return false;
        } else {
            if (DEBUGMODE)
                System.out.println("* is reachable * ");
            if (piece.getPieceType().equals("cavalier")) {
                if (DEBUGMODE)
                    System.out.println("* is a cavalier");
                return true;
            } else if (piece.getPieceType().equals("pion *")) {
                if (DEBUGMODE)
                    System.out.println("* is a pion");
                if ((piece.getCouleur() && x2 > x1) || ((!piece.getCouleur()) && x2 < x1)) {
                    return false;
                }
            } else {
                int tempX = choosenDirection[0];
                int tempY = choosenDirection[1];

                if (tempX == 0) {
                    if (y2 > y1) {
                        if (DEBUGMODE)
                            System.out.println("- iy2 > y1 -");
                        for (int i = y1 + 1; i < y1 - y2; i++) {
                            if (!(((Tiles) plateau.getLignes().get(x1).get(i)).getPiece() == null)) {
                                return false;
                            }
                        }
                    } else {
                        if (DEBUGMODE)
                            System.out.println("- iy2 =< y1 -");
                        for (int i = y1 - 1; i > y1 - y2; i--) {
                            if (!(((Tiles) plateau.getLignes().get(x1).get(i)).getPiece() == null)) {
                                return false;
                            }
                        }
                    }
                } else if (tempY == 0) {
                    if (x2 > x1) {
                        if (DEBUGMODE)
                            System.out.println("- x2 > x1 -");
                        for (int i = x1 + 1; i < x1 - x2; i++) {
                            if (!(((Tiles) plateau.getLignes().get(i).get(y1)).getPiece() == null)) {
                                return false;
                            }
                        }
                    } else {
                        if (DEBUGMODE)
                            System.out.println("- x2 <= x1 -");
                        for (int i = x1 - 1; i > x1 - x2; i--) {
                            if (!(((Tiles) plateau.getLignes().get(i).get(y1)).getPiece() == null)) {
                                return false;
                            }
                        }
                    }
                } else {
                    if (x2 > x1 && y2 > y1) {
                        if (DEBUGMODE)
                            System.out.println("- x2 > x1 && y2 > y1 -");
                        for (int i = x1 + 1, j = y1 + 1; i < x2; i++, j++) {
                            if (!(((Tiles) plateau.getLignes().get(i).get(j)).getPiece() == null)) {
                                return false;
                            }
                        }
                    } else if (x2 > x1 && y2 < y1) {
                        if (DEBUGMODE)
                            System.out.println("- x2 > x1 && y2 < y1 -");
                        for (int i = x1 + 1, j = y1 - 1; i < x2; i++, j--) {
                            if (!(((Tiles) plateau.getLignes().get(i).get(j)).getPiece() == null)) {
                                return false;
                            }
                        }
                    } else if (x2 < x1 && y2 < y1) {
                        if (DEBUGMODE)
                            System.out.println("- x2 < x1 && y2 < y1 -");
                        for (int i = x1 - 1, j = y1 - 1; i > x2; i--, j--) {
                            if (!(((Tiles) plateau.getLignes().get(i).get(j)).getPiece() == null)) {
                                return false;
                            }
                        }
                    } else if (x2 < x1 && y2 > y1) {
                        if (DEBUGMODE) {
                            System.out.println("- x2 < x1 && y2 > y1 -");
                            System.out.println("- i = x1 - 1 : " + (x1 - 1) + "\tj = y1 + 1 : " + (y1 + 1) + "-");

                        }
                        for (int i = x1 - 1, j = y1 + 1; i > x2; i--, j++) {
                            if (DEBUGMODE)
                                System.out.println((((Tiles) plateau.getLignes().get(i).get(j)).toString()) + " index : i,j : " + i + j);
                            if (!(((Tiles) plateau.getLignes().get(i).get(j)).getPiece() == null)) {
                                return false;
                            }
                        }
                    } else {
                        System.out.println("Vous ne pouvez pas vous deplacer sur vous même");
                        return false;
                    }
                }

            }
        }
        System.out.println("* Piece data : " + piece.printAllData() + " *");
        return true;
    }

    /**
     * Est responsable de la gestion des tours
     * Attends les instructions passé en ligne de commande
     */
    public void turn() {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        int ligne = (inputString.toCharArray()[0] - 'a');
        int colonne = (inputString.toCharArray()[1] - '1');
        int ligne2 = (inputString.toCharArray()[3] - 'a');
        int colonne2 = (inputString.toCharArray()[4] - '1');


        if (DEBUGMODE) {
            System.out.println("ligne : " + ligne + " colonne : " + colonne);
            System.out.println("ligne2 : " + ligne2 + " colonne2 : " + colonne2);
            System.out.println("## MOVE SUCESSFULL ? : " + this.checkMove(ligne, colonne, ligne2, colonne2) + " ##");
        }
        this.checkMove(ligne, colonne, ligne2, colonne2);


    }
}

