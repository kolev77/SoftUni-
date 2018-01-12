package Exercises;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class StringLength {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder(br.readLine());
        result.append(new String(new char[20 - result.length()]).replace("\0", "*"));
        System.out.println(result);
    }
}
