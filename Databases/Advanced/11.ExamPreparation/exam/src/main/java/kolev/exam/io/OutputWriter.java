package kolev.exam.io;

import org.springframework.stereotype.Component;

public interface OutputWriter {
    void writeLine(String output);

    void writeLine(String format, Object... params);
}