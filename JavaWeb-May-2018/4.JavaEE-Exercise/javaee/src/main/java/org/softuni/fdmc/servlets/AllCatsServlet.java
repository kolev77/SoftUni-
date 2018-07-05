package org.softuni.fdmc.servlets;

import org.softuni.fdmc.data.Cat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/cats/all")
public class AllCatsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        List<Cat> allCats = (List<Cat>) this.getServletContext().getAttribute("allCats");
        StringBuilder content = new StringBuilder();
        content.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>All Cats</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>All Cats</h1>\n" +
                "<br/>");

        if (allCats == null) {
            content.append("<h1>There are no cats ! <h1/><br/>")
                    .append("<a href=\"/cats/create\">Create some ! </a>\n");
        } else {
            for (Cat cat : allCats) {
                content.append("<a href=\"/cats/profile?catName=" + cat.getName() + "\">" + cat.getName() + "</a>");
                content.append("<br/>");
            }
        }
        content.append("<br/>" +
                "<a href=\'/\'>Home</a>"
                +
                "</body>\n" +
                "</html>");

        writer.write(content.toString());
    }
}
