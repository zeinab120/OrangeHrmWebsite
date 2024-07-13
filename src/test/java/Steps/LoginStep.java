package Steps;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static Steps.Hooks.driver;
import static Pages.PageBase.captureScreenshot;

public class LoginStep {
    @Given("automationPractice website is opened")
    public void navigate_to_Login_Screen(){
        Assert.assertTrue(new LoginPage(driver).verifyLoginPage());
    }

    @When("Enter {string} as userName")
    public void userEnterValidUserName(String userName) {
        new LoginPage(driver).enterUserName(userName);
    }
    @And("Enter {string} as password")
    public void userEnterValidPassword(String password) {
        new LoginPage(driver).enterPassword(password);
    }

    @And("Click on the login button")
    public void userClickLoginButton() {
        new LoginPage(driver).clickLoginButton();
    }

    @Then("User should redirected to home page")
    public void userShallNavigateToLogin() {
        captureScreenshot(driver , "login successfully");
        Assert.assertTrue(new LoginPage(driver).successMessage());
    }
}
