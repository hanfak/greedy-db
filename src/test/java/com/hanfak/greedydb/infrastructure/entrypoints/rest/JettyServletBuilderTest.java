package com.hanfak.greedydb.infrastructure.entrypoints.rest;

import com.hanfak.greedydb.infrastructure.entrypoints.rest.servlets.TestServlet;
import com.hanfak.greedydb.infrastructure.entrypoints.rest.webserver.JettyServletBuilder;
import com.hanfak.greedydb.infrastructure.entrypoints.rest.webserver.JettyWebServer;
import org.assertj.core.api.WithAssertions;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class JettyServletBuilderTest implements WithAssertions {
    private ServletContextHandler servletHandler = mock(ServletContextHandler.class);
    private JettyWebServer webServer = mock(JettyWebServer.class);
    private TestServlet servlet = mock(TestServlet.class);

    private final com.hanfak.greedydb.infrastructure.entrypoints.rest.webserver.JettyServletBuilder JettyServletBuilder = new JettyServletBuilder(servletHandler, webServer);
    
    @Test
    public void shouldAddServletHandlerToServerWhenBuilt() {
        JettyServletBuilder.registerEndPoint(EndPoint.get("/path"), servlet);
        JettyServletBuilder.build();

        verify(webServer).withContext(servletHandler);
    }
    
    @Test
    public void shouldAddServletToHandler() {
        JettyServletBuilder.registerEndPoint(EndPoint.get("/path"), servlet);

        verify(servletHandler).addServlet(any(ServletHolder.class), anyString());
    }
}

