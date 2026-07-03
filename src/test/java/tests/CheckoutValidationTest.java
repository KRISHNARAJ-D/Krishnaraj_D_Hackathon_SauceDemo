package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.*;
import pages.*;

@Epic("SauceDemo Automation")
@Feature("Checkout")
public class CheckoutValidationTest extends BaseTest {

    @Test(priority = 5)
    @Story("Checkout Validation")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify mandatory field validation and successful checkout")

    public void checkoutValidation() {

        // Login
        LoginPage login =
                new LoginPage(driver);

        login.login(
                prop.getProperty("username"),
                prop.getProperty("password"));

        ProductPage product =
                new ProductPage(driver);

        // Add Product
        product.addBackpack();

        product.openCart();

        CartPage cart =
                new CartPage(driver);

        cart.clickCheckout();

        CheckoutPage checkout =
                new CheckoutPage(driver);

        // Leave First Name Empty
        checkout.enterLastName("Raj");

        checkout.enterPostalCode("600001");

        checkout.clickContinue();

        // Verify Validation Message
        Assert.assertTrue(
                checkout.getErrorMessage()
                        .contains("First Name is required"));

        // Fill Missing Field
        checkout.enterFirstName("Krishna");

        checkout.clickContinue();

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