package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class AdvertisementMessage {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        String[] events = new String[]{
                "Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "ry it yourself, I am very satisfied.",
                "I feel great!"
        };

        String[] phrases = new String[]{
                "Excellent product.", "Such a great product.",
                "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product."
        };

        String[] authors = new String[]{
                "Diana", "Petya", "Stella", "Elena",
                "Katya", "Iva", "Annie", "Eva"
        };

        String[] cities = new String[]{
                "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"
        };


        for (int i = 0; i < n; i++) {
            Integer rnd = Math.abs(new Random().nextInt());
            String phrase = phrases[rnd % (phrases.length-1)];
            String event = events[rnd % (events.length-1)];
            String author = authors[rnd % (authors.length -1 )];
            String city = cities[rnd % (cities.length-1)];

            System.out.printf("%s %s %s - %s",phrase,event,author,city);
            System.out.println();
        }
    }
}
