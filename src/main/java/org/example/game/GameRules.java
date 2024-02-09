package org.example.game;

import java.util.*;

public class GameRules {

    public static Map<String, Set<String>> getRules(String[] moves) {
        Map<String, Set<String>> rules = new HashMap<>();
        int n = moves.length;
        for (int i = 0; i < n; i++) {
            Set<String> beatMoves = new HashSet<>();
            for (int j = 1; j <= n / 2; j++) {
                beatMoves.add(moves[(i + j) % n]);
            }
            rules.put(moves[i], beatMoves);
        }
        return rules;
    }

}
