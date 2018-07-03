package org.softuni.javache;

import org.softuni.javache.http.HttpSessionStorageImpl;
import org.softuni.javache.http.HttpSessionStorage;
import org.softuni.javache.util.RequestHandlerLoader;
import org.softuni.javache.util.ServerConfig;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server {
    private static final String LISTENING_MESSAGE = "Listening on port: ";

    private static final String TIMEOUT_DETECTION_MESSAGE = "Timeout detected!";

    private static final Integer SOCKET_TIMEOUT_MILLISECONDS = 5000;

    private RequestHandlerLoader requestHandlerLoader;

    private int port;

    private int timeouts;

    private ServerSocket server;

    private ServerConfig serverConfig;

    public Server(int port) {
        this.port = port;
        this.timeouts = 0;
        this.serverConfig = new ServerConfig();
        this.requestHandlerLoader = new RequestHandlerLoader();
        this.startLoadingProcess();
    }

    private void startLoadingProcess() {
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Loaded handlers");
                initializeRequestHandlers();
            }
        }, 0, 10, TimeUnit.SECONDS);
    }

    private void initializeRequestHandlers() {
        this.requestHandlerLoader.loadRequestHandlers();
    }

    public void run() throws IOException {
        this.server = new ServerSocket(this.port);
        this.serverConfig.loadConfig();

        System.out.println(LISTENING_MESSAGE + this.port);

        this.server.setSoTimeout(SOCKET_TIMEOUT_MILLISECONDS);

        HttpSessionStorage sessionStorage = new HttpSessionStorageImpl();

        while (true) {
            try (Socket clientSocket = this.server.accept()) {
                clientSocket.setSoTimeout(SOCKET_TIMEOUT_MILLISECONDS);

                ConnectionHandler connectionHandler
                        = new ConnectionHandler(clientSocket,
                        this.serverConfig.getRequestHandlersPriority(),
                        this.requestHandlerLoader.getLoadedRequestHandlers());

                FutureTask<?> task = new FutureTask<>(connectionHandler, null);
                task.run();
            } catch (SocketTimeoutException e) {
                System.out.println(TIMEOUT_DETECTION_MESSAGE);
                this.timeouts++;
            }
        }
    }
}