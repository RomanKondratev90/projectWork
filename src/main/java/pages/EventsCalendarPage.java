package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import utils.ElementActions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

@Slf4j //Аннотацию для логирования
public class EventsCalendarPage {
    private ElementActions elementActions = new ElementActions();

    //Кнопка - ОК
    private static final SelenideElement BUTTON_OK =$x("//button[@class='js-cookie-accept cookies__button']");
    //Карточки - Даты мероприятий
    private static final ElementsCollection EVENT_DATE = $$("div.dod_new-event__time");
    //Выпадающий список - Ближайшие мероприятия
    private static final SelenideElement EVENTS_DROPDOWN_NEAREST_EVENTS =$x("//span[@class='dod_new-events-dropdown__input-selected']");
    //Выпадающий список - Ближайшие мероприятия - элемент - Открытые вебинары
    private static final SelenideElement EVENTS_DROPDOWN_NEAREST_EVENTS_OPEN_WEBINARS =$x("//a[normalize-space(text())='Открытый вебинар']");
    //Карточки - Открытый вебинар
    private static final ElementsCollection OPEN_WEBINAR = $$("div.dod_new-type__text");

    public EventsCalendarPage clickButtonOk() {
        elementActions.doubleClick(BUTTON_OK, "Кнопка 'ОК'");
        return this;
    }
    public EventsCalendarPage scrollToEndOfPage() {
        long lastHeight = (long) executeJavaScript("return document.body.scrollHeight;");
        long newHeight;
        while (true) {
            executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
            sleep(2000);
            newHeight = (long) executeJavaScript("return document.body.scrollHeight;");
            if (newHeight == lastHeight) {
                break;
            }
            lastHeight = newHeight;
        }
        return this;
    }
    public EventsCalendarPage checkActualDates() {
        EVENT_DATE.shouldHave(CollectionCondition.sizeGreaterThan(0));
        //формат для парсинга даты и времени
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.forLanguageTag("ru"));
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        //текущая дата и время
        LocalDateTime now = LocalDateTime.now();
        int currentYear = now.getYear();
        //перебор
        for (SelenideElement eventElement : EVENT_DATE) {
            try { //поиск всех дочерних элементов
                ElementsCollection dateAndTimeItems = eventElement.$$("span.dod_new-event__date-text");
                if (dateAndTimeItems.size() >= 2) {
                    String dateText = dateAndTimeItems.get(0).getText().trim(); //строка - дата
                    String timeText = dateAndTimeItems.get(1).getText().trim(); //строка - время
                    String dateWithYear = dateText + " " + currentYear;
                    LocalDate date = LocalDate.parse(dateWithYear, dateFormatter);
                    LocalTime time = LocalTime.parse(timeText, timeFormatter);
                    LocalDateTime eventDateTime = LocalDateTime.of(date, time);
                    //проверка актуальности дат
                    if (!eventDateTime.isBefore(now)) {
                        System.out.println("Актуальная и будущие даты: " + eventDateTime);
                    } else {
                        System.out.println("Неактуальная дата и время: " + eventDateTime);
                    }
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + eventElement.getText());
                e.printStackTrace();
            }
        }
        return this;
    }
    public EventsCalendarPage clickEventsDropdownNearestEvents() {
        elementActions.click(EVENTS_DROPDOWN_NEAREST_EVENTS, "Выпадающий список 'Ближайшие мероприятия'");
        return this;
    }
    public EventsCalendarPage clickEventsDropdownNearestEventsOpenWebinars() {
        elementActions.doubleClick(EVENTS_DROPDOWN_NEAREST_EVENTS_OPEN_WEBINARS, "Элемен выпадающего списка 'Открытый вебинар'");
        return this;
    }
    public EventsCalendarPage checkOpenWebinar(){
        long count = 0;
        for (WebElement element : OPEN_WEBINAR) {
            if (element.getText().contains("Открытый вебинар")) {
                count++;
            }
        }
        System.out.println("Количество карточек с 'Открытый вебинар': " + count);
        return this;
    }
}



