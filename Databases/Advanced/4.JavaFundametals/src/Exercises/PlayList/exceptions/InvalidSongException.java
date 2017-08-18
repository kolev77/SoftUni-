package Exercises.PlayList.exceptions;

/**
 * Created by Rostislav Kolev on 10-Jul-17.
 */
public class InvalidSongException extends RuntimeException {
    public InvalidSongException(String message) {
        super(message);
    }
}
