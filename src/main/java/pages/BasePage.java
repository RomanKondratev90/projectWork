package pages;

import com.codeborne.selenide.ElementsCollection;
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

    private static final SelenideElement DROPDOWN_TRAINING =$x("//span[normalize-space(text())='Обучение']");
    private static final SelenideElement DROPDOWN_TRAINING_TESTING =$x("//a[normalize-space(text())='Тестирование']");

    public BasePage clickBropdownTraining() {
        elementActions.click(DROPDOWN_TRAINING, "Выпадающий список 'Обучение'");
        return this;
    }
    public BasePage clickBropdownTrainingTesting() {
        elementActions.click(DROPDOWN_TRAINING_TESTING, "Элемент выпадающего списка 'Тестирование'");
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
