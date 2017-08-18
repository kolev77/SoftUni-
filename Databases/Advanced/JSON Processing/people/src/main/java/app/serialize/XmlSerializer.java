package app.serialize;

import org.springframework.stereotype.Component;

@Component(value = "XmlSerializer")
public class XmlSerializer implements Serializer{
    @Override
    public <T> void serialize(T t, String fileName) {

    }

    @Override
    public <T> T deserialize(Class<T> classz, String fileName) {
        return null;
    }
}
