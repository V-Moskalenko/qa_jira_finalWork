import Hooks.ScreenshotOnFailureRule;
import Hooks.WebHooks;
import Utils.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static PageObject.BaseSteps.CreateTaskSteps.createTask;
import static PageObject.BaseSteps.LoginSteps.authStep;
import static PageObject.BaseSteps.MainSteps.getCountTask;
import static PageObject.BaseSteps.ProjectSteps.testTask;
import static com.codeborne.selenide.Selenide.open;

/**
 * Основной класс тестирования на JUnit
 */
@ExtendWith(ScreenshotOnFailureRule.class)
public class TestJira extends WebHooks {

    @Epic(value = "Тестирование Jira")
    @Feature(value = "Тестирование авторизации")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тестирование авторизации по заданному логину и паролю")
    @Owner(value = "Москаленко Вадим")
    @Test
    @Tag("1")
    @DisplayName("Тест авторизации")
    public void Test_1(){
        open(Configuration.getValue("URL"));
        authStep(Configuration.getValue("loginName"), Configuration.getValue("passwordName"));
    }

    @Epic(value = "Тестирование Jira")
    @Feature(value = "Тестирование заведённых задач")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Проведение проверки, что в Доске TEST, заведенных задач больше нуля")
    @Owner(value = "Москаленко Вадим")
    @Test
    @Tag("2")
    @DisplayName("Проверка заведённых задач")
    public void Test_2(){
        open(Configuration.getValue("URL"));
        authStep(Configuration.getValue("loginName"), Configuration.getValue("passwordName"));
        getCountTask();
    }

    @Epic(value = "Тестирование Jira")
    @Feature(value = "Тестирование статуса и версии задачи")
    @Severity(SeverityLevel.MINOR)
    @Description("Проведение проверки, что статус и версия задачи TestSelenium, соответствует слудеющим значениям: В РАБОТЕ, Version 2.0")
    @Owner(value = "Москаленко Вадим")
    @Test
    @Tag("3")
    @DisplayName("Проверка статуса и версии задачи")
    public void Test_3(){
        open(Configuration.getValue("URL"));
        authStep(Configuration.getValue("loginName"), Configuration.getValue("passwordName"));
        getCountTask();
        testTask();
    }

    @Epic(value = "Тестирование Jira")
    @Feature(value = "Тестирование заведения новой задачи в Jira")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Создание новой задачи по заданному типу, приоритету, теме и описанию")
    @Owner(value = "Москаленко Вадим")
    @Test
    @Tag("4")
    @DisplayName("Заведение новой задачи")
    public void Test_4() {
        open(Configuration.getValue("URL"));
        authStep(Configuration.getValue("loginName"), Configuration.getValue("passwordName"));
        getCountTask();
        testTask();
        createTask(Configuration.getValue("type"), Configuration.getValue("priority"), Configuration.getValue("themeName"), Configuration.getValue("specification"));
    }
}
