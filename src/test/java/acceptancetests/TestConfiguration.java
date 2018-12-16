package acceptancetests;

import com.hanfak.greedydb.configuration.ApplicationConfiguration;

public class TestConfiguration extends ApplicationConfiguration {

    @Override
    public  EmployerStreamTestRepository employerStreamDataProvider() {
        return new EmployerStreamTestRepository();
    }
}
