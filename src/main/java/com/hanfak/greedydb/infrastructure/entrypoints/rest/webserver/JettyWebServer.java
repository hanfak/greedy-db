package com.hanfak.greedydb.infrastructure.entrypoints.rest.webserver;

import com.hanfak.greedydb.infrastructure.entrypoints.rest.WebServer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import static java.lang.String.format;

public class JettyWebServer implements WebServer {

    private Server server;

    public JettyWebServer(Server server) {
        this.server = server;
    }

    @Override
    public void startServer() {
        try {
            server.start();
            //  System.out.println(server.getURI().toString()); // TODO add logger, instead of sout, and test
        } catch (Exception e) {
            throw new IllegalStateException(format("Could not startServer server on port '%d'", server.getURI().getPort()), e);
        }
    }

    @Override
    public void stopServer() {
        try {
            server.stop();
        } catch (Exception e) {
            throw new IllegalStateException(format("Could not stop server on port '%d'", server.getURI().getPort()), e);
        }
    }

    public JettyWebServer withContext(ServletContextHandler servletHandler) {
        server.setHandler(servletHandler);
        return this;
    }
}
