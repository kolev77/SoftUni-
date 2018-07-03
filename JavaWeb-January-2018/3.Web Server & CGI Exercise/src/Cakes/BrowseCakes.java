package Cakes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BrowseCakes {
    public static void main(String[] args) {
        printBrowseForm();
        List<Cake> cakes = importDatabase();
        Map<String, String> postParams = readAndValidateData();
        if (postParams == null) return;
        browse(cakes, postParams);

    }

    private static void browse(List<Cake> cakes, Map<String, String> postParams) {
        String searchedCake = postParams.get("cakeName").trim();
        cakes.stream().filter(c -> c.getName().contains(searchedCake)).forEach(c -> {
            System.out.println("<p> Name: " + c.getName() + " Price: " + String.format("%.2f", c.getPrice()) + "</p>" + System.lineSeparator());
        });
        System.out.println("</body>" + System.lineSeparator()
                + "</html>");
    }

    private static List<Cake> importDatabase() {
        List<Cake> cakes = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./db.csv"));
            String line = "";

            while ((line = reader.readLine()) != null) {
                String cakeName = line.split(" - ")[1];
                String cakePrice = line.split(" - ")[2];
                Cake cake = new Cake(cakeName, Double.valueOf(cakePrice));
                cakes.add(cake);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cakes;
    }

    private static void printBrowseForm() {
        StringBuilder sb = new StringBuilder();
        sb.append("Content-Type: text/html\r\n\r\n").append("<html>\r\n")
                .append(HtmlElements.HEADER_ELEMENT).append("<body>\r\n" +
                "<a href=\"/cgi-bin/menu.cgi\">Back to MENU</a>\n")
                .append("<form method=\"post\" action=\"/cgi-bin/browseCakes.cgi\">\n")
                .append("    <p>\n" +
                        "        Name: <input id=\"cakeName\"\n" +
                        "                     type=\"text\"\n" +
                        "                     name=\"cakeName\">\n")
                .append("        <input type=\"submit\" name=\"browse-cake-btn\"" +
                        " value=\"Search\" style=\"position: absolute\">\n")
                .append("    </p>\n" +
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

    private static Map<String, String> readAndValidateData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();

        Map<String, String> postParams = createParameterMap(scanner.nextLine());

        if (!postParams.containsKey("browse-cake-btn")) {
            System.out.println("You have to click the create button");
            return null;
        }
        return postParams;
    }
}
