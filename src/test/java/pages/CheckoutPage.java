package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import utils.DemoUtil;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

  

    @FindBy(id = "first-name")
    WebElement txtFirstName;

    @FindBy(id = "last-name")
    WebElement txtLastName;

    @FindBy(id = "postal-code")
    WebElement txtPostalCode;

    @FindBy(id = "continue")
    WebElement btnContinue;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

   

    @Step("Enter First Name : {0}")
    public void enterFirstName(String firstName) {

        txtFirstName.clear();
        txtFirstName.sendKeys(firstName);
        DemoUtil.demoDelay();

    }

    @Step("Enter Last Name : {0}")
    public void enterLastName(String lastName) {

        txtLastName.clear();
        txtLastName.sendKeys(lastName);
        DemoUtil.demoDelay();

    }

    @Step("Enter Postal Code : {0}")
    public void enterPostalCode(String postalCode) {

        txtPostalCode.clear();
        txtPostalCode.sendKeys(postalCode);
        DemoUtil.demoDelay();

    }

    @Step("Click Continue")
    public void clickContinue() {

        btnContinue.click();
        DemoUtil.demoDelay();

    }

    @Step("Complete Checkout Information")
    public void completeCheckout(String firstName,
                                 String lastName,
                                 String postalCode) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);

        clickContinue();

    }

    @Step("Get Validation Message")
    public String getErrorMessage() {

        return errorMessage.getText();

    }

}