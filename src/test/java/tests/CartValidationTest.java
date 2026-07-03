package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.*;
import pages.*;

@Epic("SauceDemo Automation")
@Feature("Cart")
public class CartValidationTest extends BaseTest {

    @Test(priority = 4)
    @Story("Cart Update Validation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify cart update validation as per SD_UI_002")

    public void verifyCart() {

        // Login
        LoginPage login = new LoginPage(driver);

        login.login(
                prop.getProperty("username"),
                prop.getProperty("password"));

        ProductPage product = new ProductPage(driver);

        // Add 2 Products
        product.addBackpack();
        product.addBikeLight();

        // Verify Cart Count = 2
        Assert.assertEquals(product.getCartCount(), "2");

        // Open Cart
        product.openCart();

        CartPage cart = new CartPage(driver);

        // Verify Product Present
        Assert.assertTrue(cart.verifyBackpack());

        // Remove Backpack
        cart.removeBackpack();

        // Continue Shopping
        cart.continueShopping();

        // Add Another Product
        product.addBoltShirt();

        // Verify Count Again
        Assert.assertEquals(product.getCartCount(), "2");

        // Checkout
        product.openCart();

        cart.clickCheckout();

        CheckoutPage checkout =
                new CheckoutPage(driver);

        checkout.completeCheckout(
                "Krishna",
                "Raj",
                "600001");

        CheckoutOverviewPage overview =
                new CheckoutOverviewPage(driver);

        Assert.assertEquals(
                overview.getOverviewTitle(),
                "Checkout: Overview");

        overview.clickFinish();

        CheckoutCompletePage complete =
                new CheckoutCompletePage(driver);

        Assert.assertEquals(
                complete.getSuccessMessage(),
                "Thank you for your order!");

    }

}