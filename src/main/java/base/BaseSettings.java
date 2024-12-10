package base;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public abstract class BaseSettings {

    @BeforeAll //аннотация (запуск настроек (метода) один раз перед всеми тестами)
    public static void init() {
        Configuration.timeout = 10000; //Ожидание
        Configuration.browser = System.getProperty("browser", "firefox"); //Браузер
        Configuration.browserSize = System.getProperty("browser.size", "1920x1080"); //Размер окна
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false")); //Headless - включение / выключение
    }

    @AfterEach //аннотация (вызов метода после каждого теста, закрытие браузера)
    public void quitBrowser() {
        closeWebDriver();
    }
}
