package pages;

import com.codeborne.selenide.SelenideElement;
import config.AccessesConfig;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import utils.ElementActions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

@Slf4j //Аннотацию для логирования
public class BasePage {
    private ElementActions elementActions = new ElementActions();

    //Вкладка - Обучение
    private static final SelenideElement DROPDOWN_TRAINING =$x("//span[normalize-space(text())='Обучение']");
    //Вкладка - Тестирование
    private static final SelenideElement DROPDOWN_TRAINING_TESTING =$x("//a[normalize-space(text())='Тестирование']");
    //Вкладка - Календрарь мероприятий
    private static final SelenideElement EVENTS_CALENDAR =$x("//a[normalize-space(text())='Календарь мероприятий']");
    //Кнопка - ОК
    private static final SelenideElement BUTTON_OK =$x("//div[normalize-space(text())='OK']");

    public BasePage clickBropdownTraining() {
        elementActions.click(DROPDOWN_TRAINING, "Выпадающий список 'Обучение'");
        return this;
    }
    public BasePage clickBropdownTrainingTesting() {
        elementActions.click(DROPDOWN_TRAINING_TESTING, "Элемент выпадающего списка 'Тестирование'");
        return this;
    }
    public BasePage clickEventsCalendar() {
        elementActions.click(EVENTS_CALENDAR, "Элемент выпадающего списка 'Календарь мероприятий'");
        return this;
    }
    public BasePage clickButtonOk() {
        elementActions.click(BUTTON_OK, "Кнопка 'ОК'");
        return this;
    }
    //Метод открытия URL
    public BasePage openURL() {
        AccessesConfig accessesConfig = ConfigFactory.create(AccessesConfig.class);
        accessesConfig.URL();
        open(accessesConfig.URL());
        log.info("Переход по URL");
        return this;
    }
}
