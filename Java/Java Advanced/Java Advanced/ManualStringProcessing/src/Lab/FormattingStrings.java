package Lab;

public class FormattingStrings {
    public static void main(String[] args) {
        String result = String.format("One: %1$d Two: %2$d", 10, 20);
        System.out.println(result);

        double number = 1.23456;
        String value = String.format("Precision 3: %1$.3f", number);
        System.out.println(value);

        //Padding
        String paddingValue = String.format("%1$-10s || %2$10s", 1.26, 5.55);
        System.out.println(paddingValue);
        //1.26       ||       5.55               '-' - right padding


    }
}
