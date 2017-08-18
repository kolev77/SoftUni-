package Exercises.PlayList.exceptions;

/**
 * Created by Rostislav Kolev on 10-Jul-17.
 */
public class InvalidSongSecondsException extends InvalidSongLengthException {
    public InvalidSongSecondsException(String message) {
        super(message);
    }
}
