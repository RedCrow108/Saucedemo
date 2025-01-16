package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void AddToCartBackPack() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        cartPage.CartPageOpen();
        Assert.assertTrue(
                cartPage.getRemoveButton()); // Проверяет что getRemoveButton возвращает значение "True"

    }
}
