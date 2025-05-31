package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InventoryPage;
import pages.LoginPage;

import static org.junit.Assert.*;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("User is on the login page")
    public void user_is_on_login_page() {
        assertTrue(driver.getCurrentUrl().contains("saucedemo"));
    }

    @When("User enters valid username and password")
    public void user_enters_valid_credentials() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @When("User enters invalid username and password")
    public void user_enters_invalid_credentials() {
        loginPage.enterUsername("invalid");
        loginPage.enterPassword("invalid");
    }

    @When("User enters empty username and valid password")
    public void user_enters_empty_username() {
        loginPage.enterUsername("");
        loginPage.enterPassword("secret_sauce");
    }

    @When("Clicks the login button")
    public void clicks_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should be redirected to the inventory page")
    public void redirected_to_inventory() {
        inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.isInventoryDisplayed());
    }

    @Then("An error message should be displayed")
    public void error_message_displayed() {
        assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));
    }
}
