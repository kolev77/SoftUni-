package AnimalFarm;

public class Chicken {
    private String name;
    private int age;


    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    public void setName(String name) {
        if (name.length() < 1 || name.charAt(0) == ' ') {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }


    public void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
        return calculateProductPerDay(this.age);
    }

    private double calculateProductPerDay(int age) {
        if (age < 6) {
            return 2;
        } else if (age < 12) {
            return 1;
        } else if (age < 15) {
            return 0.75;
        }
        return 0;
    }


    @Override
    public String toString() {
        if (this.productPerDay() < 1) {
            return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.name, this.age, this.productPerDay());
        } else
            return String.format("Chicken %s (age %d) can produce %.0f eggs per day.", this.name, this.age, this.productPerDay());
    }
}
