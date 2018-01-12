package Exercises.FoodShortage;

public class Citizen implements Identifiable, Natality, Buyer {
    private String name;
    private int age;
    private String id;
    private String birthdate;
    private int food;

    public Citizen(String name, int age, String id, String birthdate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthdate = birthdate;
        this.food = 0;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }
}
