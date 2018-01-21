package Cakes;

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
                .append(HtmlElements.HEADER_ELEMENT).append("<body>\r\n")
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
        sb.append("<html>\r\n").append(HtmlElements.HEADER_ELEMENT).append(System.lineSeparator());
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

