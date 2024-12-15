package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.EventsCalendarPage;
import pages.MainPage;

@ExtendWith(BaseSettings.class)
public class CheckEventsCalendarTest {

    @Test
    @DisplayName("Проверка дат мероприятий")
    public void checkEventDates() {
        new MainPage()
                .openMainPage()
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
        new MainPage()
                .openMainPage()
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
