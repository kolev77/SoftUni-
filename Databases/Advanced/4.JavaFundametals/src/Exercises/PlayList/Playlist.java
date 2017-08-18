package Exercises.PlayList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostislav Kolev on 10-Jul-17.
 */
public class Playlist {
    private List<Song> songs;


    public Playlist() {
        this.songs = new ArrayList<>();
    }

    public  void addSong(Song song) {
        this.songs.add(song);
        System.out.println("Song added.");
    }

    public String getSongsCount() {
        return "Songs added: " + this.songs.size();
    }

    public String getTotalPlaylistLength() {
        int minutes = 0;
        int seconds = 0;

        for (Song song : songs) {
            minutes += song.getMinutes();
            seconds += song.getSeconds();
        }

        int totalLength = (minutes * 60) + seconds; // all seconds
        int totalHours = totalLength / 60 / 60;
        int totalMin = (totalLength / 60) - (totalHours * 60);
        int totalSec = totalLength % 60;

        return String.format("Playlist length: %dh %dm %ds", totalHours, totalMin, totalSec);
    }
}
