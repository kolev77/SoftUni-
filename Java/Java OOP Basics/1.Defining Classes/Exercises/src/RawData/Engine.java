package RawData;

public class Engine {
    private int speed;
    private int power;

    public Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }

    public int getSpeed() {
        return speed;
    }

    private void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    private void setPower(int power) {
        this.power = power;
    }
}
