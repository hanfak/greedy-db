package com.hanfak.greedydb.configuration;

import com.hanfak.greedydb.infrastructure.entrypoints.rest.WebServer;
import com.hanfak.greedydb.infrastructure.entrypoints.rest.servlets.TestServlet;

import static com.hanfak.greedydb.infrastructure.entrypoints.rest.EndPoint.get;
import static com.hanfak.greedydb.infrastructure.entrypoints.rest.EndPoint.post;

public class GreedyDb {

    private WebServer webServer;

    public static void main(String[] args) {
        new GreedyDb().start(new ApplicationConfiguration());
    }

    public void start(ApplicationConfiguration configuration) {
        startWebServer(configuration);
    }
// extract out newing up of objects
    private void startWebServer(ApplicationConfiguration configuration) {
        webServer = configuration.jettyWebServerBuilder()
                .registerEndPoint(get("/test"), new TestServlet()) // remove
                .registerImportEmployerEndPoint(post("/import/employer"), configuration.importEmployerServlet())
                .build();
        webServer.startServer();
    }

    // For testing only
    public void stop() {
        webServer.stopServer();
    }
}
