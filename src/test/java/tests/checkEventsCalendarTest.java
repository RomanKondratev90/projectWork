package tests;

import base.BaseSettings;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;

public class checkEventsCalendarTest extends BaseSettings {
    @Test
    @DisplayName("Проверка дат мероприятий")
    public void checkEventDates() {
        new BasePage()
                .openURL()
                .clickButtonOk()
                .clickBropdownTraining();
        sleep(3000);
        new BasePage()
                .clickEventsCalendar();
        sleep(3000);
        new BasePage()
                .clickButtonOk1();
sleep(3000);
        long lastHeight = (long) executeJavaScript("return document.body.scrollHeight;");
        long newHeight;

        while (true) {
            // Скроллим в самый низ страницы
            executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");

            // Ожидание загрузки контента (можно настроить под ваш сайт)
            sleep(2000);

            // Получаем новую высоту страницы
            newHeight = (long) executeJavaScript("return document.body.scrollHeight;");

            // Если высота страницы не увеличилась, значит конец достигнут
            if (newHeight == lastHeight) {
                break;
            }

            lastHeight = newHeight; // Обновляем значение последней высоты
        }

        System.out.println("Достигнут конец страницы.");
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