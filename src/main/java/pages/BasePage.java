package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.codeborne.selenide.Selenide.*;

public abstract class BasePage {
    private static final Logger log = LogManager.getLogger(TestingPage.class);

    // Метод для открытия URL
    public void openURL(String baseUrl) {
        open(baseUrl);
        log.info("Открыт URL: {}", baseUrl);
    }
}

