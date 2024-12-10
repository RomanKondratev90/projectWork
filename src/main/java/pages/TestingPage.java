package pages;

import com.codeborne.selenide.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestingPage {
    private static final Logger log = LogManager.getLogger(TestingPage.class);

    //Количество курсов
    private final ElementsCollection totalCoursesCount = $$("section.sc-o4bnil-0.riKpM a");
    //Кнопка - Показать еще
    private final SelenideElement showMoreButton = $$("button").filter(text("Показать еще")).first();
    //Курс - Java QA Engineer. Professional
    private final SelenideElement javaQaEngineerProfessional = $$("div.sc-hrqzy3-1.jEGzDf").filter(text("Java QA Engineer. Professional")).first();
    //Поле - Название курса
    private final SelenideElement courseName = $$("h1").filter(text("Java QA Engineer. Professional")).first();
    //Поле - Описание
    private final SelenideElement courseDescription = $$("p").filter(text("Курс по автоматизированному тестированию на Java: продвинутые инструменты, новые карьерные возможности")).first();
    //Поле - Длительность
    private final SelenideElement trainingDuration = $$("p").filter(text("4 месяца")).first();
    //Поле - Формат
    private final SelenideElement trainingFormat = $$("p").filter(text("Онлайн")).first();

    public TestingPage clickShowMoreButton() {
        Selenide.executeJavaScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", showMoreButton);
        showMoreButton.should(appear).click();
        log.info("скролл и клик по кнопке - 'Показать еще'");
        return this;
    }
    public TestingPage checkTotalCoursesCount(int expectedCount) {
        totalCoursesCount.shouldHave(CollectionCondition.size(expectedCount));
        log.info("Проверка, что отображается количество курсов = {}", expectedCount);
        System.out.println("Фактическое количество курсов = " + totalCoursesCount.size());
        return this;
    }
    public TestingPage clickJavaQaEngineerProfessional() {
        javaQaEngineerProfessional.doubleClick();
        log.info("Клик по карточке курса - Java QA Engineer. Professional");
        return this;
    }
    public TestingPage checkCourseData() {
        courseName.shouldHave(text("Java QA Engineer. Professional"));
        log.info("Проверка отображения названия курса  - Java QA Engineer. Professional");
        courseDescription.shouldHave(text("Курс по автоматизированному тестированию на Java: продвинутые инструменты, новые карьерные возможности"));
        log.info("Проверка отображения описания курса  - Курс по автоматизированному тестированию на Java: продвинутые инструменты, новые карьерные возможности");
        trainingDuration.shouldHave(text("4 месяца"));
        log.info("Проверка отображения длительности обучения - 4 месяца");
        trainingFormat.shouldHave(text("Онлайн"));
        log.info("Проверка отображения формата обучения - Онлайн");
        return this;
    }
}
