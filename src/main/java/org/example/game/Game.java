package org.example.game;

import java.util.*;

public class Game {
    private final String[] moves;
    private final Scanner scanner = new Scanner(System.in);
    private final KeyGenerator keys;
    private final Map<String, Set<String>> winningMoves;

    public Game(String[] moves) {
        this.moves = moves;
        this.keys = new KeyGenerator();
        this.winningMoves = GameRules.getRules(moves);
    }
    public void play() {
        Set<String> selectedMoves = new LinkedHashSet<>();
        while (true) {
            int computerMove = keys.getRandom().nextInt(moves.length);
            byte[] key = keys.generateKey();
            String hmac = HmacGenerator.calculateHMAC(key, moves[computerMove]);
            System.out.println("HMAC: " + hmac);

            Move.printMenu(moves);

            System.out.print("Enter your move: ");
            String input = scanner.nextLine();

            if ("0".equals(input)) {
                System.out.println("Game closed!");
                break;
            } else if (input.startsWith("?")) {
                GameTable table = new GameTable(Arrays.asList(moves), winningMoves);
                table.printTableForSelectedMoves(selectedMoves.toArray(new String[0]));
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

            selectedMoves.add(moves[userMove]);
            if (selectedMoves.size() > 7) {
                Iterator<String> it = selectedMoves.iterator();
                it.next();
                it.remove();
            }

            System.out.println("USER move: " + moves[userMove]);
            System.out.println("COMPUTER move: " + moves[computerMove]);

            GameTable table = new GameTable(Arrays.asList(moves), winningMoves);
            System.out.println(table.getResult(moves[userMove], moves[computerMove]));

            System.out.println("HMAC key: " + HmacGenerator.bytesToHex(key) + "\n");
        }
    }

}


