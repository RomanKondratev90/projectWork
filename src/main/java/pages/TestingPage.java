package pages;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class TestingPage {

    private static final ElementsCollection TOTAL_COURSES_COUNT = $$("a.sc-zzdkm7-0");

    public TestingPage displayTotalCoursesCount() {
        System.out.println("Количество курсов: "+ TOTAL_COURSES_COUNT.size());
        return this;
    }

}
