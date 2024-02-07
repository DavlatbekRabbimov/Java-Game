package org.example;

import org.example.game.Game;

public class Main {
    public static void main(String[] args) {

        if (args.length < 3 || args.length % 2 == 0) {
            System.out.println("Error: wrong number of arguments. " +
                    "You should enter an odd number of arguments >= 3");
            return;
        }
        Game game = new Game(args);
        game.play();

    }
}
