package factory;

import com.codeborne.selenide.Configuration;

public class ModeSettings {
    private BrowserMode mode;

    public ModeSettings(BrowserMode mode) {
        this.mode = mode;
    }

    public void applySettings() {
        switch (mode) {
            case HEADLESS:
                Configuration.headless = true;
                Configuration.browserSize = "1920x1080";
                break;
            case SCREEN_RESOLUTION_1920x1080:
                Configuration.browserSize = "1920x1080";
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемый режим браузера: " + mode);
        }
    }
}