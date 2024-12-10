import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class LoginNegativeTest2 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Не явное ожидание перед поиском элемента
    }

    @Test
    public void LoginNeg2() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#login-button")).isDisplayed()); // Проверка, что находимся на странице с кнопкой логина
        driver.findElement(By.name("user-name")).sendKeys("qwqfwqf"); // Ввод не валидного логина
        driver.findElement(By.name("password")).sendKeys("secret_sauce"); // Ввод пароля
        driver.findElement(By.cssSelector("#login-button")).click(); // Нажатие на кнопку логина
        String errorMessage = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }


}
