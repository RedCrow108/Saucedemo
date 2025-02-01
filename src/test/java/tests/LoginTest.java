package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Test(testName = "Проверка логина с валидным паролем",
            description = "Тест авторизации с валидным паролем",
            priority = 1,
            enabled = true,
            groups = {"smoke", "ui", "positive"},
            invocationCount = 1,
            threadPoolSize = 2,
            retryAnalyzer = Retry.class
    )
    @Description("Проверка лоина с валидным паролем")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Saucedemo 1.0")
    @Feature("Login in Saucedemo")
    @Story("Логин")
    @TmsLink("www.jira.com/ITM-3")
    @Issue("www.jira.com/ITM-3/bug")
    @Flaky
    public void checkLoginWithValidLoginAndPassword() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(
                productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    @Test(testName = "Проверка логина с не валидным паролем",
            description = "Тест авторизации с не валидным паролем",
            priority = 2,
            enabled = true,
            groups = {"smoke", "ui", "negative"},
            invocationCount = 1,
            threadPoolSize = 2
    )
    @Description("Проверка лоина с не валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Saucedemo 1.0")
    @Feature("Login in Saucedemo")
    @Story("Логин")
    @TmsLink("www.jira.com/ITM-3")
    @Issue("www.jira.com/ITM-3/bug-2")
    public void checkLoginWithNotValidPassword() {
        loginPage.open();
        loginPage.login("standard_user", "aafaeefefaf");
        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не появилось");
    }

    @Test(testName = "Проверка логина с не валидным пользователем",
            description = "Тест авторизации с не валидным пользователем",
            priority = 3,
            enabled = true,
            groups = {"smoke", "ui", "negative"},
            invocationCount = 1,
            threadPoolSize = 2
    )
    @Description("Проверка лоина с не валидным пользователем")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Saucedemo 1.0")
    @Feature("Login in Saucedemo")
    @Story("Логин")
    @TmsLink("www.jira.com/ITM-3")
    @Issue("www.jira.com/ITM-3/bug-3")
    public void checkLoginWithNotValidUserName() {
        loginPage.open();
        loginPage.login("wefwefwf", "secret_sauce");
        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не появилось");
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"wefwefwf", "secret_sauce",
                        "Epic sadface: Username and password do not match any user in this service"},
                {"standard_user", "aafaeefefaf",
                        "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(testName = "Проверка логина, только негативные тесты",
            description = "Проверка логина, только негативные тесты",
            priority = 4,
            enabled = true,
            dependsOnMethods = {"checkLoginWithValidLoginAndPassword"},
            groups = {"smoke", "ui", "negative"},
            invocationCount = 1,
            threadPoolSize = 1,
            dataProvider = "LoginData"
    )
    @Description("Проверка логина, только негативные тесты")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Saucedemo 1.0")
    @Feature("Login in Saucedemo")
    @Story("Логин")
    @TmsLink("www.jira.com/ITM-3")
    @Issue("www.jira.com/ITM-3/bug-5")
    public void checkAllNegativeLogin(String user, String password, String message) {
        loginPage.open();
        loginPage.login(user, password);
        Assert.assertEquals(
                loginPage.getErrorMessage(),
                message,
                "Сообщение об ошибке не появилось");
    }
}
