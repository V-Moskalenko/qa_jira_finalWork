package Hooks;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Класс для получения скриншотов после выполнения шага тестирования
 */
public class ScreenshotOnFailureRule implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png",
                ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES));
    }
}
