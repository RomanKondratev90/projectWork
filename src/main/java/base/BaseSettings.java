package base;

import com.codeborne.selenide.Configuration;
import factory.WebDriverFactory;
import factory.BrowserMode;
import factory.DelayFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseSettings {
    private static WebDriverFactory factory;

    @BeforeAll  //аннотация (запуск настроек (метода) один раз перед всеми тестами)
    public static void init() {
        factory = new WebDriverFactory();
        Configuration.timeout = 60000; //установка неявного ожидания = 60000 (60 сек.) (время ожидания элемента)
        DelayFactory.setActionDelay(300); //задержка перед действием = 300 мс (рекомендованное значение)
    }

    @BeforeEach  //аннотация (запуск настроек (метода) перед каждым тестом)
    public void setUp() {
        factory.createDriver("firefox", BrowserMode.SCREEN_RESOLUTION_1920x1080);  //выбор браузера и режима
    }

    @AfterEach  // аннотация (вызов метода после каждого теста, закрытие браузера)
    public void quitBrowser() {
        factory.quitDriver();
    }
}
