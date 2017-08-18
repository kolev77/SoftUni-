package Exercises.PlayList.exceptions;

/**
 * Created by Rostislav Kolev on 10-Jul-17.
 */
public class InvalidSongMinutesException extends InvalidSongLengthException {
    public InvalidSongMinutesException(String message) {
        super(message);
    }
}
