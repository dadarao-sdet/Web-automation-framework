package com.automation.pages;

import com.automation.driver.DriverFactory;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    private By cartLink = By.className("shopping_cart_link");
    private By cartTitle = By.className("title");
    private By cartItems = By.cssSelector(".cart_item");

    public CartPage() {
        this.driver = DriverFactory.getDriver();
        this.waitUtils = new WaitUtils(driver);
    }

    public void openCart() {
        waitUtils.getWait().until(
                ExpectedConditions.elementToBeClickable(cartLink)
        ).click();

        waitUtils.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(cartTitle)
        );
    }

    public boolean isProductPresentInCart() {
        return waitUtils.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(cartItems)
        ).isDisplayed();
    }
}