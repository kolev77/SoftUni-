package Notes;

public class Methods {
    public static void main(String[] args) {
        printNumbers(2, 6);
        addOne(10);
        int a = plusOne(4);
        System.out.println("a + 1 = "+ a);
    }


    // Type void - does not return a value (only executes code)
    static void printNumbers(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " ");
        }
    }

    static void addOne(int n) {
        n += 1;
        System.out.println(n);
    }


   // Other types - return values, based on the return type of the method
    static int plusOne(int n){
        return n+1;
    }

}
