package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import utils.DemoUtil;

public class CheckoutCompletePage {

    WebDriver driver;

    public CheckoutCompletePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(className = "complete-header")
    WebElement successMessage;

    @FindBy(className = "complete-text")
    WebElement successDescription;

    @FindBy(id = "back-to-products")
    WebElement backHome;



    @Step("Verify Order Success Message")
    public String getSuccessMessage() {

        return successMessage.getText();

    }

    @Step("Verify Success Description")
    public String getSuccessDescription() {

        return successDescription.getText();

    }

    @Step("Back To Products")
    public void backHome() {

        backHome.click();
        DemoUtil.demoDelay();

    }

}