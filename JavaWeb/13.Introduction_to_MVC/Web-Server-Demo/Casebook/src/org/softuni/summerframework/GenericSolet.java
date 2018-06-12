package org.softuni.summerframework;

import org.softuni.broccolina.solet.BaseHttpSolet;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.broccolina.solet.HttpSoletRequestImpl;
import org.softuni.broccolina.solet.HttpSoletResponse;

public class GenericSolet extends BaseHttpSolet {
    private boolean initialized;


    @Override
    public void init() {
        this.initialized = true;
    }

    @Override
    public boolean isInitialized() {
        return this.initialized;
    }

    @Override
    public void service(HttpSoletRequest httpSoletRequest, HttpSoletResponse httpSoletResponse) {


        if (httpSoletRequest.getMethod().equals("GET")) {
            this.doGet(httpSoletRequest, httpSoletResponse);
        } else if (httpSoletRequest.getMethod().equals("POST")) {
            this.doPost(httpSoletRequest, httpSoletResponse);
        } else if (httpSoletRequest.getMethod().equals("PUT")) {
            this.doPut(httpSoletRequest, httpSoletResponse);
        } else if (httpSoletRequest.getMethod().equals("DELETE")) {
            this.doDelete(httpSoletRequest, httpSoletResponse);
        }
    }
}
