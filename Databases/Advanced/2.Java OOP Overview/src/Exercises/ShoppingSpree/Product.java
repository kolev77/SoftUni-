package Exercises.ShoppingSpree;

public class Product {
    String name;
    Double cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty())
            this.name = name;
        else
            System.out.println("Name cannot be empty");
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        if (cost >= 0)
            this.cost = cost;
        else
            System.out.println("Money cannot be negative");
    }
}
