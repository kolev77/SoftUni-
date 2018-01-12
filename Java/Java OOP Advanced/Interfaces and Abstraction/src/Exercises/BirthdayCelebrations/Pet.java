package Exercises.BirthdayCelebrations;

public class Pet implements Natality {
    private String name;
    private String birthdate;

    public Pet(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }
}
