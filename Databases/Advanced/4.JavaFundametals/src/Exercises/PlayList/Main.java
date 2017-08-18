package Exercises.PlayList;

import Exercises.PlayList.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Rostislav Kolev on 10-Jul-17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        Playlist playlist = new Playlist();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(";");
            String artist = input[0];
            String song = input[1];
            String minutes = input[2].split(":")[0];
            String seconds = input[2].split(":")[1];

            try {
                Song currentSong = new Song(artist, song, minutes, seconds);
                playlist.addSong(currentSong);
            }catch (InvalidSongException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println(playlist.getSongsCount());
        System.out.println(playlist.getTotalPlaylistLength());
    }
}
