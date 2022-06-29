package com.tms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String user = servletContext.getInitParameter("db.user");
        String password= servletContext.getInitParameter("db.password");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context destroy");
    }
}
