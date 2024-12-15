package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseSettings implements BeforeAllCallback, AfterEachCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        Configuration.timeout = 10000; //Ожидание
        Configuration.browser = System.getProperty("browser", "firefox"); //Браузер
        Configuration.browserSize = System.getProperty("browser.size", "1920x1080"); //Размер окна
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false")); //Headless - включение / выключение
    }

    @Override
    public void afterEach(ExtensionContext context) {
        closeWebDriver();
    }
}
