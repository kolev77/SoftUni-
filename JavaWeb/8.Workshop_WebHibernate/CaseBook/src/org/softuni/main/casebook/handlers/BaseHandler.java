package org.softuni.main.casebook.handlers;

import org.softuni.main.javache.http.HttpRequest;
import org.softuni.main.javache.http.HttpResponse;
import org.softuni.main.javache.http.HttpSessionStorage;
import org.softuni.main.javache.http.HttpStatus;

public abstract class BaseHandler {
    private static final String ERROR_400_MESSAGE = "Malformed request";
    private static final String ERROR_404_MESSAGE = " The page or resource you`re looking for is unavailable.";
    private HttpSessionStorage httpSessionStorage;

    protected BaseHandler(HttpSessionStorage sessionStorage) {
        this.httpSessionStorage = sessionStorage;
    }

    protected final HttpResponse badRequest(HttpRequest httpRequest, HttpResponse httpResponse) {
        httpResponse.setStatusCode(HttpStatus.BAD_REQUEST);
        httpResponse.addHeader("Content-Type", "text/html");
        httpResponse.setContent(("<h1>Error (" +
                HttpStatus.BAD_REQUEST.getStatusCode() +
                "): " + ERROR_400_MESSAGE + " </h1>")
                .getBytes());

        return httpResponse;
    }

    protected final HttpResponse notFound(HttpRequest httpRequest, HttpResponse httpResponse) {
        httpResponse.setStatusCode(HttpStatus.NOT_FOUND);
        httpResponse.addHeader("Content-Type", "text/html");
        httpResponse.setContent(("<h1>Error (" + HttpStatus.NOT_FOUND.getStatusCode()
                + "): " + ERROR_404_MESSAGE
                + " </h1>")
                .getBytes());

        return httpResponse;
    }
}
