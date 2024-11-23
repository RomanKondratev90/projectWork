package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import utils.ElementActions;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class TestingPage {
    private ElementActions elementActions = new ElementActions();

    private static final ElementsCollection TOTAL_COURSES_COUNT = $$("a.sc-zzdkm7-0");

    private static final SelenideElement JAVA_QA_ENGINEER_PROFESSIONAL =$x("(//a[@href='/lessons/java-qa-pro'])[1]");
    private static final SelenideElement COURSE_NAME =$x("//h1[normalize-space(text())='Java QA Engineer. Professional']");
    private static final SelenideElement COURSE_DESCRIPTION =$x("//p[normalize-space(text())='Курс по автоматизированному тестированию на Java: продвинутые инструменты, новые карьерные возможности']");
    private static final SelenideElement TRAINING_DURATION =$x("//p[normalize-space(text())='4 месяца']");
    private static final SelenideElement TRAINING_FORMAT =$x("//p[normalize-space(text())='Онлайн']");


    public TestingPage displayTotalCoursesCount() {
        System.out.println("Количество курсов: "+ TOTAL_COURSES_COUNT.size());
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




//        public void verifyCourseDetails(String name, String description, String duration, String format) {
//        $x("//h1").shouldHave(text(name));
//        $x("//div[contains(text(), 'Описание')]").parent().shouldHave(text(description));
//        $x("//div[contains(text(), 'Длительность')]").parent().shouldHave(text(duration));
//        $x("//div[contains(text(), 'Формат')]").parent().shouldHave(text(format));



}
