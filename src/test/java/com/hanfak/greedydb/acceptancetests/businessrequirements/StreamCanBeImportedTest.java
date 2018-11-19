package com.hanfak.greedydb.acceptancetests.businessrequirements;

import com.hanfak.greedydb.YatspecAcceptanceBusinessRequirementsTest;
import com.hanfak.greedydb.core.domain.Click;
import com.hanfak.greedydb.core.domain.Employer;
import com.hanfak.greedydb.core.domain.Origin;
import com.hanfak.greedydb.core.usecases.EmployerStreamRepository;
import com.hanfak.greedydb.core.usecases.importstreamevent.click.ClickStreamRepository;
import com.hanfak.greedydb.core.usecases.importstreamevent.click.ImportClickStreamEventUsecase;
import com.hanfak.greedydb.core.usecases.importstreamevent.employer.ImportEmployerStreamEventUsecase;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;
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

    private final EmployerStreamRepository employerStreamRepository = mock(EmployerStreamRepository.class);
    private final ClickStreamRepository clickStreamRepository = mock(ClickStreamRepository.class);
    private final LocalDateTime dateTime = LocalDateTime.now();
    private final Employer employer = new Employer(Timestamp.valueOf(dateTime), 123456, "Bob", "Coco");
    private final Origin origin = new Origin("Brand", "pos");
    private final Click click = new Click(Timestamp.valueOf(dateTime), "/page", origin);

    private final ImportEmployerStreamEventUsecase importEmployerStreamEventUsecase = new ImportEmployerStreamEventUsecase(employerStreamRepository);
    private final ImportClickStreamEventUsecase importClickStreamEventUsecase = new ImportClickStreamEventUsecase(clickStreamRepository);
}
