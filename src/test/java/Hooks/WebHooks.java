package Hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class WebHooks {

    @BeforeEach
    public void setWebDriverFormat() {
        Configuration.startMaximized = true;
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().
                        screenshots(true).savePageSource(false));
    }

    @AfterEach
    public void webClose() {
        WebDriverRunner.closeWebDriver();
    }

}
