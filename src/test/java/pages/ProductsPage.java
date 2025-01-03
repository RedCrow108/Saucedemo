package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    By title = By.cssSelector("[data-test=title]");
    String addToCartPattern = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
   public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(addToCartPattern, product))).click();
    }
}
