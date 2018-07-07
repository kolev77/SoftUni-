package org.softuni.fdmc.servlets.home;

import org.softuni.fdmc.data.models.Order;
import org.softuni.fdmc.data.repos.CatRepository;
import org.softuni.fdmc.data.repos.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        this.getServletContext().setAttribute("cats", new CatRepository());
        this.getServletContext().setAttribute("users", new UserRepository());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository userRepository = (UserRepository) this.getServletContext().getAttribute("users");
        List<Order> orders = new ArrayList<>();
        userRepository.getAllUsers().stream().forEach(u ->
                u.getOrders().forEach(o -> orders.add(o))
        );
        this.getServletContext().setAttribute("allOrders", orders);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
