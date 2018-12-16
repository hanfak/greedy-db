package acceptancetests;

import com.googlecode.yatspec.junit.SpecResultListener;
import com.googlecode.yatspec.junit.SpecRunner;
import com.googlecode.yatspec.junit.WithCustomResultListeners;
import com.googlecode.yatspec.rendering.Renderer;
import com.googlecode.yatspec.rendering.html.HtmlResultRenderer;
import com.googlecode.yatspec.state.givenwhenthen.TestState;
import com.googlecode.yatspec.state.givenwhenthen.WithTestState;
import com.hanfak.greedydb.configuration.GreedyDb;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpecRunner.class)
public abstract class YatspecAcceptanceEndToEndTest implements WithTestState, WithCustomResultListeners {

    private final TestState testState = new TestState();
    private final GreedyDb application = new GreedyDb();
    protected final TestConfiguration configuration = new TestConfiguration();

    @Before
    public void startup() throws Exception {
        configuration.employerStreamDataProvider().clean(); // Do I need?
        application.start(configuration);
    }

    @After
    public void teardown() {
        application.stop();
    }

    @Override
    public TestState testState() {
        return testState;
    }

    @Override
    public Iterable<SpecResultListener> getResultListeners() {
        List<SpecResultListener> specResultListeners = new ArrayList<>();

        HtmlResultRenderer htmlResultRenderer = new HtmlResultRenderer()
                .withCustomRenderer(String.class, new NewLineAsHtmlBreakRenderer());

        specResultListeners.add(htmlResultRenderer);
        return specResultListeners;
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
