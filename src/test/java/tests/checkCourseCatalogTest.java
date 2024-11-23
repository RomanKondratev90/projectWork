package tests;

import base.BaseSettings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.TestingPage;


public class checkCourseCatalogTest extends BaseSettings {
    @Test
    @DisplayName("Проверка: кол-во курсов")
    public void checkCourseCount() {
        new BasePage()
                .openURL()
                .clickBropdownTraining()
                .clickBropdownTrainingTesting();
        new TestingPage()
                .displayTotalCoursesCount();
    }

    @Test
    @DisplayName("Проверка полей в курсе: Java QA Engineer. Professional")
    public void checkCourseData() {
        new BasePage()
                .openURL()
                .clickBropdownTraining()
                .clickBropdownTrainingTesting();
        new TestingPage()
                .clickJavaQaEngineerProfessional()
                .checkCourseData();
    }




}
/*
1. Посчитать кол-во курсов в разделе тестирование и вывести результат
2. Перейти в карточку курса и проверить : Название,  Описание,  Длительность обучения, Формат
3. Валидация дат мероприятий (прогрузить все карточки, получить дату сегодняшнюю Либо больше сегоднешней)
Проверить что все даты сегодняшнюю Либо больше сегоднешней
4. Открыть карточки  предстоящих мероприятий - Открытые вебинары
Проверить, что все карточки имеют значение - открытый вебинар
*/