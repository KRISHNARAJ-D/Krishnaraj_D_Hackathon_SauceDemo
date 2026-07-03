package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import utils.DemoUtil;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id="user-name")
    WebElement txtUsername;

    @FindBy(id="password")
    WebElement txtPassword;

    @FindBy(id="login-button")
    WebElement btnLogin;

    @FindBy(xpath="//h3[@data-test='error']")
    WebElement errorMessage;

    @Step("Enter Username")
    public void enterUsername(String username) {

        txtUsername.clear();
        txtUsername.sendKeys(username);
        
        DemoUtil.demoDelay();

    }

    @Step("Enter Password")
    public void enterPassword(String password) {

        txtPassword.clear();
        txtPassword.sendKeys(password);
        
        DemoUtil.demoDelay();

    }

    @Step("Click Login")
    public void clickLogin() {

        btnLogin.click();
        
        DemoUtil.demoDelay();

    }

    @Step("Login to Application")
    public void login(String username,String password) {

        enterUsername(username);
        enterPassword(password);
        clickLogin();

    }

    public String getErrorMessage() {

        return errorMessage.getText();

    }

}