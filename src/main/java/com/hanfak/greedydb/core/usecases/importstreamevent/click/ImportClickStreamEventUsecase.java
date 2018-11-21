package com.hanfak.greedydb.core.usecases.importstreamevent.click;

import com.hanfak.greedydb.core.domain.click.Click;

public class ImportClickStreamEventUsecase {
    private final ClickStreamRepository clickStreamRepository;

    public ImportClickStreamEventUsecase(ClickStreamRepository clickStreamRepository) {
        this.clickStreamRepository = clickStreamRepository;
    }

    public void storeEvent(Click click) {
        clickStreamRepository.storeEventInStream(click);
    }
}
