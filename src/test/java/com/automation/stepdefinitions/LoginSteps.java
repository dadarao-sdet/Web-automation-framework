package com.automation.stepdefinitions;

import com.automation.pages.CartPage;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
public class LoginSteps {

    private  LoginPage loginpage;
    private ProductsPage productsPage;
    private CartPage cartPage;

    public LoginSteps(){
        loginpage=new LoginPage();
        productsPage = new ProductsPage();
        cartPage = new CartPage();
    }


    @Given("user opens the SauceDemo application")
    public void userOpensTheSauceDemoApplication() {
        loginpage.openApplication();
    }
    @When("user enters valid username and password")
    public void userEntersValidUsernameAndPassword() {
        loginpage.enterUsername("standard_user");
        loginpage.enterPassword("secret_sauce");
        loginpage.clickLogin();
    }
    @Then("user should be successfully logged in")
    public void userShouldBeSuccessfullyLoggedIn() {
        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Products page was not displayed after login"
        );
    }
    @Then("products should be displayed")
    public void productsShouldBeDisplayed() {
        Assert.assertTrue(
                productsPage.getProductCount() > 0,
                "No products are displayed on the Products page"
        );
    }
    @When("user adds a product to the cart")
    public void userAddsAProductToTheCart() {
        productsPage.addProductToCart();
    }
    @Then("product should be added to the cart")
    public void productShouldBeAddedToTheCart() {
        Assert.assertTrue(
                productsPage.isProductAddedToCart(),
                "Product was not added to the cart"
        );
    }
    @When("user opens the cart")
    public void userOpensTheCart() {
        cartPage.openCart();
    }
    @Then("product should be visible in the cart")
    public void productShouldBeVisibleInTheCart() {
        Assert.assertTrue(
                cartPage.isProductPresentInCart(),
                "Product is not visible in the cart"
        );
    }

    @And("user selects a product")
    public void userSelectsAProduct() {
        productsPage.selectFirstProduct();
    }

    @Then("product details should be displayed")
    public void productDetailsShouldBeDisplayed() {
        Assert.assertTrue(
                productsPage.isProductDetailsDisplayed(),
                "Product details page was not displayed"
        );
    }


}