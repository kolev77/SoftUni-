package Exercises;


import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();
        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("end")) {
                break;
            }

            String ip = input[0].split("=")[1];
            String user = input[2].split("=")[1];

            if (!users.containsKey(user)) {
                LinkedHashMap<String, Integer> userLogs = new LinkedHashMap<>();
                userLogs.put(ip, 1);
                users.put(user, userLogs);
            } else {
                if (users.get(user).containsKey(ip)) {
                    int value = users.get(user).get(ip) + 1;
                    users.get(user).put(ip, value);
                } else {
                    users.get(user).put(ip, 1);
                }
            }
        }
        for (String username : users.keySet()) {
            System.out.println(String.format("%s:", username));
            LinkedHashMap<String, Integer> userLogs = users.get(username);
            StringBuilder outputBuilder = new StringBuilder();
            for (String ip : userLogs.keySet()) {
                int logsCount = userLogs.get(ip);
                outputBuilder.append(String.format("%s => %d, ", ip, logsCount));
            }
            String output = outputBuilder.substring(0, outputBuilder.length() - 2);
            System.out.println(String.format("%s.", output));
        }
    }
}

