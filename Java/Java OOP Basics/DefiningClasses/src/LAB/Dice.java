package LAB;

/**
 * Created by Rostislav Kolev on 07-Mar-17.
 */
public class Dice {
private static final int DEFAULT_SIDES = 6;
    private int sides;
    private int[] rollFreq;

    public Dice(){
        this.sides = DEFAULT_SIDES;
        this.rollFreq = new int[DEFAULT_SIDES];
    }

    public int getSides() {
        return sides;
    }

    public int[] getRollFreq(){
        return rollFreq;
    }
}
