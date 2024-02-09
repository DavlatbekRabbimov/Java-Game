package org.example;

import org.example.game.Game;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        if (args.length < 3 || args.length % 2 == 0) {
            System.out.println("Error: wrong number of arguments. " +
                    "You should enter an odd number of arguments >= 3");
            return;
        }

        Set<String> uniqueMoves = new HashSet<>(Arrays.asList(args));
        if (uniqueMoves.size() != args.length) {
            System.out.println("Error: duplicate moves. " +
                    "All moves should be unique.");
            return;
        }

        Game game = new Game(args);
        game.play();

    }
}
