package com.hanfak.greedydb.configuration;

import com.hanfak.greedydb.infrastructure.entrypoints.rest.TestServlet;
import com.hanfak.greedydb.infrastructure.entrypoints.rest.WebServer;

import static com.hanfak.greedydb.infrastructure.entrypoints.rest.EndPoint.get;

public class GreedyDb {

    private WebServer webServer;

    public static void main(String[] args) {
        new GreedyDb().start(new ApplicationConfiguration());
    }

    public void start(ApplicationConfiguration configuration) {
        startWebServer(configuration);
    }

    private void startWebServer(ApplicationConfiguration configuration) {
        webServer = configuration.jettyWebServerBuilder()
                .registerEndPoint(get("/test"), new TestServlet())
                .build();
        webServer.startServer();
    }

    // For testing only
    public void stop() {
        webServer.stopServer();
    }
}
