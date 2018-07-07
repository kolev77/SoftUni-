package org.softuni.fdmc.data.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;

    private String password;

    private Role role;

    private List<Order> orders;

    public User(String username, String password) {
        this.orders = new ArrayList<>();
        this.setUsername(username);
        this.setPassword(password);
    }

    public User() {
        this.orders = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
