package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By userField = By.xpath("//input[@id='user-name']");
    By passwordField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//input[@id='login-button']");
    By errorMessage = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открытие страницы")
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }
    @Step("Вход в систему с логином: {user} и паролем {password}")
    public void login(String user, String password) {
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
    @Step("Проверка получено ли сообщение об ошибке")
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
