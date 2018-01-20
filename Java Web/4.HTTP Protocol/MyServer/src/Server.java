import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Date;

public class Server {
    private int port;
    private ServerSocket server;

    public Server(int port) {
        this.port = port;
    }

    public void run() throws IOException {
        this.server = new ServerSocket(this.port);

        System.out.println("Listening on port: " + this.port);

        while (true) {
            Socket clientSocket = this.server.accept();

            BufferedReader requestStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            BufferedWriter responseStream = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            String line = "";

            while ((line = requestStream.readLine()) != null && line.length() > 0) {
                System.out.println(line);
            }

            StringBuilder responseContent=  new StringBuilder();
            responseContent.append("HTTP/1.1 200 OK").append(System.lineSeparator())
                    .append("Server: JAVACHE/-1").append(System.lineSeparator())
                    .append("Date : ").append(new Date()).append(System.lineSeparator())
                    .append("Content-type: text/html").append(System.lineSeparator())
                    .append("Content-Disposition: ")
                    .append(System.lineSeparator())
                    .append("<h1> Hello </h1>");

            responseStream.write(responseContent.toString());

            responseStream.close();
            requestStream.close();

        }

    }
}
