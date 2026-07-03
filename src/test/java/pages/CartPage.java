package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import utils.DemoUtil;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//div[text()='Sauce Labs Backpack']")
    WebElement backpack;

    @FindBy(id="remove-sauce-labs-backpack")
    WebElement removeBackpack;

    @FindBy(id="continue-shopping")
    WebElement continueShopping;

    @FindBy(id="checkout")
    WebElement checkout;

    @Step("Verify Backpack")
    public boolean verifyBackpack() {

        return backpack.isDisplayed();
        
        

    }

    @Step("Remove Backpack")
    public void removeBackpack() {

        removeBackpack.click();
        DemoUtil.demoDelay();

    }

    @Step("Continue Shopping")
    public void continueShopping() {

        continueShopping.click();
        
        DemoUtil.demoDelay();

    }

    @Step("Click Checkout")
    public void clickCheckout() {

        checkout.click();
        DemoUtil.demoDelay();

    }

}