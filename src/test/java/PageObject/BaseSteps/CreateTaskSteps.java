package PageObject.BaseSteps;

import PageObject.BaseElements.CreateTaskElements;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

/**
 * Класс шага тестирования заведения новый задачи в Jira
 */
public class CreateTaskSteps extends CreateTaskElements {
    @Step("Создание задачи с типом {typeName}, приоритету {priority}, темой {themeName},  и описанием {specificationStr}")
    public static void createTask(String typeName, String priority, String themeName, String specificationStr) {
        buttonCreate.click();
        typeTask.shouldBe(visible, Duration.ofSeconds(60)).click();
        typeTask.setValue(typeName);
        typeTask.pressEnter();
        createTheme.setValue(themeName);
        textButton1.shouldBe(visible, Duration.ofSeconds(60)).click();
        descriptionFrame.click();
        descriptionFrame.shouldBe(visible, Duration.ofSeconds(60)).sendKeys(specificationStr);
        selectVersion.click();
        selectPriority.click();
        selectPriority.setValue(priority);
        selectPriority.pressEnter();
        textButton2.shouldBe(visible, Duration.ofSeconds(60)).click();
        environmentFrame.click();
        environmentFrame.shouldBe(visible, Duration.ofSeconds(60)).sendKeys("Windows 11, Chrome 101.0.4951.54");
        assignMe.click();
        buttonFinal.click();
    }
}
