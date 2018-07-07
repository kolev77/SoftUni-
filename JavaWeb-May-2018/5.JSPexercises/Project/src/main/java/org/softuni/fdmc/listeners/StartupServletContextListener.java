package org.softuni.fdmc.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartupServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("START");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("DESTROYED");
    }
}
