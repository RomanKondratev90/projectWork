package pages;

import com.codeborne.selenide.*;
import lombok.extern.slf4j.Slf4j;
import utils.ElementActions;

import static com.codeborne.selenide.Selenide.*;

@Slf4j //Аннотацию для логирования
public class TestingPage {
    private ElementActions elementActions = new ElementActions();

    //Количество курсов
    private static final ElementsCollection TOTAL_COURSES_COUNT = $$x("//section[@class='sc-o4bnil-0 riKpM']//a");
    //Кнопка - Показать еще
    private static final SelenideElement SHOW_MORE_BUTTON = $x("//button[contains(normalize-space(text()), 'Показать еще')]");
    //Курс - Java QA Engineer. Professional
    private static final SelenideElement JAVA_QA_ENGINEER_PROFESSIONAL = $x("//div[normalize-space(text())='Java QA Engineer. Professional']");
    //Поле - Название
    private static final SelenideElement COURSE_NAME = $x("//h1[normalize-space(text())='Java QA Engineer. Professional']");
    //Поле - Описание
    private static final SelenideElement COURSE_DESCRIPTION = $x("//p[normalize-space(text())='Курс по автоматизированному тестированию на Java: продвинутые инструменты, новые карьерные возможности']");
    //Поле - Длительность
    private static final SelenideElement TRAINING_DURATION = $x("//p[normalize-space(text())='4 месяца']");
    //Поле - Формат
    private static final SelenideElement TRAINING_FORMAT = $x("//p[normalize-space(text())='Онлайн']");

    public TestingPage clickShowMoreButton() {
        Selenide.executeJavaScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", SHOW_MORE_BUTTON);
        Selenide.executeJavaScript("arguments[0].click();", SHOW_MORE_BUTTON);
        elementActions.click(SHOW_MORE_BUTTON, "Кнопка 'Показать еще' ");
        return this;
    }
    public TestingPage checkTotalCoursesCount(int expectedCount) {
        String actualCoursesCount = String.valueOf(TOTAL_COURSES_COUNT.size());
        TOTAL_COURSES_COUNT.shouldHave(CollectionCondition.size(expectedCount));
        log.info("Проверка, что отображается количество курсов = "+expectedCount);
        System.out.println("Фактическое количество курсов = " + actualCoursesCount);
        return this;
    }
    public TestingPage clickJavaQaEngineerProfessional() {
        elementActions.doubleClick(JAVA_QA_ENGINEER_PROFESSIONAL, "Курс 'Java QA Engineer. Professional'");
        return this;
    }
    public TestingPage checkCourseData() {
        elementActions.shouldHave(COURSE_NAME,"Java QA Engineer. Professional", "Название курса 'Java QA Engineer. Professional'");
        elementActions.shouldHave(COURSE_DESCRIPTION,"Курс по автоматизированному тестированию на Java: продвинутые инструменты, новые карьерные возможности", "Описание курса 'Курс по автоматизированному тестированию на Java: продвинутые инструменты, новые карьерные возможности'");
        elementActions.shouldHave(TRAINING_DURATION,"4 месяца", "Длительность обучения '4 месяца'");
        elementActions.shouldHave(TRAINING_FORMAT,"Онлайн", "Формат обучения 'Онлайн'");
    return this;
    }

}
