package org.softuni.broccolina.solet;

import org.softuni.javache.http.HttpStatus;

public abstract class BaseHttpSolet implements HttpSolet {
    private static final String NOT_FOUND_MESSAGE = "<h1>Error: %s NOT FOUND</h1>";

    @Override
    public void doGet(HttpSoletRequest request, HttpSoletResponse response) {
        response.setStatusCode(HttpStatus.NOT_FOUND);

        response.addHeader("Content-Type", "text/html");

        response.setContent(String.format(NOT_FOUND_MESSAGE,"Get Action").getBytes());
    }

    @Override
    public void doPost(HttpSoletRequest request, HttpSoletResponse response) {
        response.setStatusCode(HttpStatus.NOT_FOUND);

        response.addHeader("Content-Type", "text/html");

        response.setContent(String.format(NOT_FOUND_MESSAGE,"Post Action").getBytes());
    }

    @Override
    public void doPut(HttpSoletRequest request, HttpSoletResponse response) {
        response.setStatusCode(HttpStatus.NOT_FOUND);

        response.addHeader("Content-Type", "text/html");

        response.setContent(String.format(NOT_FOUND_MESSAGE,"Put Action").getBytes());
    }

    @Override
    public void doDelete(HttpSoletRequest request, HttpSoletResponse response) {
        response.setStatusCode(HttpStatus.NOT_FOUND);

        response.addHeader("Content-Type", "text/html");

        response.setContent(String.format(NOT_FOUND_MESSAGE,"Delete Action").getBytes());
    }
}
