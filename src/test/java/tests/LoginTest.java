package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.*;
import pages.LoginPage;
import pages.ProductPage;

@Epic("SauceDemo Automation")
@Feature("Login")
public class LoginTest extends BaseTest {

    @Test(priority = 1)
    @Story("Valid Login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login using valid credentials")
    public void validLoginTest() {

        LoginPage login = new LoginPage(driver);

        login.login(
                prop.getProperty("username"),
                prop.getProperty("password"));

        ProductPage product = new ProductPage(driver);

        Assert.assertEquals(product.getPageTitle(), "Products");

    }

    @Test(priority = 2)
    @Story("Invalid Login")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify login with invalid credentials")

    public void invalidLoginTest() {

        LoginPage login = new LoginPage(driver);

        login.login("standard_user", "wrongpassword");

        Assert.assertTrue(
                login.getErrorMessage().contains("Epic sadface"));

    }

}