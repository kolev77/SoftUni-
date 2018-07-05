package org.softuni.fdmc.servlets;

import org.softuni.fdmc.data.Cat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/cats/create")
public class CatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        String content = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Create Cat</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Create a Cat !</h1>\n" +
                "<div>\n" +
                "    <form action=\"/cats/create\" method=\"post\">\n" +
                "        Name: <input type=\"text\" name=\"name\"><br>\n" +
                "        Breed: <input type=\"text\" name=\"breed\"><br>\n" +
                "        Color: <input type=\"text\" name=\"color\"><br>\n" +
                "        Number of legs: <input type=\"number\" name=\"numberOfLegs\"><br>\n" +
                "        <input type=\"submit\" value=\"Create Cat\">\n" +
                "    </form>\n" +
                "\n" +
                "</div>\n" +
                "\n <br/>" +
                "<a href=\'/\'>Home</a>"
                +
                "</body>\n" +
                "</html>";


        writer.write(content);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cat> allCats = (List<Cat>) this.getServletContext().getAttribute("allCats");
        if (allCats == null) {
            allCats = new ArrayList<>();
        }
        Cat newCat = new Cat();
        newCat.setName(req.getParameter("name"));
        newCat.setBreed(req.getParameter("breed"));
        newCat.setColor(req.getParameter("color"));
        newCat.setNumberOfLegs(Integer.parseInt(req.getParameter("numberOfLegs")));
        allCats.add(newCat);

        this.getServletContext().setAttribute("allCats", allCats);

        resp.sendRedirect("/");
    }
}
