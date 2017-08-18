package Exercises.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> bag;


    public void setName(String name) {
        if (!name.isEmpty())
            this.name = name;
        else
            System.out.println("Name cannot be empty");
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setBag(List<Product> bag) {
        this.bag = bag;
    }

    public String getName() {
        return this.name;
    }

    public double getMoney() {
        return this.money;
    }

    public List<Product> getBag() {
        return this.bag;
    }
}
