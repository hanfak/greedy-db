package com.hanfak.greedydb.infrastructure.entrypoints.rest.servlets.importevent;

import com.hanfak.greedydb.core.domain.employer.Employer;
import com.hanfak.greedydb.core.usecases.addstreamevent.employer.ImportEmployerStreamEventUsecase;
import org.json.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

import static com.hanfak.greedydb.core.domain.employer.Employer.employer;
import static com.hanfak.greedydb.core.domain.employer.Id.id;
import static com.hanfak.greedydb.core.domain.employer.Name.name;
import static com.hanfak.greedydb.core.domain.employer.Surname.surname;
import static com.hanfak.greedydb.infrastructure.InputStreamReader.readInputStream;
import static java.lang.Long.parseLong;

//Test servlet
public class ImportEmployerServlet extends HttpServlet {

    // Create and pass in  unmarshaller
    private final ImportEmployerStreamEventUsecase importEmployerStreamEventUsecase;

    public ImportEmployerServlet(ImportEmployerStreamEventUsecase importEmployerStreamEventUsecase) {
        this.importEmployerStreamEventUsecase = importEmployerStreamEventUsecase;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Extract webservice which deals with request - unmarshalling, delegating to usecase,
        // creating content.
        // This should get actions from request and send contents of response
        // Extract json to object unmarshalling to class
        JSONObject jsonObject = new JSONObject(readInputStream(request.getInputStream()));

        Employer employer = employer(new Timestamp(jsonObject.getLong("timestamp")),
                id(parseLong(jsonObject.getString("id"))),
                name(jsonObject.getString("name")),
                surname(jsonObject.getString("surname")));

        importEmployerStreamEventUsecase.storeEvent(employer); // sad path, if throw exception??

        response.setStatus(204);
    }
}
