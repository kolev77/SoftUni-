package Cakes;

public class Menu {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Content-Type: text/html\r\n\r\n");
        sb.append("<html>\r\n" +
                HtmlElements.HEADER_ELEMENT +
                "<hr/>");
        String homeMenu = "\r\n" +
                "<body>\r\n" +
                "<h1>By The Cake</h1>" +
                "<h2>Enjoy our awesome cakes </h2>" +
                "<ul>\n" +
                "    <li><a href=\"/cgi-bin/home.cgi\">Home</a></li>\n" +
                "        <ol>\n" +
                "            <li><a href=\"/cgi-bin/home.cgi/#cakes\">Our cakes</a></li>\n" +
                "            <li><a href=\"/cgi-bin/home.cgi/#stores\">Our stores</a></li>\n" +
                "        </ol>\n" +
                "    <li><a href=\"/cgi-bin/addCake.cgi\">Add cake</a></li>\n" +
                "    <li><a href=\"/cgi-bin/browseCakes.cgi\">Browse cakes</a></li>\n" +
                "    <li><a href=\"/cgi-bin/home.cgi/#about-us\">About us</a></li>\n" +
                "</ul>\n"
                + "</body>\r\n";
        sb.append(homeMenu);
        sb.append(HtmlElements.FOOTER_ELEMENT);
        sb.append("</html>");
        System.out.println(sb.toString());
    }
}
