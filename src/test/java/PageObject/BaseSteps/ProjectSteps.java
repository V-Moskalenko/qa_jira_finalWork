package PageObject.BaseSteps;

import PageObject.BaseElements.ProjectElements;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Класс шага тестирования проверки статуса и версии задачи TestSelenium
 */
public class ProjectSteps extends ProjectElements {
    @Step("Проверка статуса и версии задачи")
    public static void testTask() {
        filtrPath.shouldBe(visible, Duration.ofSeconds(180)).setValue("TestSelenium");
        buttonTest.shouldBe(visible, Duration.ofSeconds(180)).click();
        buttonStatusBar.click();
        String status = statusTask.shouldBe(visible, Duration.ofSeconds(180)).text();
        assertEquals("В РАБОТЕ", status, "not equals");
        assertEquals("Version 2.0", versionTask.text(), "not equals");
    }
}
