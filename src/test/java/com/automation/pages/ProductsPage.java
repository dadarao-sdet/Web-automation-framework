package com.automation.pages;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.automation.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductsPage {

    private static final Logger log = LoggerFactory.getLogger(ProductsPage.class);
    private WebDriver driver;
    private WaitUtils waitUtils;

    private By productsTitle = By.className("title");
    private By productItems = By.className("inventory_item");
    private By addToCartButtons = By.cssSelector("button[id^='add-to-cart']");
    private By cartBadge = By.className("shopping_cart_badge");
    private By firstProduct = By.className("inventory_item_name");
    private By productDetailsContainer = By.className("inventory_details_desc_container");

    public ProductsPage() {
        this.driver = DriverFactory.getDriver();
        this.waitUtils = new WaitUtils(driver);
    }

    public boolean isProductsPageDisplayed() {
        return waitUtils.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(productsTitle)
        ).isDisplayed();
    }

    public int getProductCount() {
        return waitUtils.getWait().until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(productItems)
        ).size();
    }
    public void addProductToCart() {

        waitUtils.getWait().until(
                ExpectedConditions.elementToBeClickable(addToCartButtons)
        ).click();

        System.out.println("Add to cart button is clicked");
    }
    public boolean isProductAddedToCart() {
        return waitUtils.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(cartBadge)
        ).isDisplayed();


    }

    public void selectFirstProduct() {
        waitUtils.getWait().until(
                ExpectedConditions.elementToBeClickable(firstProduct)
        ).click();
    }

    public boolean isProductDetailsDisplayed() {
        return waitUtils.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(productDetailsContainer)
        ).isDisplayed();
    }
}