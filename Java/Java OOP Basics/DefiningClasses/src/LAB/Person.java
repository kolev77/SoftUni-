package LAB;

import LAB.BankAccountTestClient.BankAccountTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostislav Kolev on 07-Mar-17.
 */
public class Person {
    private String name;
    private int age;
    private List<BankAccountTest> accounts;

    public Person(String name, int age) {
        this(name, age, new ArrayList<>()); // constructor chaining
//        this.name = name;
//        this.age = age;
//        this.accounts = new ArrayList<>();
    }

    public Person(String name, int age, List<BankAccountTest> accounts) {
        this.name = name;
        this.age = age;
        this.accounts = accounts;
    }
}
