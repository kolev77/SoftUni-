package Exercises.PlayList.exceptions;

/**
 * Created by Rostislav Kolev on 10-Jul-17.
 */
public class InvalidSongNameException extends InvalidSongException {
    public InvalidSongNameException(String message) {
        super(message);
    }
}
