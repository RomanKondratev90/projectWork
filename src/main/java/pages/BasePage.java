package pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BasePage {
    private static final Logger log = LogManager.getLogger(TestingPage.class);

    //Вкладка - Обучение
    private final SelenideElement dropdownTraining = $$("span").filter(text("Обучение")).first();
    //Вкладка - Тестирование
    private final SelenideElement dropdownTrainingTesting = $$("a").filter(text("Тестирование")).first();
    //Вкладка - Календрарь мероприятий
    private final SelenideElement eventsCalendar = $$("a").filter(text("Календарь мероприятий")).first();
    //Кнопка - ОК
    private final SelenideElement buttonOk = $$("div.sc-9a4spb-2").filter(text("OK")).first();

    public BasePage clickDropdownTraining() {
        dropdownTraining.shouldBe(visible).click();
        log.info("Клик по выпадающему списоку - Обучение ");
        return this;
    }
    public BasePage clickDropdownTrainingTesting() {
        dropdownTrainingTesting.shouldBe(visible).click();
        log.info("Клик по элементу выпадающего списока - Тестирование");
        return this;
    }
    public BasePage clickEventsCalendar() {
        eventsCalendar.shouldBe(visible).doubleClick();
        log.info("Клик по элементу выпадающего списока - Календарь мероприятий");
        return this;
    }
    public BasePage clickButtonOk() {
        buttonOk.shouldBe(visible).doubleClick();
        log.info("Клик по кнопке - ОК");
        return this;
    }
    public BasePage openURL() {
        String baseUrl = System.getProperty("base.url", "https://otus.ru");
        open(baseUrl);
        log.info("Переход по URL");
        return this;
    }
}

