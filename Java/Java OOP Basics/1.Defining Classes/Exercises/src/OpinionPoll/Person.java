package OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Stream;

public class Person {
    private String name;
    private int age;
    public Person() {
        this.name = "No name";
        this.age= 1;
    }

    public Person(int age) {
        this();
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) throws IOException {
        HashMap<Integer,Person> db = new HashMap<>();
        int count = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");
            Person person = new Person(input[0],Integer.valueOf(input[1]));
            db.put(count++,person);
        }

        db.entrySet().stream()
                .filter(x->x.getValue().getAge() >30)
                .sorted(Comparator.comparing(x -> x.getValue().getName()))
                .forEach(x-> System.out.println(x.getValue().getName()+ " - "+ x.getValue().getAge()));
    }
}


//