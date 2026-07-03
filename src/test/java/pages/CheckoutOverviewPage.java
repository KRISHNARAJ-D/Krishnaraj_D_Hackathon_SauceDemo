package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import utils.DemoUtil;

public class CheckoutOverviewPage {

    WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(className = "title")
    WebElement overviewTitle;

    @FindBy(id = "finish")
    WebElement btnFinish;

    @FindBy(className = "summary_total_label")
    WebElement totalAmount;


    @Step("Verify Checkout Overview Page")
    public String getOverviewTitle() {

        return overviewTitle.getText();

    }

    @Step("Get Total Amount")
    public String getTotalAmount() {

        return totalAmount.getText();

    }

    @Step("Click Finish")
    public void clickFinish() {

        btnFinish.click();
        DemoUtil.demoDelay();

    }

}