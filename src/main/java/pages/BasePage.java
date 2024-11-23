package pages;

import com.codeborne.selenide.ElementsCollection;
import config.AccessesConfig;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.*;

@Slf4j //Аннотацию для логирования
public class BasePage {

    //Метод открытия URL
    public BasePage openURL() {
        AccessesConfig accessesConfig = ConfigFactory.create(AccessesConfig.class);
        accessesConfig.URL();
        open(accessesConfig.URL());
        log.info("Переход по URL");
        return this;
    }
}
