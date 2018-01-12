package OnlineRadioDatabase;

import OnlineRadioDatabase.Exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        Playlist playlist = new Playlist();

        for (int i = 0; i < n; i++) {
            String[] songArgs = br.readLine().split(";");
            try {
                Song song = new Song(songArgs[0], songArgs[1], songArgs[2]);
                System.out.println(playlist.addSong(song));
            }catch (InvalidSongException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(playlist);
    }
}
