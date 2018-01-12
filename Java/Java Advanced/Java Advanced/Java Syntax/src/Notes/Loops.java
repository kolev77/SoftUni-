package Notes;

/**
 * Created by Rostislav Kolev on 17-Jan-17.
 */
public class Loops {
    public static void main(String[] args) {

        //Do-While Loop
        int a = 5;
        do{
            System.out.println("Just writing...");
            a--;
        }
        while (a > 0);

        //While

        int counter = 1;
        while (counter <= 5) {
            System.out.printf("Number : %d\n", counter);
            counter++;
        }

        // For-Each Loop
        String[] days = { "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday", "Sunday" };
        for (String day : days) {
            System.out.println(day);
        }


    }
}
