package LAB.Exercises.Person;

public class Employee extends Person{
    private final static String DEFAULT_EMAIL = "n/a";
    private double salary;
    private String position;
    private String department;
    private String email;

    public Employee(String name,double salary,String position,String department){
        super(name);
        this.salary = salary;           //These fields are mandatory.
        this.position = position;
        this.department = department;
        this.email = DEFAULT_EMAIL;
    }

    public Employee(String name,double salary,String position,String department,String email){
        super(name);
        this.salary = salary;           //These fields are optional.
        this.position = position;
        this.department = department;
        this.email = email;
    }

    public Employee(String name,double salary,String position,String department,Integer age){
        super(name,age);
        this.salary = salary;           //These fields are optional.
        this.position = position;
        this.department = department;
        this.email = DEFAULT_EMAIL;
    }

    public Employee(String name,double salary,String position,String department,String email,Integer age){
        super(name,age);
        this.salary = salary;           //These fields are optional.
        this.position = position;
        this.department = department;
        this.email = email;
    }

    double getSalary(){

        return salary;
    }

    private String getEmail(){

        return email;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d",
                this.getName(),this.getSalary(),this.getEmail(),
                this.getAge());
    }
}
