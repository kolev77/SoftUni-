package RawData;

public class Tire {
    private int ages;
    private double pressure;

    public Tire(int ages, double pressure) {
        this.ages = ages;
        this.pressure = pressure;
    }

    public int getAges() {
        return ages;
    }

    private void setAges(int ages) {
        this.ages = ages;
    }

    public double getPressure() {
        return pressure;
    }

    private void setPressure(double pressure) {
        this.pressure = pressure;
    }
}
