package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import utils.ElementActions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

@Slf4j //Аннотацию для логирования
public class EventsCalendarPage {
    private ElementActions elementActions = new ElementActions();

    private static final SelenideElement BUTTON_OK = $("button.js-cookie-accept");

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
        ElementsCollection dateElements = $$("span.dod_new-event__date-text").shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement dateElement : dateElements) {
            System.out.println(dateElement.getText());
        }
        return this;
    }
}


