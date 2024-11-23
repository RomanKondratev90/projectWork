package tests;

import base.BaseSettings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasePage;


public class checkCourseCatalog extends BaseSettings {
    @Test
    @DisplayName("Проверка каталога")
    public void checktest() {
        new BasePage()
                .openURL();
    }
}
