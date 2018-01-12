package OnlineRadioDatabase;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> songs;
    private int duration;

    public Playlist() {
        this.songs = new ArrayList<>();
        this.duration = 0;
    }

    public String addSong(Song song) {
        this.songs.add(song);
        this.duration += song.getDuration();

        return "Song added.";
    }

    private String getLength() {
        int hours = this.duration / 3600;
        int minutes = (this.duration - (hours * 3600)) / 60;
        int seconds = ((this.duration - hours * 3600) - minutes * 60);

        return String.format("Playlist length: %dh %dm %ds", hours, minutes, seconds);
    }

    @Override
    public String toString() {
        return String.format("Songs added: %d\n%s", this.songs.size(), this.getLength());
    }
}
