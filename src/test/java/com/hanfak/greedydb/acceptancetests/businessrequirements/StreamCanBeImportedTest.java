package com.hanfak.greedydb.acceptancetests.businessrequirements;

import com.hanfak.greedydb.acceptancetests.YatspecAcceptanceBusinessRequirementsTest;
import com.hanfak.greedydb.core.domain.click.*;
import com.hanfak.greedydb.core.domain.employer.Employer;
import com.hanfak.greedydb.core.usecases.importstreamevent.click.ImportClickStreamEventUsecase;
import com.hanfak.greedydb.core.usecases.importstreamevent.employer.ImportEmployerStreamEventUsecase;
import org.junit.Test;

import static com.hanfak.greedydb.core.domain.employer.Employer.employer;
import static com.hanfak.greedydb.core.domain.employer.Id.id;
import static com.hanfak.greedydb.core.domain.employer.Name.name;
import static com.hanfak.greedydb.core.domain.employer.Surname.surname;
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

    private final Employer employer = employer(timestamp, id(123456L), name("Bob"), surname("Coco"));
    private final Origin origin = Origin.origin(Brand.brand("Brand"), Position.position("pos"));
    private final Click click = Click.click(timestamp, Page.page("/page"), origin);

    private final ImportEmployerStreamEventUsecase importEmployerStreamEventUsecase = new ImportEmployerStreamEventUsecase(employerStreamRepository);
    private final ImportClickStreamEventUsecase importClickStreamEventUsecase = new ImportClickStreamEventUsecase(clickStreamRepository);
}
