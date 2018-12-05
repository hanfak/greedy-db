package com.hanfak.greedydb.infrastructure.entrypoints.rest;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.http.HttpServlet;

// TODO add interface ??
public class JettyServletBuilder {

    private final ServletContextHandler servletHandler;
    private final JettyWebServer webServer;

    public JettyServletBuilder(ServletContextHandler servletHandler, JettyWebServer webServer) {
        this.servletHandler = servletHandler;
        this.webServer = webServer;
    }

    public JettyWebServer build() {
        return webServer.withContext(servletHandler);
    }

    // Make generic for servlet
    public JettyServletBuilder registerEndPoint(EndPoint endPoint, TestServlet testServlet) {
        addServlet(testServlet, endPoint);
        return this;
    }

    public JettyServletBuilder registerImportEmployerEndPoint(EndPoint endPoint, ImportEmployerServlet servlet) {
        addServlet(servlet, endPoint);
        return this;
    }

    private void addServlet(HttpServlet httpServlet, EndPoint endPoint) {
        servletHandler.addServlet(new ServletHolder(httpServlet), endPoint.path);
    }
}
