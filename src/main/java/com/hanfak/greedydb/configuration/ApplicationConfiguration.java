package com.hanfak.greedydb.configuration;

import com.hanfak.greedydb.core.domain.employer.Employer;
import com.hanfak.greedydb.core.usecases.EmployerStreamRepository;
import com.hanfak.greedydb.core.usecases.addstreamevent.employer.ImportEmployerStreamEventUsecase;
import com.hanfak.greedydb.infrastructure.dataprovider.database.EmployerStreamDataProvider;
import com.hanfak.greedydb.infrastructure.entrypoints.rest.servlets.importevent.ImportEmployerServlet;
import com.hanfak.greedydb.infrastructure.entrypoints.rest.webserver.JettyServletBuilder;
import com.hanfak.greedydb.infrastructure.entrypoints.rest.webserver.JettyWebServer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.util.ArrayList;
import java.util.List;

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

    ImportEmployerServlet importEmployerServlet() {
        return new ImportEmployerServlet(importEmployerStreamEventUsecase());
    }

    private ImportEmployerStreamEventUsecase importEmployerStreamEventUsecase() {
        return new ImportEmployerStreamEventUsecase(employerStreamDataProvider());
    }

    public EmployerStreamRepository employerStreamDataProvider() {
        return new EmployerStreamDataProvider(employerEvents());
    }

    // How to keep values in arraylist without newing it up
    private List<Employer> employerEvents() {
        return new ArrayList<>();
    }

    // new up unmarshaller
    // new up servlet pass in use case and unmarshaller
    // new up usecase, pass in repository
}
