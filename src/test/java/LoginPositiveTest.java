import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginPositiveTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Не явное ожидание перед поиском элемента
    }

    @Test
    public void LoginPos1() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#login-button")).isDisplayed()); // Проверка, что находимся на странице с кнопкой логина
        driver.findElement(By.name("user-name")).sendKeys("standard_user"); // Ввод логина
        driver.findElement(By.name("password")).sendKeys("secret_sauce"); // Ввод пароля
        driver.findElement(By.cssSelector("#login-button")).click(); // Нажатие на кнопку логина
        Assert.assertTrue(driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span")).isDisplayed()); // Проверка, что находимся на странице с продуктами
        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click(); // Открытие меню
        driver.findElement(By.cssSelector("#logout_sidebar_link")).click(); // Нажатие logout
        Assert.assertTrue(driver.findElement(By.cssSelector("#login-button")).isDisplayed()); // Проверка, что находимся на странице логина
    }

    @Test
    public void LoginPos2() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#login-button")).isDisplayed()); // Проверка, что находимся на странице с кнопкой логина
        driver.findElement(By.name("user-name")).sendKeys("locked_out_user"); // Ввод логина
        driver.findElement(By.name("password")).sendKeys("secret_sauce"); // Ввод пароля
        driver.findElement(By.cssSelector("#login-button")).click(); // Нажатие на кнопку логина
        String errorMessage = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Sorry, this user has been locked out.");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }


}
