package tests;

import base.BaseSettings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.EventsCalendarPage;

public class checkEventsCalendarTest extends BaseSettings {

    @Test
    @DisplayName("Проверка дат мероприятий")
    public void checkEventDates() {
        new BasePage()
                .openURL()
                .clickButtonOk()
                .clickDropdownTraining()
                .clickEventsCalendar();
        new EventsCalendarPage()
                .clickButtonOk()
                .scrollToEndOfPage()
                .checkActualDates();
    }

    @Test
    @DisplayName("Проверка мероприятий с типом 'Открытый вебинар'")
    public void checkOpenWebinarEvents() {
        new BasePage()
                .openURL()
                .clickButtonOk()
                .clickDropdownTraining()
                .clickEventsCalendar();
        new EventsCalendarPage()
                .clickButtonOk()
                .clickEventsDropdownNearestEvents()
                .clickEventsDropdownNearestEventsOpenWebinars()
                .scrollToEndOfPage()
                .checkOpenWebinar();
    }
}
