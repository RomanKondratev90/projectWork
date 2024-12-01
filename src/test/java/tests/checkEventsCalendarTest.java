package tests;

import base.BaseSettings;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.EventsCalendarPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;

public class checkEventsCalendarTest extends BaseSettings {
    @Test
    @DisplayName("Проверка дат мероприятий")
    public void checkEventDates() {
        new BasePage()
                .openURL()
                .clickButtonOk()
                .clickBropdownTraining()
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
                .clickBropdownTraining()
                .clickEventsCalendar();
        new EventsCalendarPage()
                .clickButtonOk()
                .clickEventsDropdownNearestEvents()
                .clickEventsDropdownNearestEventsOpenWebinars();
        new EventsCalendarPage()
                //.scrollToEndOfPage()
                .checkOpenWebinar();
    }
}
