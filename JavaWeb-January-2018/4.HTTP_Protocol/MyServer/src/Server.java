import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Server {
    private int port;
    private ServerSocket server;
    private HashMap<String, String> supportedContentType;

    public Server(int port) {
        this.port = port;
        this.supportedContentType = new HashMap<>();
        this.seedSupportedContentTypes();
    }

    private void seedSupportedContentTypes() {
        this.supportedContentType.put("png", "image/png");
        this.supportedContentType.put("jpg", "image/jpeg");
        this.supportedContentType.put("jpeg", "image/jpeg");
        this.supportedContentType.put("html", "text/html");
    }

    public void run() throws IOException {
        this.server = new ServerSocket(this.port);

        System.out.println("Listening on port: " + this.port);

        while (true) {
            Socket clientSocket = this.server.accept();

            BufferedReader requestStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream responseStream = new DataOutputStream(clientSocket.getOutputStream());
            StringBuilder requestContent = new StringBuilder();

            String line = "";

            while ((line = requestStream.readLine()) != null && line.length() > 0) {
                requestContent.append(line).append(" ");
            }

            byte[] requestResult = this.handleRequest(requestContent.toString());

            byte[] responseContent = this.constructResponse(requestContent.toString(), requestResult);

            responseStream.write(responseContent);

            responseStream.close();
            requestStream.close();

        }

    }

    private byte[] handleRequest(String requestContent) {
        String requestMethod = this.extractRequestMethod(requestContent);
        String requestResource = this.extractRequestResource(requestContent);


        if (requestMethod.equalsIgnoreCase("GET") && requestResource.length() > 1) {
            byte[] fileData = this.get(requestResource);
            return fileData;
        }
        return null;
    }

    private byte[] constructResponse(String requestContent, byte[] requestResult) {
        String resourceName = this.extractRequestResource(requestContent);
        String resourceExtension = resourceName.substring(resourceName.lastIndexOf(".") + 1);

        StringBuilder responseHeaders = new StringBuilder()
                .append("HTTP/1.1 200 OK").append(System.lineSeparator())
                .append("Server: Javache/-1.0.0").append(System.lineSeparator())
                .append("Date: ").append(new Date()).append(System.lineSeparator())
                .append("Content-Disposition: inline").append(System.lineSeparator())
                .append("Content-Length: ").append(requestResult.length).append(System.lineSeparator())
                    .append("Content-Type: ").append(this.getContentType(resourceExtension)).append(System.lineSeparator())
                    .append(System.lineSeparator());

        byte[] headerAsBytes = responseHeaders.toString().getBytes();
        byte[] fullResponseByteData = new byte[headerAsBytes.length + requestResult.length];

        for (int i = 0; i < headerAsBytes.length; i++) {
            fullResponseByteData[i] = headerAsBytes[i];
        }


        for (int i = 0; i < requestResult.length; i++) {
            fullResponseByteData[i + headerAsBytes.length] = requestResult[i];
        }

        return fullResponseByteData;

    }

    private String getContentType(String resourceExtension) {
        if (this.supportedContentType.containsKey(resourceExtension)) {
            return this.supportedContentType.get(resourceExtension);
        }
        return "text/html";
    }

    private byte[] get(String requestResource) {
        byte[] fileByteData = null;
        try {
            fileByteData = Files.readAllBytes(Paths.get("E:\\SoftUni\\SoftUni-\\JavaWeb\\4.HTTP_Protocol\\MyServer\\src\\resources\\" + requestResource.substring(1)));
        } catch (NoSuchFileException a ) {
            return ("File not found!").getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileByteData;
    }

    private String extractRequestMethod(String requestContent) {
        return requestContent.split("\\s+")[0];
    }


    private String extractRequestResource(String requestContent) {
        if (requestContent.split("\\s+").length < 2) {
            return requestContent;
        } else
            return requestContent.split("\\s+")[1];
    }
}
