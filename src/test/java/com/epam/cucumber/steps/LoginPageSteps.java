package com.epam.cucumber.steps;

import com.epam.driver.DriverManager;
import com.epam.models.User;
import com.epam.pages.InventoryPage;
import com.epam.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        driver = DriverManager.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("user logs in with username {string} and password {string}")
    public void userLogsInWithUsernameAndPassword(String username, String password) {
        User user = new User(username, password);
        loginPage.login(user);
        if(username.equals("standard_user") && password.equals("secret_sauce")) {
            inventoryPage = new InventoryPage(driver);
        }
    }

    @Then("user should see {string}")
    public void userShouldSee(String expectedResult) {
        switch(expectedResult.toLowerCase()) {
            case "products":
                Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Products page is not displayed!");
                break;
            case "error message":
                Assert.assertTrue(loginPage.errorMessageExist(), "Error message is not displayed!");
                break;
            default:
                throw new IllegalArgumentException("Unknown expectedResult: " + expectedResult);
        }
    }
}
