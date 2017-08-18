package Exercises.NumberInReversedOrder;

public class DecimalNumber {
    private double value;

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String reverse() {
        Double currentNum = this.value;
        String reversed = "";
        String numToReverse = "";
        if (currentNum % 1 == 0) {
            numToReverse = String.valueOf(currentNum.intValue());
        } else {
            numToReverse = currentNum.toString();
        }

        for (int i = numToReverse.toString().length() - 1; i >= 0; i--) {
            reversed += numToReverse.split("")[i];
        }
        return reversed;
    }
}
