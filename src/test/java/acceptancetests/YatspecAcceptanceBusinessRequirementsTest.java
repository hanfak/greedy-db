package acceptancetests;

import com.googlecode.yatspec.junit.SpecRunner;
import com.googlecode.yatspec.rendering.Renderer;
import com.googlecode.yatspec.state.givenwhenthen.TestState;
import com.googlecode.yatspec.state.givenwhenthen.WithTestState;
import com.hanfak.greedydb.core.usecases.ClickStreamRepository;
import com.hanfak.greedydb.core.usecases.EmployerStreamRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.runner.RunWith;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

@RunWith(SpecRunner.class)
public abstract class YatspecAcceptanceBusinessRequirementsTest implements WithTestState, WithAssertions {
    protected final EmployerStreamRepository employerStreamRepository = mock(EmployerStreamRepository.class);
    protected final ClickStreamRepository clickStreamRepository = mock(ClickStreamRepository.class);
    protected final Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
    private final TestState testState = new TestState();

    @Override
    public TestState testState() {
        return testState;
    }

    protected <T> void log(String title, T value) {
        testState.log(title, value);
    }

    public class NewLineAsHtmlBreakRenderer implements Renderer<String> {
        @Override
        public String render(String s) {
            return s.replaceAll("\\n", "<br/>");
        }
    }
}
