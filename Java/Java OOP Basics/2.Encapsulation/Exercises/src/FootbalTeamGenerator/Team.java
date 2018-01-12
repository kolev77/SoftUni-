package FootbalTeamGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    public Double getAverageSkill() {
        return this.getPlayers().stream().mapToDouble(Player::getOverallSkill).average().orElse(0);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        Player player = players.stream().filter(p -> p.getName().equals(playerName)).findAny().orElse(null);
        if (player == null) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.getName()));
        } else {
            this.players.remove(player);
        }
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    @Override
    public String toString() {
        return String.format("%s - %.0f", this.getName(), this.getAverageSkill());
    }
}
