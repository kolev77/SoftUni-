package org.softuni.javache;

import org.softuni.javache.io.Reader;

import java.io.*;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

public class ConnectionHandler extends Thread {
    private Socket clientSocket;

    private String cachedInputStreamContent;

    private InputStream clientSocketInputStream;

    private OutputStream clientSocketOutputStream;

    private Map<String, RequestHandler> requestHandlers;

    private Set<String> requestHandlersPriority;

    public ConnectionHandler(Socket clientSocket, Set<String> requestHandlersPriority
            , Map<String, RequestHandler> requestHandlers) {
        this.requestHandlersPriority = requestHandlersPriority;
        this.initializeConnection(clientSocket);
        this.requestHandlers = requestHandlers;
    }

    private InputStream getClientSocketInputStream() throws IOException {
        if (this.cachedInputStreamContent == null) {
            this.cachedInputStreamContent = Reader.readAllLines(this.clientSocketInputStream);
        }
        return new ByteArrayInputStream(this.cachedInputStreamContent.getBytes());
    }

    private void initializeConnection(Socket clientSocket) {
        try {
            this.clientSocket = clientSocket;
            this.requestHandlersPriority = requestHandlersPriority;
            this.clientSocketInputStream = this.clientSocket.getInputStream();
            this.clientSocketOutputStream = this.clientSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            //HANDLE REQUEST
            this.processRequest();

            this.clientSocketInputStream.close();
            this.clientSocketOutputStream.close();
            this.clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processRequest() throws IOException {
        for (String requestHandlerName : this.requestHandlersPriority) {
            if (this.requestHandlers.containsKey(requestHandlerName)) {
                this.requestHandlers.get(requestHandlerName)
                        .handleRequest(this.getClientSocketInputStream(), this.clientSocketOutputStream);

                if (requestHandlers.get(requestHandlerName).hasIntercepted()) {
                    break;
                }
            }
        }
    }
}






