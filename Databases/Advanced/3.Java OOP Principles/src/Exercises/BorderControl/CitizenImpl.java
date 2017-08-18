package Exercises.BorderControl;

/**
 * Created by Rostislav Kolev on 07-Jul-17.
 */
public class CitizenImpl implements Citizen {
    private String id;
    private String name;
    private int age;

    public CitizenImpl(String id, String name, int age) {
        this.setId(id);
        this.setName(name);
        this.setAge(age);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
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
    public int getAge() {
        return this.age;
    }
}
