package Game;

public class Launcher2 {
    public static void main(String[] args){
//        Plateau plateau = new Plateau();
//        System.out.println(plateau.toString());
//
//
//        System.out.println( plateau.getPieceFromPosition(1,1).toString());

        Moteur moteur = new Moteur();

        System.out.println(moteur.getPlateau().toString());
        System.out.println(moteur.checkMove(6,0,6,1));
        System.out.println(moteur.checkMove(7,2,4,1));
        moteur.turn();

    }


}