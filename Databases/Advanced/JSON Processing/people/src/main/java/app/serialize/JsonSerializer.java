package app.serialize;

import app.io.FileIO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component(value = "JsonSerializer")
public class JsonSerializer implements Serializer {
    private Gson gson;

    @Autowired
    private FileIO fileIO;

    public JsonSerializer() {
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public <T> void serialize(T t, String fileName) {
        String json = gson.toJson(t);
        try {
        File f = new File(fileName);
        if (!f.exists()) {
            f.getParentFile().mkdirs();
            f.createNewFile();
        }
            fileIO.write(json, fileName);
        } catch (IOException e) {
            // log here
            throw new SerializeException(json + " was not serialised to " + fileName, e);
        }
    }

    @Override
    public <T> T deserialize(Class<T> classz, String fileName) {

        try {
         String json = fileIO.read(fileName);
            return gson.fromJson(json, classz);
        } catch (IOException e) {
            //log here
            throw new SerializeException(fileName+ " can not be read", e);
        }
    }
}
