package Exercises;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> playersAndCards = new LinkedHashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if ("JOKER".equals(input)) {
                break;
            } else {
                String[] data = input.split(":");
                String name = data[0];
                String[] cards = data[1].trim().split(", ");
                HashSet<String> currentDeck = new HashSet<>();

                if (playersAndCards.get(name) != null)
                    currentDeck = playersAndCards.get(name);
                else
                    playersAndCards.put(name, currentDeck);

                for (int i = 0; i < cards.length; i++)
                    currentDeck.add(cards[i]);

                playersAndCards.put(name, currentDeck);
            }
        }

        for (String player : playersAndCards.keySet()) {
            String[] scores = new String[playersAndCards.get(player).size()];
            Object[] scor = playersAndCards.get(player).toArray();
            for (int i = 0; i < scores.length; i++) {
                scores[i] = scor[i].toString();
            }
            int totalScores = getScores(scores);
            System.out.println(player + ": " + totalScores);

        }
    }

    public static int getScores(String[] scores) {
        int totalScores = 0;
        String power = "";
        String type = "";
        String cardsFrom2to10 = "2345678910";
        for (int i = 0; i < scores.length; i++) {
            String[] card = scores[i].trim().split("");
            if (card.length == 3) {
                power = card[0] + card[1];
                type = card[2];
            }
            else {
                power = card[0];
                type = card[1];
            }
            int thePower = 0;
            int multiplier = 0;
            if ("S".equals(type)) {
                multiplier = 4;
            } else if ("H".equals(type)) {
                multiplier = 3;
            } else if ("D".equals(type)) {
                multiplier = 2;
            } else if ("C".equals(type)) {
                multiplier = 1;

            }
            if (cardsFrom2to10.contains(power)) {
                thePower = Integer.valueOf(power);
            } else {
                if ("J".equals(power)) {
                    thePower = 11;
                } else if ("Q".equals(power)) {
                    thePower = 12;
                } else if ("K".equals(power)) {
                    thePower = 13;
                } else if ("A".equals(power)) {
                    thePower = 14;
                }
            }
            totalScores += thePower * multiplier;
        }
        return totalScores;
    }
}
