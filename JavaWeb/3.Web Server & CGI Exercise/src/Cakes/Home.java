package Cakes;

public class Home {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Content-Type: text/html\r\n\r\n");
        sb.append("<html>\r\n").append(HtmlElements.HEADER_ELEMENT).append(System.lineSeparator())
                .append("<body>\r\n").append(
                "<h2>Home</h2>\n" +
                "<a href=\"/cgi-bin/menu.cgi\">Back to MENU</a>\n" +
                "<section>\n" +
                "    <h3 id=\"cakes\">Our cakes</h3>\n" +
                "    <p><strong><em>Cake</em></strong> is a form of <strong><em>sweet dessert</em></strong> that is typically baked." +
                " In its oldest forms, cakes were modifications of breads," +
                " but cakes now cover a wide range of" +
                " preparations that can be simple or elaborate, " +
                "and that share features with other desserts such as" +
                " pastries, meringues, custards, and pies</p>\n" +
                "<img src=\"/Resources/cake1.jpg\" alt=\"Cake image...\"width=\"600\" height=\"500\">\r\n" +
                "</section>\n" +
                "<section>\n" +
                "    <h3 id=\"stores\">Our stores</h3>\n" +
                "    <p>Our stores are located in 21 cities all over the world. Come and see what we have for you.</p>\n" +
                "<img src=\"/Resources/store.jpg\" alt=\"Store image...\"width=\"600\" height=\"500\">\r\n" +
                "</section>\r\n")
                .append("<h2 id=\"about-us\">About us</h2>")
                .append("<dl>\n" +
                        "    <dt>ByTheCake EOOD</dt>\n" +
                        "    <dd>Name of the company</dd>\n" +
                        "    <dt>Rostislav</dt>\n" +
                        "    <dd>Owner</dd>\n" +
                        "</dl>\n")
                .append("<pre style=\"background-color: #f94f80\">" +
                        "City: HongKong                City: Salzburg\n" +
                        "Address: ChoCoLad 18          Address: SchokoLeiden 73\n" +
                        "Phone: +78952804429           Phone: +49241432990\n" +
                        "</pre>\n");
        sb.append(HtmlElements.FOOTER_ELEMENT + "\r\n").append("</body>\r\n</html>");
        System.out.println(sb.toString());
    }
}
