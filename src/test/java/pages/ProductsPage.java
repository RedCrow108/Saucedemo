package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    By title = By.cssSelector("[data-test=title]");
    By addToCartButtonBackpack = By.id("add-to-cart-sauce-labs-backpack");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void addToCart() {
        driver.findElement(addToCartButtonBackpack).click();
    }

}
