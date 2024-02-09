package org.example.game;

import java.util.*;

public class GameTable {
    private final List<String> moves;
    private final int columnWidth;
    private final Map<String, Set<String>> winningMoves;

    public GameTable(List<String> moves, Map<String, Set<String>> winningMoves) {
        this.moves = moves;
        this.columnWidth = Math.max(moves.stream()
                .mapToInt(String::length)
                .max()
                .orElse(5) + 2, 12);
        this.winningMoves = winningMoves;
    }

    public String getResult(String move1, String move2) {
        String spaces = String.format("%" + (columnWidth - 20) + "s", "");
        if (winningMoves.get(move1).contains(move2)) {
            return Color.ANSI_GREEN + "WIN " + spaces + Color.ANSI_RESET;
        } else if (move1.equals(move2)) {
            return Color.ANSI_YELLOW + "DRAW" + spaces + Color.ANSI_RESET;
        } else {
            return Color.ANSI_RED + "LOSE" + spaces + Color.ANSI_RESET;
        }
    }

    public void printTableForSelectedMoves(String... selectedMoves) {
        List<String> selectedMovesList = Arrays.asList(selectedMoves);
        printLine(selectedMovesList.size());
        printHeader(selectedMovesList);
        printLine(selectedMovesList.size());
        for (String move : selectedMovesList) {
            printRow(move, selectedMovesList);
            printLine(selectedMovesList.size());
        }
    }

    private void printLine(int size) {
        System.out.print("+");
        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < columnWidth; j++) {
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();
    }

    private void printHeader(List<String> moves) {
        System.out.print("|");
        System.out.printf("%-" + columnWidth + "s", "v PC\\User >");
        for (String move : moves) {
            System.out.printf("|%-" + columnWidth + "s", " " + move);
        }
        System.out.println("|");
    }

    private void printRow(String move, List<String> moves) {
        System.out.print("|");
        System.out.printf("%-" + columnWidth + "s", " " + move);
        for (String otherMove : moves) {
            System.out.printf("|%-" + columnWidth + "s", getResult(move, otherMove));
        }
        System.out.println("|");
    }
}
