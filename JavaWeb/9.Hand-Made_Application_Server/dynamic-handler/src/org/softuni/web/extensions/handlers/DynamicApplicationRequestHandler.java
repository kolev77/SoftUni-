package org.softuni.web.extensions.handlers;

import org.softuni.javache.http.*;
import org.softuni.javache.lib.handler.AbstractRequestHandler;
import org.softuni.web.extensions.handlers.lib.Application;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class DynamicApplicationRequestHandler extends AbstractRequestHandler {

    private static final String APPLICATION_FOLDER = "apps";
    private Collection<Class<? extends Application>> applicationClasses;
    private final HttpSessionStorage sessionStorage;

    public DynamicApplicationRequestHandler(String serverPath) {
        super(serverPath);
        this.sessionStorage = new HttpSessionStorageImpl();
        this.applicationClasses = new ArrayList<>();
        this.applicationScan(this.serverPath + File.separator + APPLICATION_FOLDER);
    }

    @Override
    public byte[] handleRequest(String requestContent, String rootPath) {
        HttpContext context = new HttpContextImpl(new HttpRequestImpl(requestContent), new HttpResponseImpl());

        for (Class<? extends Application> applicationClass : applicationClasses) {
            try {
                ClassLoader appsClassLoader = new URLClassLoader(
                        new URL[]{
                                new File(this.serverPath + File.separator + APPLICATION_FOLDER).toURI().toURL(),
                                new File(this.serverPath + File.separator + "handlers").toURI().toURL()
                        }
                );
                Object instance = appsClassLoader.loadClass(applicationClass.getName()).getDeclaredConstructor().newInstance();
                byte[] response = (byte[]) Arrays.stream(instance.getClass().getDeclaredMethods()).filter(m -> m.getName()
                        .equalsIgnoreCase("handleRequest"))
                        .findFirst().get().invoke(instance, context);


                if (response != null) {
                    return response;
                }

            } catch (InstantiationException | IllegalAccessException
                    | InvocationTargetException | NoSuchMethodException |
                    ClassNotFoundException | MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void applicationScan(String path) {
        File folderCandidate = new File(path);
        for (File file : folderCandidate.listFiles()) {
            if (file.isDirectory()) {
                applicationScan(file.getPath());
            } else {
                if (file.getPath().endsWith(".class")) {
                    String fullPath = file.getPath();
                    String classPath = fullPath.substring(0, fullPath.lastIndexOf('.'))
                            .replace(this.serverPath + File.separator + APPLICATION_FOLDER + File.separator, "");
                    String className = classPath.replace(File.separatorChar, '.');
                    ClassLoader appsClassLoader = null;

                    try {
                        appsClassLoader = new URLClassLoader(
                                new URL[]{
                                        new File(this.serverPath + File.separator + APPLICATION_FOLDER).toURI().toURL(),
                                        new File(this.serverPath + File.separator + "handlers").toURI().toURL()
                                }
                        );
                    } catch (MalformedURLException e) {
                        appsClassLoader = ClassLoader.getSystemClassLoader();
                        e.printStackTrace();
                    }

                    try {
                        Class clazz = appsClassLoader.loadClass(className);
                        if (Arrays.stream(clazz.getInterfaces()).anyMatch(i -> i.getName().contains("Application"))) {
                            this.applicationClasses.add(clazz);
                        }
                    } catch (Exception e) {

                    }
                }
            }
        }
    }
}
