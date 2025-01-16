package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    By cartOpen = By.cssSelector("[data-test=shopping-cart-link]");
    String cartRemoveButtonPattern = "//div[text()='%s']//ancestor::div[@class='cart_list']//button";

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void CartPageOpen() {
        driver.findElement(cartOpen).click();
    }

   public boolean getRemoveButton(String product) {
       return driver.findElement(By.xpath(String.format(cartRemoveButtonPattern, product))).isEnabled();
   }
}
