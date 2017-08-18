import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Rostislav Kolev on 01-Jul-17.
 */
public class ComapreCharArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr1 = br.readLine().split(" ");
        String[] arr2 = br.readLine().split(" ");
        int length = Math.min(arr1.length, arr2.length);

        for (int i = 0; i < length; i++) {
            String letterOne = arr1[i];
            String letterTwo = arr2[i];
            int result = letterOne.compareTo(letterTwo);

            if (result < 0) {
                System.out.println(String.join("", Arrays.asList(arr1)));
                System.out.println(String.join("", Arrays.asList(arr2)));
                break;
            } else if (result > 0) {
                System.out.println(String.join("", Arrays.asList(arr2)));
                System.out.println(String.join("", Arrays.asList(arr1)));
                break;
            } else {
                if (arr1.length < arr2.length) {
                    System.out.println(String.join("", Arrays.asList(arr1)));
                    System.out.println(String.join("", Arrays.asList(arr2)));
                    break;
                } else if (arr1.length > arr2.length) {
                    System.out.println(String.join("", Arrays.asList(arr2)));
                    System.out.println(String.join("", Arrays.asList(arr1)));
                    break;
                } else {
                    System.out.println(String.join("", Arrays.asList(arr2)));
                    System.out.println(String.join("", Arrays.asList(arr1)));
                    break;
                }
            }
        }
    }
}
