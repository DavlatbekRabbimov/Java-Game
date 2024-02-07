package org.example.game;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class GameTable {
    private final String[] moves;
    private final int columnWidth;
    private final Map<String, Set<String>> winningMoves;

    public GameTable(String[] moves, Map<String, Set<String>> winningMoves) {
        this.moves = moves;
        this.columnWidth = Math.max(Arrays.stream(moves)
                .mapToInt(String::length)
                .max()
                .orElse(5) + 2, 16);
        this.winningMoves = winningMoves;
    }

    public void printTable() {
        printLine();
        printHeader();
        printLine();
        for (int i = 0; i < moves.length; i++) {
            printRow(i);
            printLine();
        }
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < moves.length + 1; i++) {
            for (int j = 0; j < columnWidth; j++) {
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();
    }

    private void printHeader() {
        System.out.printf("|%-" + (columnWidth) + "s", "v PC\\User >");
        for (String move : moves) {
            System.out.printf("|%-" + columnWidth + "s", " " + move);
        }
        System.out.println("|");
    }

    private void printRow(int i) {
        System.out.printf("|%-" + (columnWidth) + "s", " " + moves[i]);
        for (int j = 0; j < moves.length; j++) {
            System.out.printf("|%-" + (columnWidth + 11) + "s", colorResultUser(j, i));
        }
        System.out.println("|");
    }

    private String colorResultUser(int i, int j) {
        if (winningMoves.get(moves[i]).contains(moves[j])) {
            return "\033[0;32m Win\033[0m";
        } else if (moves[i].equals(moves[j])) {
            return "\033[0;33m Draw\033[0m";
        } else {
            return "\033[0;31m Lose\033[0m";
        }
    }

}


