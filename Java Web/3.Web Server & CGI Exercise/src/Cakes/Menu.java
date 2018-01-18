package Cakes;

public class Menu {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Content-Type: text/html\r\n\r\n");
        sb.append("<html>\r\n" +
                "<head> </head>\r\n" +
                "<header>\r\n"+
                "<h1>By The Cake</h1>" +
                "<h2>Enjoy our awesome cakes </h2>" +
                "<hr/>"+ "\r\n</header>");
        String homeMenu = "\r\n<body>\r\n"+
                "<ul>\n" +
                "    <li><a href=\"/cgi-bin/home.cgi\">Home</a></li>\n" +
                "        <ol>\n" +
                "            <li><a href=\"/cgi-bin/home.cgi/#cakes\">Our cakes</a></li>\n" +
                "            <li><a href=\"/cgi-bin/home.cgi/#stores\">Our stores</a></li>\n" +
                "        </ol>\n" +
                "    <li><a href=\"#\">Add cake</a></li>\n" +
                "    <li><a href=\"#\">Browse cakes</a></li>\n" +
                "    <li><a href=\"#\">About us</a></li>\n" +
                "</ul>\n"
                + "</body>\r\n";
        sb.append(homeMenu);
        sb.append("</html>");
        System.out.println(sb.toString());
    }
}
