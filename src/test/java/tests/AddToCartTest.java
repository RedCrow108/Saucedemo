package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test (testName = "Добавления товара в корзину")
    @Description("Добавления товара в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Saucedemo 1.0")
    @Feature("Add to cart")
    @Story("Корзина")
    @TmsLink("www.jira.com/ITM-23")
    @Issue("www.jira.com/ITM-23/bug-11")
    public void AddToCartBackPack() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        cartPage.CartPageOpen();
        Assert.assertTrue(
                cartPage.getRemoveButton("Sauce Labs Bike Light")); // Проверяет что getRemoveButton возвращает значение "True"
    }
}
