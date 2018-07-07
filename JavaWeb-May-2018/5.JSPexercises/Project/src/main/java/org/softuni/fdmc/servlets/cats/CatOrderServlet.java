package org.softuni.fdmc.servlets.cats;

import org.softuni.fdmc.data.models.Cat;
import org.softuni.fdmc.data.models.Order;
import org.softuni.fdmc.data.models.User;
import org.softuni.fdmc.data.repos.CatRepository;
import org.softuni.fdmc.data.repos.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/cats/order")
public class CatOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String catName = req.getQueryString().split("=")[1];
        CatRepository catRepository = (CatRepository) this.getServletContext().getAttribute("cats");
        UserRepository userRepository = (UserRepository) this.getServletContext().getAttribute("users");
        User user = userRepository.getByUsername((String) req.getSession().getAttribute("username"));
        Cat orderedCat = catRepository.getByName(catName);
        orderedCat.setOrdered(true);
        catRepository.updateCat(orderedCat);
        Order order = new Order();
        order.setCat(orderedCat);
        order.setClient(user);
        order.setMadeOn(LocalDateTime.now());
        List<Order> orders = user.getOrders();
        orders.add(order);
        user.setOrders(orders);
        userRepository.updateUser(user);

        resp.sendRedirect("/cats/all");
    }
}
