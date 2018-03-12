package org.softuni.main.casebook.handlers;

import org.softuni.main.javache.WebConstants;
import org.softuni.main.javache.http.*;

public abstract class BaseHandler {
    private static final String ERROR_400_MESSAGE = "Malformed request";
    private static final String ERROR_404_MESSAGE = " The page or resource you`re looking for is unavailable.";
    protected HttpSessionStorage httpSessionStorage;      // there might be a mistake

    protected final boolean isLoggedIn(HttpRequest request) {
        if (!request.getCookies().containsKey(WebConstants.SERVER_SESSION_TOKEN)) {
            return false;
        }

        HttpCookie cookie = request.getCookies().get(WebConstants.SERVER_SESSION_TOKEN);

        if (this.httpSessionStorage.getSession(cookie.getValue()) == null) {  // Check if server contains current session
            return false;
        }

        return true;
    }

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
