package Exercises.PlayList.exceptions;

/**
 * Created by Rostislav Kolev on 10-Jul-17.
 */
public class InvalidArtistNameException extends InvalidSongException {
    public InvalidArtistNameException(String message) {
        super(message);
    }
}
