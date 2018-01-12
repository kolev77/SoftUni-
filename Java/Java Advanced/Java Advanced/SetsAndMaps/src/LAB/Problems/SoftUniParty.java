package LAB.Problems;

import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> regular = new HashSet<>();
        TreeSet<String> vip = new TreeSet<>();
        ArrayList<String> numbers = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        while (true) {
            String input = scanner.nextLine();
            if ("PARTY".equals(input)) {
                break;
            }
            if (numbers.contains(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }
        }

        while (true) {
            String guestsCame = scanner.nextLine();
            if ("END".equals(guestsCame)) {
                break;
            }
            if (numbers.contains(guestsCame.charAt(0))) {
                vip.remove(guestsCame);
            } else {
                regular.remove(guestsCame);
            }
        }
        vip.addAll(regular);
        System.out.println(vip.size());
        for (String s : vip) {
            System.out.println(s);
        }
    }
}
