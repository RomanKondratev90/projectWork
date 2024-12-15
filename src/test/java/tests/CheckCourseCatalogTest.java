package tests;

import enums.Course;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.BasePage;
import pages.MainPage;
import pages.TestingPage;

@ExtendWith(BaseSettings.class)
public class CheckCourseCatalogTest {
    @Test
    @DisplayName("Проверка количества курсов")
    public void checkCourseCount() {
        new MainPage()
                .openMainPage()
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
        new MainPage()
                .openMainPage()
                .clickButtonOk()
                .clickDropdownTraining()
                .clickDropdownTrainingTesting();
        new TestingPage()
                .clickJavaQaEngineerProfessional()
                .checkCourseData(Course.JAVA_QA_ENGINEER_PROFESSIONAL);
    }
}
