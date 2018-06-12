package org.softuni.summerframework;

import java.lang.reflect.Method;

public class ControllerActionPair {
    Object controller;
    private Method method;

    public ControllerActionPair(Object controller, Method method) {
        this.controller = controller;
        this.method = method;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
