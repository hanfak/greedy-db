package acceptancetests;

import com.hanfak.greedydb.core.domain.employer.Employer;
import com.hanfak.greedydb.core.usecases.EmployerStreamRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EmployerStreamTestRepository implements EmployerStreamRepository {

    protected static final List<Employer> employerEvents = new ArrayList<>();

    public Employer findEvent() {
        int size = employerEvents.size();
        System.out.println("size = " + size);
        return employerEvents.get(0);
    }

    @Override
    public void storeEventInStream(Employer employer) {
        employerEvents.add(employer);
    }

    @Override
    public Object findFieldForGivenTimestamp(Timestamp timestamp, String jsonPath) {
        return null;
    }

    @Override
    public Object findFieldForLatestTimestamp(String jsonPath) {
        return null;
    }

    // Do I need
    void clean() {
        employerEvents.clear();
    }
}
