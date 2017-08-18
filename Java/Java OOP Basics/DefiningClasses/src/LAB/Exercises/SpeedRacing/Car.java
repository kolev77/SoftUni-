package LAB.Exercises.SpeedRacing;

public class Car {
    private String carModel;
    private Double fuelAmout;
    private Double costPerKm;
    private int distanceTraveled;

    //Constructor
    public Car(String carModel, Double fuelAmout, Double costPerKm) {
        this.carModel = carModel;
        this.fuelAmout = fuelAmout;
        this.costPerKm = costPerKm;
    }

    //Methods

    public void drive(int km) {
        Double requiredFuel = km * costPerKm;
        if (this.fuelAmout - requiredFuel < 0) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            this.fuelAmout -= requiredFuel;
            this.distanceTraveled += km;
        }
    }


    //Getters
    public String getModel() {
        return carModel;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public Double getFuelAmout() {
        return fuelAmout;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", carModel, fuelAmout, distanceTraveled);
    }
}
