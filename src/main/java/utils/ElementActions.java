package utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import factory.DelayFactory;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@Slf4j //Аннотацию для логирования
public class ElementActions {

    //Click - одиночный клик
    public ElementActions click(SelenideElement locator, String description) {
        //Задержка перед кликом, получаем из Base Settings
        Selenide.sleep(DelayFactory.getActionDelay());
        $(locator).click();
        log.info("Клик по элементу '{}'", description);
        return this;
    }

    //doubleClick - двойной клик
    public ElementActions doubleClick(SelenideElement locator, String description) {
        //Задержка перед кликом, получаем из Base Settings
        Selenide.sleep(DelayFactory.getActionDelay());
        $(locator).doubleClick();
        log.info("Двойной клик по элементу '{}'", description);
        return this;
    }

    //setValue - вставка текста
    public ElementActions setValue(SelenideElement locator, String value, String description) {
        //Задержка перед добавлением текста, получаем из Base Settings
        Selenide.sleep(DelayFactory.getActionDelay());
        $(locator).setValue(value);
        log.info("Ввод значения в элемент '{}'", description);
        return this;
    }

    //shouldHave - проверка, что элемент имеет конкретное состояние или текст в момент выполнения проверки.
    public ElementActions shouldHave(SelenideElement locator, String value, String description) {
        //Задержка перед сравнением, получаем из Base Settings
        Selenide.sleep(DelayFactory.getActionDelay());
        $(locator).shouldHave(text(value));
        log.info("Проверка, что отображается '{}'", description);
        return this;
    }
}