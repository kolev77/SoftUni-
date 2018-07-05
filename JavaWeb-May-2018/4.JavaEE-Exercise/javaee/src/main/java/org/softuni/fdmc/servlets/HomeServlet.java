package org.softuni.fdmc.servlets;

import org.softuni.fdmc.utils.HtmlReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String content = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Home</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Welcome to Fluffy Duffy Munchkin Cats!</h1>\n" +
                "<br/>\n" +
                "<h3>Navigate through the application using links below!</h3>\n" +
                "<hr/>\n" +
                "\n" +
                "<a href=\"/cats/create\">Create cat</a>\n" +
                "<a href=\"/cats/all\">All Cats</a>\n" +
                "</body>\n" +
                "</html>";

        writer.print(content);
    }
}
