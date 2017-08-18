package Notes;

import java.math.BigDecimal;
import java.lang.Object;

/**
 * Created by Rostislav Kolev on 16-Jan-17.
 */
public class DataTypes {
    public static void main(String[] args) {

        // FLOAT, DOUBLE, INT, LONG
        float f = 0.33f;
        double d = 1.67;
        double sum = f + d;
        float Sum = f + (float)d; // This will not compile without (float)
        double infinity = 3.14 / 0;

        System.out.println(f); // 0.33
        System.out.println(d); // 1.67
        System.out.println(sum); // 2.000000013113022
        System.out.println(Sum); // 2.0
        System.out.println(infinity); // Infinity


        // BIG DECIMAL
        BigDecimal bigF = new BigDecimal("0.33");
        BigDecimal bigD = new BigDecimal("1.67");
        BigDecimal bigSum = bigF.add(bigD);
        System.out.println(bigSum); // 2.00


        // BOOLEAN
        boolean b = true;
        System.out.println(b); // true
        System.out.println(!b); // false

        // CHAR
        char ch = 'ю';
        System.out.println(ch);
        char ch2 = '\u03A9'; // Ω
        System.out.println(ch2);

        // OBJECT
        Object dataContainer = 5;
        System.out.print("The value of dataContainer is: ");
        System.out.println(dataContainer);
        dataContainer = "Five";
        System.out.print("The value of dataContainer is: ");
        System.out.println(dataContainer);

        // Nullable Types: Integer, Long, Boolean
        //Each primitive type in Java has a corresponding wrapper:

        // int  java.lang.Integer
        // double  java.lang.Double
        // boolean  java.lang.Boolean

        //Primitive wrappers can have a value or be null (no value)

        Integer i = 5; // Integer value: 5
        System.out.printf("i = %d  ",i);
        i = i + 1; // Integer value: 6
        System.out.printf("i = %d  ",i);
        i = null; // No value (null)
        System.out.printf("i = %d  ",i);
         //   i = i + 1; // NullPointerException
         //   System.out.printf("i = %d",i);


        // Type Conversion
        // Type conversion and typecasting change one type to another

        // Java supports Explicit type conversion (casting)

        float heightInMeters = 1.74f; // Explicit conversion
        double minHeight = (double) heightInMeters; // Explicit
        byte dataLoss = (byte) 12345; // Explicit with data loss

        double maxHeight = heightInMeters; // Implicit

        System.out.println("\n" + heightInMeters + " (float)");
        System.out.println(minHeight + " (double)");
        System.out.println(dataLoss + "  - > 12345 (byte)");
        System.out.println(maxHeight + "  (double) Implicit conversion ");


    }
}
