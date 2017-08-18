package softuni.softuni.io;

import org.springframework.stereotype.Component;

import java.io.Writer;

@Component
public class ConsoleWriter implements softuni.softuni.io.Writer {

    public ConsoleWriter() {
    }

    @Override
    public void println(String content) {
        System.out.println(content);
    }

    @Override
    public void println(String format, Object... args) {
        System.out.println(String.format(format, args));
    }
}