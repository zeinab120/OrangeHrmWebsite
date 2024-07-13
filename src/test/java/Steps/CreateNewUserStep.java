package Steps;

import Pages.AdminPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import Pages.PageBase;

import static Steps.Hooks.driver;
import static Pages.PageBase.captureScreenshot;
import static util.Utility.getRandomFirstName;

public class CreateNewUserStep {
    static String password= "P@ssw0rd123";
    static String name= getRandomFirstName()+ " "+getRandomFirstName();

    @Given("User click on Admin tab")
    public void OpenAdminPage(){
        new AdminPage(driver).openAdminPage();
        captureScreenshot(driver , "Open Admin Page");
        Assert.assertTrue(new AdminPage(driver).verifyAdminPageHeader());
    }

    @When("User Get Numbers Of Records")
    public void getNumbersOfRecords() {
        captureScreenshot(driver , "Numbers Of Current Records");
        new AdminPage(driver).getNumberOfRecords();

    }
    @Then("User Log out")
    public void UserLogout() {
        new PageBase(driver).openDropDown().logOut();
        captureScreenshot(driver , " Log out page");
        Assert.assertTrue(new PageBase(driver).verifyResult());
    }

    @When("Add New User")
    public void addNewUser() throws InterruptedException {
        new AdminPage(driver).clickAddBtn().openRoleDropDown().selectUserRole().
                selectStatus().enterPassword(password)
                .enterEmployeeName("Ti").
                enterUserName(name).confirmPassword(password).
                saveBtn();
        captureScreenshot(driver , "Add New User");
        Assert.assertTrue(new AdminPage(driver).verifyAdminPageHeader());

    }
    @And("User Get Numbers Of Records Increase By One")
    public void getNumbersOfRecordsIncreaseByOne() {
        new AdminPage(driver).getNumberOfIncreasedRecords();
        captureScreenshot(driver , "Result Table After Creating New User");
    }

    @And("User Search With User")
    public void userSearchWithUser() throws InterruptedException {
        new AdminPage(driver).openAdminPage();
        new AdminPage(driver).searchByUserName(name).searchBtn();
        captureScreenshot(driver , "Search With New Created User");

    }

    @And("User Verify Search Result")
    public void verifySearchResult() {
        new AdminPage(driver).getUserNameDisplay(name);
        captureScreenshot(driver, "Verify Result Search");
        Assert.assertEquals(new AdminPage(driver).getUserNameDisplay(name), name);
    }

    @And("User Delete User")
    public void deleteUser() throws InterruptedException {
        new AdminPage(driver).deleteUser();
        captureScreenshot(driver, "Msg To Delete User");
        Assert.assertTrue(new AdminPage(driver).verifyDeleteMsg("The selected record will be permanently deleted. Are you sure you want to continue?"));
        new AdminPage(driver).confirmDeleteUser();
        captureScreenshot(driver, "delete user");
    }

    }

