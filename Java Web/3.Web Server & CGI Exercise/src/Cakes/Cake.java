package Cakes;

public class Cake {
    private String name;
    private Double price;

    public Cake(String name, Double price) {
        setName(name);
        this.price = price;
    }

    private void setName(String input) {
        String[] name = input.split("\\+");
        if (name.length > 1) {
            this.name = name[0] + " " + name[1];
        } else {
            this.name = input;
        }
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
