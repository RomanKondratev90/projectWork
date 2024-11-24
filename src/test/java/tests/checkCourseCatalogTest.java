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
                .clickBropdownTraining()
                .clickBropdownTrainingTesting();
        new TestingPage()
                .clickShowMoreButton()
                .displayTotalCoursesCount();
    }

    @Test
    @DisplayName("Проверка полей в курсе: Java QA Engineer. Professional")
    public void checkCourseData() {
        new BasePage()
                .openURL()
                .clickButtonOk()
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
3. Валидация дат мероприятий. Прогрузить все карточки, получить дату актуальную или больше актуальной)
Проверить, что отображаются даты актуальные, либо больше актуальной
4. Открыть карточки  предстоящих мероприятий - Открытые вебинары
Выбрать открытый вебинар в выпадающем списке и проверить, что все карточки имеют значение - открытый вебинар
*/