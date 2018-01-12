package Person;

public class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        setName(name);
        setAge(age);
    }

    protected void setName(String name) {
        if (name.length() < 3 ){
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        this.name = name;
    }

    protected void setAge(Integer age) {
        if (age <0){
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s, Age: %d",
                this.getName(),
                this.getAge()));

        return sb.toString();
    }

}
