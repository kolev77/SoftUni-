import java.lang.reflect.Array;

public class ContainsNumberOfSteps {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        System.out.println(Contains(array,5));

    }

    static boolean Contains(int[] array, int element)
    {
        for (int i = 0; i < array.length; i++)
            if (array[i] == element)
                return true;
        return false;
    }

}
