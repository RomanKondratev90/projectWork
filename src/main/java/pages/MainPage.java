package pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends BasePage {
    private static final Logger log = LogManager.getLogger(TestingPage.class);

    //Вкладка - Обучение
    private final SelenideElement dropdownTraining = $$("span").filter(text("Обучение")).first();
    //Вкладка - Тестирование
    private final SelenideElement dropdownTrainingTesting = $$("a").filter(text("Тестирование")).first();
    //Вкладка - Календарь мероприятий
    private final SelenideElement eventsCalendar = $$("a").filter(text("Календарь мероприятий")).first();
    //Кнопка - ОК
    private final SelenideElement buttonOk = $$("div.sc-9a4spb-2").filter(text("OK")).first();

    public MainPage openMainPage() {
        openURL(System.getProperty("base.url", "https://otus.ru"));
        return this;
    }
    public MainPage clickDropdownTraining() {
        dropdownTraining.shouldBe(visible).click();
        log.info("Клик по вкладке 'Обучение'");
        return this;
    }
    public MainPage clickDropdownTrainingTesting() {
        dropdownTrainingTesting.shouldBe(visible).click();
        log.info("Клик по вкладке 'Тестирование'");
        return this;
    }
    public MainPage clickEventsCalendar() {
        eventsCalendar.shouldBe(visible).click();
        log.info("Клик по вкладке 'Календарь мероприятий'");
        return this;
    }
    public MainPage clickButtonOk() {
        buttonOk.shouldBe(visible).click();
        log.info("Клик по кнопке 'OK'");
        return this;
    }
}
