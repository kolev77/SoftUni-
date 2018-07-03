package org.softuni.summerframework;

import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.broccolina.solet.HttpSoletResponse;
import org.softuni.broccolina.solet.WebSolet;
import org.softuni.summerframework.stereotype.Controller;
import org.softuni.summerframework.stereotype.GetMapping;
import org.softuni.summerframework.stereotype.PostMapping;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@WebSolet(route = "/*", loadOnStartup = true)
public class DispatcherSolet extends GenericSolet {

    private Map<String, Map<String, ControllerActionPair>> routingTable;

    public DispatcherSolet() {
        this.routingTable = new HashMap<>();
        this.routingTable.put("GET", new HashMap<>());
        this.routingTable.put("POST", new HashMap<>());
        this.routingTable.put("PUT", new HashMap<>());
        this.routingTable.put("DELETE", new HashMap<>());
    }

    @Override
    public void init() {
        String appFolder = new File(DispatcherSolet.class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath()).getParent();

        try {
            this.loadLibraries(appFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }

        super.init();
    }

    private boolean isLibraryFile(File file) {
        return file.getName().endsWith(".jar");
    }

    private void loadLibrary(JarFile library, String canonicalPath) {
        Enumeration<JarEntry> fileEntries = library.entries();

        try {
            URL[] urls = {new URL("jar:file:" + canonicalPath + "!/")};
            URLClassLoader ucl = URLClassLoader.newInstance(urls);

            while (fileEntries.hasMoreElements()) {
                JarEntry currentFile = fileEntries.nextElement();

                if (currentFile.isDirectory()
                        || !currentFile.getName().endsWith(".class")) continue;

                String className = currentFile.getName()
                        .replace(".class", "")
                        .replace("/", ".");

                Class controllerClazz = ucl.loadClass(className);

                if (Arrays.stream(controllerClazz.getAnnotations()).anyMatch(a -> a.getClass().getName().endsWith("Controller"))) {
                    Object controllerInastance = controllerClazz.getDeclaredConstructor().newInstance();

                    Arrays.stream(controllerClazz.getDeclaredMethods())
                            .forEach(m -> {
                                if (m.isAnnotationPresent(GetMapping.class)) {
                                    this.routingTable.get("GET")
                                            .put(
                                                    m.getAnnotation(GetMapping.class).value(),          // try to get annotation`s value
                                                    new ControllerActionPair(controllerInastance, m)
                                            );

                                } else if (m.isAnnotationPresent(PostMapping.class)) {
                                    this.routingTable.get("POST")
                                            .put(
                                                    m.getAnnotation(GetMapping.class).value(),          // try to get annotation`s value
                                                    new ControllerActionPair(controllerInastance, m)
                                            );
                                }

                            });
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doGet(HttpSoletRequest request, HttpSoletResponse response) {
        this.dispatch(request, response, "GET");
    }


    public void doPost(HttpSoletRequest request, HttpSoletResponse response) {
        this.dispatch(request, response, "POST");

    }

    public void dispatch(HttpSoletRequest request, HttpSoletResponse response, String requestMethod) {
        try {
            ControllerActionPair pair = this.routingTable.get(requestMethod).get(request.getRequestUrl());
            Object controller = pair.getController();
            Method action = pair.getMethod();
            response.setContent(action.invoke(controller).toString().getBytes());

        } catch (Exception e) {
            response.setContent("Not found".getBytes());
        }


    }


    private void loadLibraries(String libFolderPath) throws IOException {
        File libDirectory = new File(libFolderPath);

        if (libDirectory.exists() && libDirectory.isDirectory()) {
            for (File file : libDirectory.listFiles()) {
                if (!this.isLibraryFile(file)) {
                    continue;
                }

                JarFile library = new JarFile(file.getCanonicalPath());
                this.loadLibrary(library, file.getCanonicalPath());
            }
        }
    }
}
