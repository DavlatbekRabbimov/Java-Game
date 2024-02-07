package org.example.game;

import java.util.*;

public class GameRules {

    public static final Map<String, Set<String>> RULES_3 = new HashMap<>();
    static {
        RULES_3.put("rock", new HashSet<>(Arrays.asList("scissors")));
        RULES_3.put("paper", new HashSet<>(Arrays.asList("rock")));
        RULES_3.put("scissors", new HashSet<>(Arrays.asList("paper")));
    }

    public static final Map<String, Set<String>> RULES_5 = new HashMap<>();
    static {
        RULES_5.put("rock", new HashSet<>(Arrays.asList("scissors", "lizard")));
        RULES_5.put("paper", new HashSet<>(Arrays.asList("rock", "Spock")));
        RULES_5.put("scissors", new HashSet<>(Arrays.asList("paper", "lizard")));
        RULES_5.put("Spock", new HashSet<>(Arrays.asList("scissors", "rock")));
        RULES_5.put("lizard", new HashSet<>(Arrays.asList("Spock", "paper")));
    }

    public static final Map<String, Set<String>> RULES_7 = new HashMap<>();
    static {
        RULES_7.put("rock", new HashSet<>(Arrays.asList("scissors", "sponge")));
        RULES_7.put("paper", new HashSet<>(Arrays.asList("rock", "air")));
        RULES_7.put("scissors", new HashSet<>(Arrays.asList("paper", "water")));
        RULES_7.put("fire", new HashSet<>(Arrays.asList("scissors", "paper")));
        RULES_7.put("water", new HashSet<>(Arrays.asList("rock", "fire")));
        RULES_7.put("sponge", new HashSet<>(Arrays.asList("paper", "water")));
        RULES_7.put("air", new HashSet<>(Arrays.asList("fire", "rock")));
    }


    public static Map<String, Set<String>> getRules (String[] moves) {
        Map<String, Set<String>> rules;
        switch (moves.length){
            case 3:
                rules = GameRules.RULES_3;
                break;
            case 5:
                rules = GameRules.RULES_5;
                break;
            case 7:
                rules = GameRules.RULES_7;
                break;
            default:
                System.out.println("Invalid number of moves. Please enter 3, 5, or 7 moves.");
                return null;
        }
        return rules;
    };

}
