package org.softuni.fdmc.servlets.cats;

import org.softuni.fdmc.data.models.Cat;
import org.softuni.fdmc.data.models.Role;
import org.softuni.fdmc.data.models.User;
import org.softuni.fdmc.data.repos.CatRepository;
import org.softuni.fdmc.data.repos.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cats/create")
public class CatsCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository userRepository = (UserRepository) this.getServletContext().getAttribute("users");
        User user = userRepository.getByUsername(req.getSession().getAttribute("username").toString());

        if (user.getRole().equals(Role.ADMIN))
            req.getRequestDispatcher("create.jsp").forward(req, resp);
        else
            resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        String color = req.getParameter("color");
        Integer numberOfLegs = Integer.parseInt(req.getParameter("numberOfLegs"));
        User creator = ((UserRepository) this.getServletContext().getAttribute("users")).getByUsername(req.getSession().getAttribute("username").toString());

        Cat cat = new Cat(name, breed, color, numberOfLegs, creator);
        cat.setViews(0);
        ((CatRepository) this.getServletContext().getAttribute("cats")).addCat(cat);

        resp.sendRedirect("/cats/profile?catName=" + cat.getName());
    }
}
