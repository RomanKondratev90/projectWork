package tests;

import base.BaseSettings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.TestingPage;

public class checkCourseCatalogTest extends BaseSettings {
    @Test
    @DisplayName("Проверка количества курсов")
    public void checkCourseCount() {
        new BasePage()
                .openURL()
                .clickButtonOk()
                .clickDropdownTraining()
                .clickDropdownTrainingTesting();
        new TestingPage()
                .clickShowMoreButton()
                .checkTotalCoursesCount(11);
    }
    @Test
    @DisplayName("Проверка полей в курсе: Java QA Engineer. Professional")
    public void checkCourseData() {
        new BasePage()
                .openURL()
                .clickButtonOk()
                .clickDropdownTraining()
                .clickDropdownTrainingTesting();
        new TestingPage()
                .clickJavaQaEngineerProfessional()
                .checkCourseData();
    }
}
