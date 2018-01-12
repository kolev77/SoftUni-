package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("[\\s()/\\\\]");
        LinkedHashSet<String> validUsernames = new LinkedHashSet<>();

        Pattern pattern = Pattern.compile("^([a-zA-z]+[a-zA-Z0-9_]*){3,26}");
        for (int i = 0; i < input.length; i++) {
            Matcher matcher = pattern.matcher(input[i]);
            if (matcher.find()) {
                validUsernames.add(input[i]);
            }
        }
        String[] longestUsernames = new String[2];
        int maxSum = 0;

        for (int i = 0; i < validUsernames.size() - 1; i++) {
            String currentName = String.valueOf(validUsernames.toArray()[i]);
            String nextName = String.valueOf(validUsernames.toArray()[i + 1]);
            int currentSum = currentName.length() + nextName.length();
            if (currentSum > maxSum) {
                maxSum = currentSum;
                longestUsernames[0] = currentName;
                longestUsernames[1] = nextName;
            }
        }
        if (!longestUsernames[0].equals(null) && !longestUsernames[1].equals(null)) {
            for (int i = 0; i < longestUsernames.length; i++) {
                System.out.println(longestUsernames[i]);
            }
        }
    }
}
