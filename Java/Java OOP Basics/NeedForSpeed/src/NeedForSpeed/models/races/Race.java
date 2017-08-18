package NeedForSpeed.models.races;

import NeedForSpeed.models.cars.Car;

import java.util.List;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    protected Race(int length, String route, int prizePool, List<Car> participants) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = participants;
    }
    public int getPrizePool() {
        int prize = this.prizePool;
        return prize;
    }

    public List<Car> getParticipants() {
        List<Car> parts = this.participants;
        return parts;
    }

    public void setParticipants(List<Car> participants) {
        this.participants = participants;
    }


    private int getLength() {
        return this.length;
    }

    private String getRoute() {
        return this.route;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", getRoute(), getLength() );
    }
}
