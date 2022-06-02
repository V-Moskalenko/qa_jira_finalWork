package Hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Класс с методами для открытия web-драйвера в полноэкранном режиме до начала тестов и закрия драйвера после каждого теста
 */
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