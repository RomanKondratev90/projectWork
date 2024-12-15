package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class EventsCalendarPage extends BasePage {
    private static final Logger log = LogManager.getLogger(TestingPage.class);

    //Кнопка - ОК
    private final SelenideElement buttonOk = $$("button.js-cookie-accept.cookies__button").filter(text("ОК")).first();
    //Карточки - Даты мероприятий
    private final ElementsCollection eventDates = $$("div.dod_new-event__time");
    //Выпадающий список - Ближайшие мероприятия
    private final SelenideElement eventsDropdownNearestEvents = $$("span.dod_new-events-dropdown__input-selected").filter(visible).first();;
    //Выпадающий список - Ближайшие мероприятия - элемент - Открытые вебинары
    private final SelenideElement eventsDropdownNearestEventsOpenWebinars = $$("a").filter(text("Открытый вебинар")).first();
    //Карточки - Открытый вебинар
    private final ElementsCollection openWebinarCards = $$("div.dod_new-type__text");

    public EventsCalendarPage clickButtonOk() {
        buttonOk.shouldBe(visible).click();
        log.info("Клик по кнопке - OK");
        return this;
    }

    //Прокрутка страницы до конца
    public EventsCalendarPage scrollToEndOfPage() {
        $("footer").scrollTo().shouldBe(visible);
        log.info("Прокрутка страницы до конца завершена");
        return this;
    }

    //Проверка актуальных дат мероприятий
    public EventsCalendarPage checkActualDates() {
        eventDates.shouldHave(CollectionCondition.sizeGreaterThan(0));
        //формат для парсинга даты и времени
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.forLanguageTag("ru"));
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        //текущая дата и время
        LocalDateTime now = LocalDateTime.now();
        int currentYear = now.getYear();
        //перебор
        for (SelenideElement eventElement : eventDates) {
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
        eventsDropdownNearestEvents.shouldBe(visible).click();
        log.info("Клик по элементу выпадающнго списка - Ближайшие мероприятия");
        return this;
    }

    //Клик по элементу выпадающего списка "Открытые вебинары"
    public EventsCalendarPage clickEventsDropdownNearestEventsOpenWebinars() {
        eventsDropdownNearestEventsOpenWebinars.shouldBe(visible).doubleClick();
        log.info("Клик по элементу выпадающего списка 'Открытый вебинар'");
        return this;
    }

    //Проверка наличия карточек "Открытый вебинар"
    public EventsCalendarPage checkOpenWebinar() {
        System.out.printf("Количество карточек с 'Открытый вебинар': %d", openWebinarCards.filter(text("Открытый вебинар")).size());
        return this;
    }
}



