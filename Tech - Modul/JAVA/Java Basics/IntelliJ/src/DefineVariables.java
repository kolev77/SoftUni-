public class DefineVariables {
    public static void main(String[] args) {
        int i = 5; double d = 3; // i is integer, d is double
        System.out.println(i + " ; " + d); // 5 ; 3.0
        d = i * d; d++; // d = 16.0
        System.out.println(d + 1); // 17.0

        String str = "Hello";
        str = str + " Java";
        System.out.printf("str = %s", str); // str = Hello Java

       // System.out.print(s); // Compilation error: unknown symbol s

    }
}
