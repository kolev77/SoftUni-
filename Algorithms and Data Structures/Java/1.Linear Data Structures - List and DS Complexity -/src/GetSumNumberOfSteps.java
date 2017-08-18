
public class GetSumNumberOfSteps {
    public static void main(String[] args) {


    }
    int GetSumEven(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] % 2 == 0) sum += array[i];
        return sum;
    }

}
