package Hiberspring.app.io;

import org.springframework.stereotype.Component;

import java.io.Writer;

@Component
public class ConsoleWriter implements Hiberspring.app.io.Writer {

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