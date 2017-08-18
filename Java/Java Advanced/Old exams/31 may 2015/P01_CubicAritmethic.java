import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class P01_CubicAritmethic {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int capacity = Integer.parseInt(reader.readLine());
        Queue<Queue<Integer>> bunkers = new ArrayDeque<>();
        Queue<Character> bunkerNames = new ArrayDeque<>();
        HashMap<Character, Integer> sums = new HashMap<>();
        StringBuilder outputBuilder = new StringBuilder();
        while (true) {
            String input = reader.readLine();
            if (input.equals("Bunker Revision")) {
                break;
            }

            String[] parts = input.split(" ");
            for (int i = 0; i < parts.length; i++) {
                char bunker = parts[i].charAt(0);
                if (!Character.isDigit(bunker)) {
                    bunkers.add(new ArrayDeque<>());
                    bunkerNames.add(bunker);
                    sums.put(bunker, 0);
                    continue;
                }
                int weapon = Integer.parseInt(parts[i]);
                int sum = sums.get(bunkerNames.peek());
                int leftSpace = capacity - sum;
                if (leftSpace >= weapon) {
                    bunkers.peek().add(weapon);
                    int newSum = sums.get(bunkerNames.peek()) + weapon;
                    sums.put(bunkerNames.peek(), newSum);
                } else if (bunkers.size() == 1 && weapon <= capacity) {
                    // make space
                    int valueToRemove = 0;
                    while (leftSpace < weapon) {
                        leftSpace += bunkers.peek().peek();
                        valueToRemove += bunkers.peek().poll();
                    }
                    bunkers.peek().add(weapon);
                    int newSum = sums.get(bunkerNames.peek()) - valueToRemove + weapon;
                    sums.put(bunkerNames.peek(), newSum);
                } else if (bunkers.size() > 1) {
                    outputBuilder.append(bunkerNames.poll());
                    outputBuilder.append(" -> ");
                    Queue<Integer> curr = bunkers.poll();
                    for (Integer weap : curr) {
                        outputBuilder.append(weap);
                        outputBuilder.append(", ");
                    }
                    if (curr.size() == 0) {
                        outputBuilder.append("Empty");
                    } else {
                        outputBuilder.setLength(outputBuilder.length() - 2);
                    }
                    outputBuilder.append(System.lineSeparator());
                    sum = sums.get(bunkerNames.peek());
                    leftSpace = capacity - sum;
                    if (leftSpace >= weapon) {
                        bunkers.peek().add(weapon);
                        int newSum = sums.get(bunkerNames.peek()) + weapon;
                        sums.put(bunkerNames.peek(), newSum);
                    }
                }
            }
        }

        System.out.print(outputBuilder);
    }
}