package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import utils.DemoUtil;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(className = "title")
    WebElement pageTitle;

  
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement backpack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement boltShirt;

    // Remove Backpack
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpack;

    // Cart
    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    // Menu
    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    WebElement logout;


    @Step("Verify Products Page")
    public String getPageTitle() {

        return pageTitle.getText();

    }

    @Step("Add Sauce Labs Backpack")
    public void addBackpack() {

        backpack.click();
        DemoUtil.demoDelay();

    }

    @Step("Add Bike Light")
    public void addBikeLight() {

        bikeLight.click();
        DemoUtil.demoDelay();

    }

    @Step("Add Bolt T-Shirt")
    public void addBoltShirt() {

        boltShirt.click();
        DemoUtil.demoDelay();

    }

    @Step("Remove Backpack")
    public void removeBackpack() {

        removeBackpack.click();
        DemoUtil.demoDelay();

    }

    @Step("Open Cart")
    public void openCart() {

        cartIcon.click();
        DemoUtil.demoDelay();

    }

    @Step("Verify Cart Count")
    public String getCartCount() {

        return cartBadge.getText();

    }

    @Step("Logout from Application")
    public void logout() {

        menuButton.click();
        DemoUtil.demoDelay();

        logout.click();
        DemoUtil.demoDelay();

    }

}