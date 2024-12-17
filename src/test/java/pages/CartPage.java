package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    By cartOpen = By.cssSelector("[data-test=shopping-cart-link]");
    By RemoveButtonBackpack = By.id("remove-sauce-labs-backpack");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void CartPageOpen() {
        driver.findElement(cartOpen).click();
    }

    public boolean getRemoveButton() {
        return driver.findElement(RemoveButtonBackpack).isEnabled();

    }
}
