package app.serialize;

public interface Serializer {

    <T> void serialize(T t, String fileName);

    <T> T deserialize(Class<T> classz,String fileName);
}
