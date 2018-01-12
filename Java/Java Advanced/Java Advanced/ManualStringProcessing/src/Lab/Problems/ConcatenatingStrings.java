package Lab.Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConcatenatingStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String current = br.readLine();
            result.append(current + " ");
        }
        System.out.println(result);
    }
}
