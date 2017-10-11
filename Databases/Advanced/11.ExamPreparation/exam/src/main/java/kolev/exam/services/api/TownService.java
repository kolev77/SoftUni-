package kolev.exam.services.api;

import kolev.exam.entities.Town;

public interface TownService {
    String add(Town town);
    Town findByName(String name);
}
