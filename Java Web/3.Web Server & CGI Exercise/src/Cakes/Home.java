package Cakes;

public class Home {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Content-Type: text/html\r\n\r\n");
        sb.append("<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>CAKES</title>\n" +
                "</head>");
        sb.append("<body>\n" +
                "<h2>Home</h2>\n" +
                "<a href=\"/cgi-bin/menu.cgi\">Back to MENU</a>\n" +
                "<section>\n" +
                "    <h3 id=\"cakes\">Our cakes</h3>\n" +
                "    <p>Cake is a form of sweet dessert that is typically baked. In its oldest forms, cakes were modifications of breads, but cakes now cover a wide range of preparations that can be simple or elaborate, and that share features with other desserts such as pastries, meringues, custards, and pies</p>\n" +
                "<img src=\"/CakesImages/cake1.jpg\" alt=\"Cake image...\"width=\"600\" height=\"500\">"+
                "</section>\n" +
                "<section >\n" +
                "    <h3 id=\"stores\">Our stores</h3>\n" +
                "    <p>Our stores are located in 21 cities all over the world. Come and see what we have for you.</p>\n" +
                "<img src=\"/CakesImages/store.jpg\" alt=\"Store image...\"width=\"600\" height=\"500\">"+
                "</section>" +
                "</body>");
        System.out.println(sb.toString());
    }
}
