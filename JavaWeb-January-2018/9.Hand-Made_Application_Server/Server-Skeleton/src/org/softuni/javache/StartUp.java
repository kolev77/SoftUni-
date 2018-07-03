package org.softuni.javache;

import org.softuni.javache.lib.handler.AbstractRequestHandler;
import org.softuni.javache.lib.handler.RequestHandler;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;

public class StartUp {
    private static String rootPath;
    private static final String handlersFolder = "handlers";

    public static void main(String[] args) {
        rootPath = new File(StartUp.class.getProtectionDomain().getCodeSource().getLocation().getPath()).toString();
        start(args);
    }

    private static void start(String[] args) {
        int port = WebConstants.DEFAULT_SERVER_PORT;

        if (args.length > 1) {
            port = Integer.parseInt(args[1]);

        }
        Iterable<RequestHandler> handlers = requestHandlersScan(
                rootPath + File.separator + handlersFolder,
                new ArrayList<>());

        Server server = new Server(port, rootPath, handlers);

        try {
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Iterable<RequestHandler> requestHandlersScan(String path, Collection<RequestHandler> requestHandlers) {
        File folderCandidate = new File(path);
        for (File file : folderCandidate.listFiles()) {
            if (file.isDirectory()) {
                requestHandlersScan(file.getPath(), requestHandlers);
            } else {
                if (file.getPath().endsWith(".class")) {
                    String fullPath = file.getPath();
                    String classPath = fullPath.substring(0, fullPath.lastIndexOf('.'))
                            .replace(rootPath + File.separator + handlersFolder + File.separator, "");
                    String className = classPath.replace(File.separatorChar, '.');
                    ClassLoader handlersClassLoader = null;

                    try {
                        handlersClassLoader = new URLClassLoader(
                                new URL[]{
                                        new File(rootPath + File.separator + handlersFolder).toURI().toURL()
                                }
                        );
                    } catch (MalformedURLException e) {
                        handlersClassLoader = ClassLoader.getSystemClassLoader();
                        e.printStackTrace();
                    }

                    try {
                        Class clazz = handlersClassLoader.loadClass(className);
                        if (AbstractRequestHandler.class.isAssignableFrom(clazz)) {
                            RequestHandler handler = (AbstractRequestHandler) clazz.getDeclaredConstructor(String.class).newInstance(rootPath);
                            requestHandlers.add(handler);
                        } else if (RequestHandler.class.isAssignableFrom(clazz)) {
                            RequestHandler handler = (RequestHandler) clazz.getDeclaredConstructor().newInstance();
                            requestHandlers.add(handler);
                        }
                    } catch (ReflectiveOperationException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return requestHandlers;
    }
}
