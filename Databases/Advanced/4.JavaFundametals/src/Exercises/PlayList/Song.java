package Exercises.PlayList;

import Exercises.PlayList.exceptions.*;

public class Song {
    private String artist;
    private String song;
    private Integer minutes;
    private Integer seconds;

    public Song(String artist, String song, String minutes, String seconds) {
        this.setArtist(artist);
        this.setSong(song);
        this.checkLength(minutes, seconds);
        this.setMinutes(Integer.valueOf(minutes));
        this.setSeconds(Integer.valueOf(seconds));

    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        if (artist.length() < 3 || artist.length() > 20) {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.artist = artist;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {

        if (song.length() < 3 || song.length() > 30) {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
        this.song = song;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        this.minutes = minutes;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        this.seconds = seconds;
    }

    private void checkLength(String minutes, String seconds) {
        try {
            int currentMin = Integer.parseInt(minutes);
            int currentSec = Integer.parseInt(seconds);

        } catch (NumberFormatException ex) {
            throw new InvalidSongLengthException("Invalid song length.");
        }
    }

}
