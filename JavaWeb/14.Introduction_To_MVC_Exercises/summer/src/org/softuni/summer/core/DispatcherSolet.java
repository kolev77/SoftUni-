package org.softuni.summer.core;

import org.softuni.broccolina.solet.BaseHttpSolet;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.broccolina.solet.HttpSoletResponse;
import org.softuni.broccolina.solet.WebSolet;

@WebSolet(route = "/*")
public class DispatcherSolet extends BaseHttpSolet {

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void service(HttpSoletRequest request, HttpSoletResponse response) {
        response.addHeader("Content-Type","text/html");
        response.setContent("Hello".getBytes());

        super.service(request, response);
    }


}
