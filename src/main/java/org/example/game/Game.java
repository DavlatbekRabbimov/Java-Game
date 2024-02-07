package org.example.game;

import java.util.*;

public class Game {

    private final String[] moves;
    private final Scanner scanner = new Scanner(System.in);
    private final KeyGenerator keyGenerator;
    private final Map<String, Set<String>> winningMoves;

    public Game(String[] moves) {
        this.moves = moves;
        this.keyGenerator = new KeyGenerator();
        this.winningMoves = GameRules.getRules(moves);
    }

    public void play() {

        while (true) {

            int computerMove = keyGenerator.getRandom().nextInt(moves.length);
            byte[] key = keyGenerator.generateKey();
            String hmac = HmacGenerator.calculateHMAC(key, moves[computerMove]);

            System.out.println("HMAC: " + hmac);
            printMenu();

            System.out.print("Enter your move: ");
            String input = scanner.nextLine();

            if ("0".equals(input)) {
                System.out.println("Game closed!");
                break;
            } else if ("?".equals(input)) {
                GameTable table = new GameTable(moves, GameRules.getRules(moves));
                table.printTable();
                continue;
            }

            int userMove;
            try {
                userMove = Integer.parseInt(input) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            if (userMove < 0 || userMove >= moves.length) {
                System.out.println("Invalid input. Try again.");
                continue;
            }
            System.out.println("Your move: " + moves[userMove]);
            System.out.println("Computer move: " + moves[computerMove]);

            if (winningMoves.get(moves[userMove]).contains(moves[computerMove])) {
                System.out.println(Color.ANSI_GREEN + "WIN!" + Color.ANSI_RESET);
            } else if (moves[userMove].equals(moves[computerMove])) {
                System.out.println(Color.ANSI_YELLOW + "DRAW!" + Color.ANSI_RESET);
            } else {
                System.out.println(Color.ANSI_RED + "LOSE!" + Color.ANSI_RESET);
            }
            System.out.println("HMAC key: " + HmacGenerator.bytesToHex(key) + "\n");
        }
    }

    private void printMenu() {
        for (int i = 0; i < moves.length; i++) {
            System.out.println((i + 1) + " - " + moves[i]);
        }
        System.out.println("0 - exit");
        System.out.println("? - help");
    }

}

