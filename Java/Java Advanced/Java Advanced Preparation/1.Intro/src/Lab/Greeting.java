package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greeting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstName = br.readLine();
        String lastName = br.readLine();

        if (firstName.isEmpty()) {
            firstName = "*****";
        }

        if (lastName.isEmpty()) {
            lastName = "*****";
        }


        System.out.printf("Hello, %s %s!",firstName,lastName);
    }
}
