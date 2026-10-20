package com.automation.pages;
import org.openqa.selenium.WebElement;
import com.automation.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automation.utils.WaitUtils;
import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");


    public LoginPage() {
        this.driver = DriverFactory.getDriver();
        this.waitUtils = new WaitUtils(driver);
    }
    public void openApplication() {
        driver.get("https://www.saucedemo.com/");
    }
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isProductsPageDisplayed() {
        return waitUtils.getWait().until(
                ExpectedConditions.urlContains("inventory.html")
        );
    }
}
