package Game;

import Pieces.Piece;

public class Moteur {
    private Plateau plateau;
    private boolean isWhiteTurn;

    public Plateau getPlateau() {
        return plateau;
    }

    public Moteur() {
        this.plateau = new Plateau();
        this.isWhiteTurn = true;
    }

    public boolean checkMove(int x1, int y1, int x2, int y2) {
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
            if (x2 - x1 <= piece.move()[i][0] && y2 - y1 <= piece.move()[0][i]) {
                isReachable = true;
                choosenDirection = piece.move()[i];
                break;
            }
        }
        if (!isReachable) {
            return false;
        } else {
            if (piece.getPieceType().equals("cavalier")) {
                return true;
            } else if (piece.getPieceType().equals("pion")) {
                if ((piece.getCouleur() && x2 > x1) || ((!piece.getCouleur()) && x2 < x1)) {
                    return false;
                }
            } else {
                int tempX = choosenDirection[0];
                int tempY = choosenDirection[1];

                if (tempX == 0) {
                    if (y2 > y1) {
                        for (int i = y1 + 1; i < y1 - y2; i++) {
                            if (!(((Tiles) plateau.getLignes().get(x1).get(i)).getPiece() == null)) {
                                return false;
                            }
                        }
                    } else {
                        for (int i = y1 - 1; i > y1 - y2; i--) {
                            if (!(((Tiles) plateau.getLignes().get(x1).get(i)).getPiece() == null)) {
                                return false;
                            }
                        }
                    }
                } else if (tempY == 0) {
                    if (x2 > x1) {
                        for (int i = x1 + 1; i < x1 - x2; i++) {
                            if (!(((Tiles) plateau.getLignes().get(i).get(y1)).getPiece() == null)) {
                                return false;
                            }
                        }
                    } else {
                        for (int i = x1 - 1; i > x1 - x2; i--) {
                            if (!(((Tiles) plateau.getLignes().get(i).get(y1)).getPiece() == null)) {
                                return false;
                            }
                        }
                    }
                } else {
                    if (x2 > x1 && y2 > y1) {
                        for (int i = x1 + 1, j = y1 + 1; i < x1 - x2; i++, j++) {
                            if (!(((Tiles) plateau.getLignes().get(i).get(j)).getPiece() == null)) {
                                return false;
                            }
                        }
                    } else if (x2 > x1 && y2 < y1) {
                        for (int i = x1 + 1, j = y1 - 1; i < x1 - x2; i++, j--) {
                            if (!(((Tiles) plateau.getLignes().get(i).get(j)).getPiece() == null)) {
                                return false;
                            }
                        }
                    } else if (x2 < x1 && y2 < y1) {
                        for (int i = x1 - 1, j = y1 - 1; i < x1 - x2; i--, j--) {
                            if (!(((Tiles) plateau.getLignes().get(i).get(j)).getPiece() == null)) {
                                return false;
                            }
                        }
                    } else if (x2 < x1 && y2 > y1) {
                        for (int i = x1 - 1, j = y1 + 1; i < x1 - x2; i--, j++) {
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
        return true;
    }
}

