package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ModifyBit {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);


        System.out.println(Integer.toBinaryString(2 << 0));
        System.out.println(Integer.toBinaryString(2 << 1));
        System.out.println(Integer.toBinaryString(2 << 2));
        System.out.println(Integer.toBinaryString(2 << 3));
        System.out.println(Integer.toBinaryString(2 << 4));
        System.out.println(Integer.toBinaryString(2 << 5));
    }
}
