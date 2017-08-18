import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostislav Kolev on 03-Jul-17.
 */
public class Person {
    private String name;
    private Integer age;
    private List<BankAccount> accounts;

    public Person(String name, Integer age) {
        this(name, age, new ArrayList<>());
    }

    public Person(String name, Integer age, List<BankAccount> accounts) {
        this.name = name;
        this.age = age;
        this.accounts = accounts;
    }

    public double getBalance() {
        return this.accounts.stream().mapToDouble(x -> x.getBalance()).sum();
    }
}
