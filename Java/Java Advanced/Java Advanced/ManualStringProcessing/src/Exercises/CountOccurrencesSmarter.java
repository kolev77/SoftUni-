package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountOccurrencesSmarter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine().toLowerCase();
        String searchedWord = reader.readLine().toLowerCase();

        int occurrenceCount = 0;
        int lastInd = 0;

        while (true) {                                    // starts from (lastInd)and continue to the end of the string
            int concurrence = input.indexOf(searchedWord, lastInd);

            if (concurrence == -1)
                break;
            else
                occurrenceCount++;

            lastInd = concurrence + 1;
        }
        System.out.println(occurrenceCount);
    }
}
