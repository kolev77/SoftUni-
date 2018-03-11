package org.softuni.main.casebook.handlers.dynamic;

import org.softuni.main.casebook.handlers.BaseHandler;
import org.softuni.main.javache.http.HttpRequest;
import org.softuni.main.javache.http.HttpResponse;
import org.softuni.main.javache.http.HttpSessionStorage;
import org.softuni.main.javache.http.HttpStatus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

abstract class BaseDynamicHandler extends BaseHandler {
    private static final String VIEWS_FULL_PATH =
            System.getProperty("user.dir")
                    + "\\src\\org\\softuni\\main\\casebook\\resources\\templates\\";

    private static final String VIEWS_EXTENSION = ".html";

    protected BaseDynamicHandler(HttpSessionStorage sessionStorage) {
        super(sessionStorage);
    }


    private byte[] getView(String viewName) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(VIEWS_FULL_PATH + viewName + VIEWS_EXTENSION));
            return bytes;
        } catch (IOException e) {
            return null;
        }
    }

    protected HttpResponse view(String view, HttpRequest request, HttpResponse response) {
        byte[] viewContent = this.getView(view);
        if (viewContent == null) {
            return this.notFound(request, response);
        }

        response.setStatusCode(HttpStatus.OK);
        response.addHeader("Content-Type", "text/html");
        response.setContent(viewContent);

        return response;
    }

    protected HttpResponse redirect(String location, HttpRequest request, HttpResponse response) {
        response.setStatusCode(HttpStatus.SEE_OTHER);
        response.addHeader("Location", location);

        return response;

    }
}
