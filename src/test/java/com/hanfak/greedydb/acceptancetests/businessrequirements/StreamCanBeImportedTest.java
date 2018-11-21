package com.hanfak.greedydb.acceptancetests.businessrequirements;

import com.hanfak.greedydb.acceptancetests.YatspecAcceptanceBusinessRequirementsTest;
import com.hanfak.greedydb.core.domain.Click;
import com.hanfak.greedydb.core.domain.Employer;
import com.hanfak.greedydb.core.domain.Origin;
import com.hanfak.greedydb.core.usecases.importstreamevent.click.ImportClickStreamEventUsecase;
import com.hanfak.greedydb.core.usecases.importstreamevent.employer.ImportEmployerStreamEventUsecase;
import org.junit.Test;

import static org.mockito.Mockito.verify;


public class StreamCanBeImportedTest extends YatspecAcceptanceBusinessRequirementsTest {

    @Test
    public void canStoreASingleEventOfToAnEmployerStream() {
        whenTheApiToImportAnEventForAEmployerStreamIsCalled();

        thenTheEmployerStreamContainsThisEvent();
    }

    @Test
    public void canStoreASingleEventOfToAnClickStream() {
        whenTheApiToImportAnEventForAClickStreamIsCalled();

        thenTheClickStreamContainsThisEvent();
    }

    private void whenTheApiToImportAnEventForAEmployerStreamIsCalled() {
        importEmployerStreamEventUsecase.storeEvent(employer);
    }

    private void whenTheApiToImportAnEventForAClickStreamIsCalled() {
        importClickStreamEventUsecase.storeEvent(click);
    }

    private void thenTheEmployerStreamContainsThisEvent() {
        verify(employerStreamRepository).storeEventInStream(employer);
    }

    private void thenTheClickStreamContainsThisEvent() {
        verify(clickStreamRepository).storeEventInStream(click);
    }

    private final Employer employer = new Employer(timestamp, 123456, "Bob", "Coco");
    private final Origin origin = new Origin("Brand", "pos");
    private final Click click = new Click(timestamp, "/page", origin);

    private final ImportEmployerStreamEventUsecase importEmployerStreamEventUsecase = new ImportEmployerStreamEventUsecase(employerStreamRepository);
    private final ImportClickStreamEventUsecase importClickStreamEventUsecase = new ImportClickStreamEventUsecase(clickStreamRepository);
}
