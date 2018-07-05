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

@WebServlet("/cats/profile")
public class CatsProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String catName = req.getQueryString().split("=")[1].replace("%20", " ");
        List<Cat> allCats = (List<Cat>) this.getServletContext().getAttribute("allCats");
        Cat cat = allCats.stream().filter(c -> c.getName().equals(catName)).findFirst().orElse(null);
        StringBuilder content = new StringBuilder();
        content.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>");
        if (cat != null) {
            content.append("<h1>Cat - " + cat.getName() + "</h1>\n" +
                    "<hr/>\n" +
                    "<div>\n" +
                    "    <h2>Breed :" + cat.getBreed() + " </h2>\n" +
                    "</div>\n" +
                    "<div>\n" +
                    "    <h2>Color :" + cat.getColor() + "</h2>\n" +
                    "</div>\n" +
                    "<div>\n" +
                    "    <h2>Number of legs :" + cat.getNumberOfLegs() + "</h2>\n" +
                    "</div>");
        } else {
            content.append("<h1 style=\'red\'>Something went wrong ! </h1>");
        }

        content.append("<br/>" +
                "<a href=\'/\'>Back</a>"
                +
                "</body>\n" +
                "</html>");

        writer.write(content.toString());
    }
}
