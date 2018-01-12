package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        String first = data[0];
        String second = data[1];
        if (first != "" && second !="") {
            boolean checked = check(first, second);
            if (checked) {
                System.out.println("true");
            } else
                System.out.println("false");
        }

    }

    public static boolean check(String first, String second) {
        HashMap<Character, Character> chars = new HashMap<>();
        boolean iStrue = true;
        if (first.length() > second.length()) {
            for (int i = 0; i < second.length(); i++) {
                if (!chars.containsKey(second.charAt(i))) {
                    chars.put(second.charAt(i), first.charAt(i));
                } else {
                    if (chars.get(second.charAt(i)) != first.charAt(i)) {
                        iStrue = false;
                    }
                }
            }
            for (int i = second.length(); i < first.length(); i++) {
                for (Character character : chars.values()) {
                    if (character != first.charAt(i)) {
                        iStrue = false;
                    }else
                        iStrue=true;
                }
            }
        } else {
            for (int i = 0; i < first.length(); i++) {
                if (!chars.containsKey(first.charAt(i))) {
                    chars.put(first.charAt(i), second.charAt(i));
                } else {
                    if (chars.get(first.charAt(i)) != second.charAt(i)) {
                        iStrue = false;
                    }
                }
            }

            for (int i = first.length(); i < second.length(); i++) {
                for (Character character : chars.values()) {
                    if (character != second.charAt(i)) {
                        iStrue = false;
                    } else
                        iStrue= true;
                }
            }
        }
        return iStrue;
    }

}
