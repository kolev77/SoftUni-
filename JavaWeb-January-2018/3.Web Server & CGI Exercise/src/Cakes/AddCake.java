package Cakes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddCake {
    public static void main(String[] args) {
        printForm();
        StringBuilder sb;
        Map<String, String> postParams = readAndValidateData();
        if (postParams == null) return;


        Cake cake = new Cake(postParams.get("cakeName"), Double.valueOf(postParams.get("cakePrice")));
        sb = new StringBuilder();
        sb.append(" <div id=\"cakeInfo\">\n" +
                "        <p>name: " + cake.getName() + " </p>\n" +
                "        <p>price: " + String.format("%.2f", cake.getPrice()) + "</p>\n" +
                "    </div>");

        Path path = Paths.get("./db.csv");
        if (Files.exists(path)) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(path.toString()));
                FileWriter fileWriter = new FileWriter("./db.csv", true);
                long id = reader.lines().count() + 1;
                fileWriter.append(id + " - " + cake.getName() + " - " + String.format("%.2f", cake.getPrice()) + System.lineSeparator());
                fileWriter.flush();
                reader.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PrintWriter pw = new PrintWriter(new File("db.csv"));
                pw.write(String.format("1 - %s - %.2f", cake.getName(), cake.getPrice()) + System.lineSeparator());
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sb.toString());
    }

    private static Map<String, String> readAndValidateData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();

        Map<String, String> postParams = createParameterMap(scanner.nextLine());

        if (!postParams.containsKey("create-cake-btn")) {
            System.out.println("You have to click the create button");
            return null;
        }
        return postParams;
    }

    private static void printForm() {
        StringBuilder sb = new StringBuilder();
        sb.append("Content-Type: text/html\r\n\r\n").append("<html>\r\n")
                .append(HtmlElements.HEADER_ELEMENT).append("<body>\r\n" +
                "<a href=\"/cgi-bin/menu.cgi\">Back to MENU</a>\n")
                .append("<form method=\"post\" action=\"/cgi-bin/addCake.cgi\">\n" +
                        "    <p>\n" +
                        "        Name: <input id=\"cakeName\"\n" +
                        "                     type=\"text\"\n" +
                        "                     name=\"cakeName\">\n" +
                        "        Price: <input id=\"cakePrice\"\n" +
                        "                      type=\"number\"\n" +
                        "                      step=\"0.01\"\n" +
                        "                      name=\"cakePrice\">\n" +
                        "        <input type=\"submit\" name=\"create-cake-btn\" value=\"Create\" style=\"position: absolute\">\n" +
                        "    </p>\n" +
                        "</form>");

        System.out.println(sb.toString());
    }

    static Map<String, String> createParameterMap(String params) {
        Map<String, String> requestParams = new HashMap<>();
        for (String pairString : params.split("&")) {
            String[] pair = pairString.split("=");
            requestParams.put(pair[0], pair[1]);
        }
        return requestParams;
    }
}

