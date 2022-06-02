package PageObject.BaseSteps;

import PageObject.BaseElements.MainElements;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Класс шага тестирования перехода с главной странице в проекты и проверки заведенных задач
 */
public class MainSteps extends MainElements {
    @Step("Получение количества заведённых задач")
    public static void getCountTask(){
        projectButton.shouldBe(visible, Duration.ofSeconds(60)).click();
        testButton.shouldBe(visible, Duration.ofSeconds(60)).click();
        listTasks.shouldBe(visible, Duration.ofSeconds(60)).click();
        assertNotNull(projectCount.shouldBe(visible, Duration.ofSeconds(60)).text());
    }
}
