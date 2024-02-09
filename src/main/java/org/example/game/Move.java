package org.example.game;

public class Move {
    public static void printMenu(String[] moves) {
        if (moves.length <=7) {
            for (int i = 0; i < moves.length; i++) {
                System.out.println((i + 1) + " - " + moves[i]);
            }
        } else {
            for (int i = 0; i < 3; i++){
                System.out.println((i + 1) + " - " + moves[i]);
            }
            System.out.println("...");
            for (int i = moves.length - 4; i < moves.length; i++){
                System.out.println((i + 1) + " - " + moves[i]);
            }
        }
        System.out.println("0 - exit");
        System.out.println("? - help");
    }
}
