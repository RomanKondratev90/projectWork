package factory;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class WebDriverFactory {
    public void createDriver(String browser, BrowserMode mode) {
        ModeSettings modeSettings = new ModeSettings(mode);
        modeSettings.applySettings();

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                Configuration.browser = "chrome";
                Configuration.browserCapabilities = chromeOptions;
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                Configuration.browser = "firefox";
                Configuration.browserCapabilities = firefoxOptions;
                break;

            default:
                throw new IllegalArgumentException("Browser не поддерживается: " + browser);
        }
    }

    public void quitDriver() {
        Selenide.closeWebDriver();
    }
}