package com.hanfak.greedydb.configuration;

import com.hanfak.greedydb.infrastructure.entrypoints.rest.JettyServletBuilder;
import com.hanfak.greedydb.infrastructure.entrypoints.rest.JettyWebServer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class ApplicationConfiguration {

    ServletContextHandler servletContextHandler() {
        return new ServletContextHandler();
    }

    JettyServletBuilder jettyWebServerBuilder() {
        return new JettyServletBuilder(servletContextHandler(), jettyWebServer());
    }

    JettyWebServer jettyWebServer() {
        return new JettyWebServer(new Server(1234));
    }
}
