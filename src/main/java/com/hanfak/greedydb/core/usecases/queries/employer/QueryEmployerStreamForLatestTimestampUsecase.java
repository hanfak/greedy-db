package com.hanfak.greedydb.core.usecases.queries.employer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanfak.greedydb.core.domain.employer.Employer;
import com.hanfak.greedydb.core.usecases.EmployerStreamRepository;

public class QueryEmployerStreamForLatestTimestampUsecase {

    private EmployerStreamRepository employerStreamRepository;

    public QueryEmployerStreamForLatestTimestampUsecase(EmployerStreamRepository employerStreamRepository) {
        this.employerStreamRepository = employerStreamRepository;
    }

    public String queryEmployerStream(String jsonPath) {
        // Should this return what the vlaue of the column ie field. but will return different types
        // Solution: return object, and cast it here
        // Solution: use generic interface
        Employer latestTimestampEmployer = employerStreamRepository.findFieldForLatestTimestamp();
        // TODO: This json processing should be in infrastructure
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.valueToTree(latestTimestampEmployer);
        return jsonNode.get(jsonPath).asText();
    }
}
