package NeedForSpeed.models;

import NeedForSpeed.models.cars.Car;
import NeedForSpeed.models.cars.PerformanceCar;
import NeedForSpeed.models.cars.ShowCar;
import NeedForSpeed.models.races.CasualRace;
import NeedForSpeed.models.races.DragRace;
import NeedForSpeed.models.races.DriftRace;
import NeedForSpeed.models.races.Race;

import java.util.*;
import java.util.stream.Collectors;

public class CarManager {
    private HashMap<Integer, Car> cars;
    private HashMap<Integer, Race> openedRaces;
    private Garage garage;

    public CarManager() {
        this.cars = new HashMap<>();
        this.openedRaces = new HashMap<>();
        this.garage = new Garage();
    }


    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        Car car = null;
        switch (type) {
            case "Performance":
                car = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
            case "Show":
                car = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
        }
        cars.putIfAbsent(id, car);
    }

    public String check(int id) {
        Car car = this.cars.get(id);
        return car.toString();
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        Race race = null;
        switch (type) {
            case "Casual":
                race = new CasualRace(length, route, prizePool, new ArrayList<>());
                break;
            case "Drift":
                race = new DriftRace(length, route, prizePool, new ArrayList<>());
                break;
            case "Drag":
                race = new DragRace(length, route, prizePool, new ArrayList<>());
                break;
        }
        openedRaces.put(id, race);
    }

    public void participate(int carId, int raceId) {
        Car car = cars.get(carId);
        Race race = openedRaces.get(raceId);
        List<Car> raceParticipants = race.getParticipants();
        raceParticipants.add(car);
        race.setParticipants(raceParticipants);
    }


    public String start(int id) {
        HashMap<Car, Integer> participants = null;
        Race race = openedRaces.get(id);
        if (!race.getParticipants().isEmpty() || !race.getParticipants().isEmpty() && race.getParticipants().size() < 3) {
            race.getParticipants().stream().forEach(c -> participants.put(c, 0));
            if (race instanceof DragRace) {
                participants.keySet().stream().map(p -> p.getEnginePerformance()).sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
                participants.keySet().stream().forEach(c -> participants.put(c, c.getEnginePerformance()));
            } else if (race instanceof DriftRace) {
                participants.keySet().stream().map(p -> p.getSuspensionPerformance()).sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
                participants.keySet().stream().forEach(c -> participants.put(c, c.getSuspensionPerformance()));
            } else if (race instanceof CasualRace) {
                participants.keySet().stream().map(p -> p.getOverallPerformance()).sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
                participants.keySet().stream().forEach(c -> participants.put(c, c.getOverallPerformance()));
            }


        } else {
            System.out.println("Cannot start the race with zero participants.");
        }
        StringBuilder builder = new StringBuilder();
        builder.append(race);
        int counter = 0;
        for (Car car : participants.keySet()) {
            switch (counter) {
                case 1:
                    builder.append(++counter + " ").append(car.get_brand() + " " + participants.get(car) + "PP - $" + (race.getPrizePool() * 50) / 100).append("\n");
                    break;
                case 2:
                    builder.append(++counter + " ").append(car.get_brand() + " " + participants.get(car) + "PP - $" + (race.getPrizePool() * 30) / 100);

                    break;
                case 3:
                    builder.append(++counter + " ").append(car.get_brand() + " " + participants.get(car) + "PP - $" + (race.getPrizePool() * 20) / 100);

                    break;
            }
        }
        return builder.toString();
    }

    public void park(int id) {
        Car car = cars.get(id);
        for (Race race : openedRaces.values()) {
            if (!race.getParticipants().contains(car)) {
                List<Car> parkedCars = garage.getParkedCars();
                parkedCars.add(car);
                garage.setParkedCars(parkedCars);
            }
        }
    }

    public void unpark(int id) {
        Car car = cars.get(id);
        if (garage.getParkedCars().contains(car)) {
            List<Car> parkedCars = garage.getParkedCars();
            parkedCars.remove(car);
            garage.setParkedCars(parkedCars);
        }
    }

    public void tune(int tuneIndex, String addOn) {
        List<Car> parkedCars = this.garage.getParkedCars();
        if (!parkedCars.isEmpty()) {
            for (Car parkedCar : parkedCars) {
                parkedCar.setHorsePower(parkedCar.getHorsePower() + 150);
                parkedCar.setSuspension(parkedCar.getSuspension() + 75);
                if (parkedCar instanceof ShowCar) {
                    ((ShowCar) parkedCar).setStars(((ShowCar) parkedCar).getStars() + tuneIndex);
                } else if (parkedCar instanceof PerformanceCar) {
                    List<String> addOns = ((PerformanceCar) parkedCar).getAddOns();
                    addOns.add(addOn);
                    ((PerformanceCar) parkedCar).setAddOns(addOns);
                }
            }
        }
    }
}
