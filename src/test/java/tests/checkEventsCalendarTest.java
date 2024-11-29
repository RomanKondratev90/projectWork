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
}







/*
3. Валидация дат мероприятий. Прогрузить все карточки, получить дату актуальную или больше актуальной)
Проверить, что отображаются даты актуальные, либо больше актуальной
4. Открыть карточки  предстоящих мероприятий - Открытые вебинары
Выбрать открытый вебинар в выпадающем списке и проверить, что все карточки имеют значение - открытый вебинар
*/