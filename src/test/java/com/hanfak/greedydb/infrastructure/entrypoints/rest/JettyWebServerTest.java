package com.hanfak.greedydb.infrastructure.entrypoints.rest;

import com.hanfak.greedydb.infrastructure.entrypoints.rest.webserver.JettyWebServer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class JettyWebServerTest {

    private final Server server = mock(Server.class);
    private final JettyWebServer webServer = new JettyWebServer(server);

    @Test
    public void shouldStartJettyServer() throws Exception {
        webServer.startServer();

        verify(server).start();
//        verify(server).addConnector(any());
    }

    @Test
    public void shouldLogExceptionIfJettyThrowsExceptionOnStartup() throws Exception {
        doThrow(new NullPointerException()).when(server).start();

        assertThatThrownBy(webServer::startServer)
                .isInstanceOf(Exception.class);
    }

    @Test
    public void shouldStopJettyServer() throws Exception {
        webServer.stopServer();

        verify(server).stop();
    }

    @Test
    public void shouldLogExceptionIfJettyThrowsExceptionOnShutdown() throws Exception {
        doThrow(new NullPointerException()).when(server).stop();

        assertThatThrownBy(webServer::stopServer)
                .isInstanceOf(Exception.class);
    }

    @Test
    public void shouldSetHandlerToJettyServer() {
        ServletContextHandler servletContextHandler = mock(ServletContextHandler.class);

        JettyWebServer jettyWebServer = webServer.withContext(servletContextHandler);

        assertThat(jettyWebServer).isInstanceOf(JettyWebServer.class);
        verify(server).setHandler(servletContextHandler);
    }
}