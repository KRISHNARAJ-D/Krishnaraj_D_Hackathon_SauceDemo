package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.*;
import pages.*;

@Epic("SauceDemo Automation")
@Feature("Purchase")
public class PurchaseTest extends BaseTest {

    @Test(priority = 3)
    @Story("End-to-End Purchase")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify end-to-end purchase flow from login to order confirmation") //SD_UI_001

    public void purchaseProduct() {

        LoginPage login = new LoginPage(driver);

        login.login(
                prop.getProperty("username"),
                prop.getProperty("password"));

        ProductPage product = new ProductPage(driver);

        product.addBackpack();

        product.openCart();

        CartPage cart = new CartPage(driver);

        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);

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