package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By userField = By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input");
    By passwordField = By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[2]/input");
    By loginButton = By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/input");
    By errorMessage = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String user, String password) {
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
