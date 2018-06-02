import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class ArraySlider {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] numbers = readInput(br);
        int currentIndex = 0;
        String command = br.readLine();
        while (!command.equals("stop")) {
            String[] commandTokens = command.trim().split("\\s+");
            int offset = Integer.valueOf(commandTokens[0]);
            String operation = commandTokens[1];
            BigInteger secondNumber = new BigInteger(commandTokens[2]);


            switch (operation) {
                case "*":
                    currentIndex = multiply(currentIndex, numbers, offset, secondNumber);
                    break;
                case "/":
                    currentIndex = divide(currentIndex, numbers, offset, secondNumber);
                    break;
                case "-":
                    currentIndex = subtract(currentIndex, numbers, offset, secondNumber);
                    break;
                case "+":
                    currentIndex = add(currentIndex, numbers, offset, secondNumber);
                    break;
                case "&":
                    currentIndex = and(currentIndex, numbers, offset, secondNumber);
                    break;
                case "|":
                    currentIndex = or(currentIndex, numbers, offset, secondNumber);
                    break;
                case "^":
                    currentIndex = xor(currentIndex, numbers, offset, secondNumber);
                    break;
            }
            command = br.readLine();
        }
        System.out.println(Arrays.toString(numbers));
    }

    private static int or(int currentIndex, BigInteger[] numbers, int offset, BigInteger secondNumber) {
        currentIndex = getIndex(currentIndex, numbers, offset);
        numbers[currentIndex] = numbers[currentIndex].or(secondNumber);
        return currentIndex;
    }

    private static int xor(int currentIndex, BigInteger[] numbers, int offset, BigInteger secondNumber) {
        currentIndex = getIndex(currentIndex, numbers, offset);
        numbers[currentIndex] = numbers[currentIndex].xor(secondNumber);
        return currentIndex;
    }

    private static int and(int currentIndex, BigInteger[] numbers, int offset, BigInteger secondNumber) {
        currentIndex = getIndex(currentIndex, numbers, offset);
        numbers[currentIndex] = numbers[currentIndex].and(secondNumber);
        return currentIndex;
    }

    private static int add(int currentIndex, BigInteger[] numbers, int offset, BigInteger secondNumber) {
        currentIndex = getIndex(currentIndex, numbers, offset);
        numbers[currentIndex] = numbers[currentIndex].add(secondNumber);
        return currentIndex;
    }

    private static int subtract(int currentIndex, BigInteger[] numbers, int offset, BigInteger secondNumber) {
        currentIndex = getIndex(currentIndex, numbers, offset);
        numbers[currentIndex] = numbers[currentIndex].subtract(secondNumber);
        if (numbers[currentIndex].compareTo(BigInteger.valueOf(0)) < 0) {
            numbers[currentIndex] = BigInteger.valueOf(0);
        }

        return currentIndex;
    }

    private static int divide(int currentIndex, BigInteger[] numbers, int offset, BigInteger secondNumber) {
        currentIndex = getIndex(currentIndex, numbers, offset);
        numbers[currentIndex] = numbers[currentIndex].divide(secondNumber);
        return currentIndex;

    }

    private static int multiply(int currentIndex, BigInteger[] numbers, int offset, BigInteger secondNumber) {
        currentIndex = getIndex(currentIndex, numbers, offset);
        numbers[currentIndex] = numbers[currentIndex].multiply(secondNumber);
        return currentIndex;
    }

    private static int getIndex(int currentIndex, BigInteger[] numbers, int offset) {
        currentIndex = ((currentIndex + offset) % numbers.length >= 0 ?
                (currentIndex + offset) % numbers.length :
                numbers.length + (currentIndex + offset) % numbers.length);
        return currentIndex;
    }

    private static BigInteger[] readInput(BufferedReader br) throws IOException {
        String[] input = br.readLine().trim().split("\\s+");
        BigInteger[] numbers = new BigInteger[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new BigInteger(input[i]);
        }
        return numbers;
    }
}
