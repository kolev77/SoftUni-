import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HighScore {
    public static void main(String[] args) throws IOException {
        Map<String, Player> players = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("osu!")) {
                break;
            }
            String[] duelInfo = input.split("<->");

            String[] player1info = duelInfo[0].split("\\s+");
            String[] player2info = duelInfo[1].split("\\s+");
            String player1Name = player1info[1];
            String player2Name = player2info[0];
            Integer player1DuelScore = Integer.valueOf(player1info[0]);
            Integer player2DuelScore = Integer.valueOf(player2info[1]);
            Player player1 = getPlayer(players, player1Name);
            Player player2 = getPlayer(players, player2Name);


            if (player1DuelScore > player2DuelScore) {
                Integer diff = player1DuelScore - player2DuelScore;
                player1.setScores(player1.getScores() + diff);
                player2.setScores(player2.getScores() - diff);
                addDuelsInfo(Math.abs(player1DuelScore - player2DuelScore), player1, player2);
            } else {
                Integer diff = player2DuelScore - player1DuelScore;
                player1.setScores(player1.getScores() - diff);
                player2.setScores(player2.getScores() + diff);
                addDuelsInfo(Math.abs(player1DuelScore - player2DuelScore), player2, player1);
            }
            players.put(player1Name, player1);
            players.put(player2Name, player2);

        }
        players.entrySet().stream()
                .sorted(Comparator.comparing(p -> -p.getValue().getScores()))
                .forEach(p -> System.out.println(p.getValue().toString()));
    }

    private static void addDuelsInfo(Integer diff, Player winner, Player loser) {
        List<String> winnerDuels = winner.getDuels();
        winnerDuels.add(String.format("*   %s <-> %d\n", loser.getName(), diff));
        winner.setDuels(winnerDuels);

        List<String> loserDuels = loser.getDuels();
        loserDuels.add(String.format("*   %s <-> %d\n", winner.getName(), -diff));
        loser.setDuels(loserDuels);
    }

    private static Player getPlayer(Map<String, Player> players, String playerName) {
        if (players.containsKey(playerName)) {
            return players.get(playerName);
        } else {
            return new Player(playerName);
        }
    }

    static class Player {
        private String name;
        private Integer scores;
        private List<String> duels;

        public Player(String name) {
            this.name = name;
            scores = 0;
            duels = new ArrayList<>();
        }

        public void setScores(Integer scores) {
            this.scores = scores;
        }

        public void setDuels(List<String> duels) {
            this.duels = duels;
        }

        public String getName() {
            return name;
        }

        public Integer getScores() {
            return scores;
        }

        public List<String> getDuels() {
            return duels;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s - (%d)\n", this.getName(), this.getScores()));

            for (String duel : duels) {
                sb.append(duel);
            }

            return sb.toString().trim();
        }
    }
}
