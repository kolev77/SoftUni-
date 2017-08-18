package app.io;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileIO {
    public String read(String fileName) throws IOException {
        StringBuilder builder = new StringBuilder();

        InputStream inputStream = this.getClass().getResourceAsStream(fileName);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = br.readLine()) != null){
                builder.append(line);
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                //log here
            }
        }
        return builder.toString();
    }

    public void write(String content,String fileName) throws IOException {
        OutputStream outputStream = new FileOutputStream(fileName);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write(content);
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                //log here
            }
        }


    }
}
