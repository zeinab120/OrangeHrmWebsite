package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AdminPage extends PageBase {
    WebDriver driver;

    public static int numRecords;
    public static int increaseNumRecords;
    public static String userName;


    // TODO: Step1: Constructor
    public AdminPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // TODO step2: define locators
    private final By adminTab = By.xpath("//span[normalize-space()='Admin']");
    private final By ADMIN_HEADER1 = By.xpath("//span[@class='oxd-topbar-header-breadcrumb']//h6[contains(@class,'breadcrumb-module')]");
    private final By ADMIN_HEADER2 = By.xpath("//span[@class='oxd-topbar-header-breadcrumb']//h6[contains(@class,'breadcrumb-level')]");
    private final By userRoleDropDown = By.xpath("(//div[text()='-- Select --'])[1]");
    private final By USER_ROLE = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    private final By STATUS = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
    private final By searchBtn = By.xpath("//button[@type='submit']");
    private final By addBtn = By.xpath("//button[normalize-space()='Add']");
    private final By EMPLOYEE_NAME = By.xpath("//input[@placeholder='Type for hints...']");
    private final By USERNAME = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By PASSWORD = By.xpath("(//input[@type='password'])[1]");
    private final By CONFIRM_PASSWORD = By.xpath("(//input[@type='password'])[2]");
    private final By SAVE_BTN = By.xpath("//button[@type='submit']");
    private final By USER_NAME = By.xpath("(//input[contains(@class,'oxd-input--active')])[2]");
    private final By deleteBtn = By.xpath("(//button[contains(@class,'oxd-table-cell-action-space')])[1]");
    private final By CONFIRM_DELETE_BTN = By.xpath("//button[contains(@class,'oxd-button--label-danger')]");
    private final By deleteMsg = By.xpath("//p[contains(@class,'oxd-text--card-body')]");


    // TODO: step3 define action methods
    public void getNumberOfRecords() {
        List<WebElement> rows = driver.findElements(By.xpath("//div[@role='row']"));
        // Get the number of rows (which represents the number of records)
         numRecords = (rows.size())-1;
        System.out.println("Number of records: " + numRecords);
    }

    public void getNumberOfIncreasedRecords() {
        List<WebElement> rows = driver.findElements(By.xpath("//div[@role='row']"));
        // Get the number of rows (which represents the number of records)
         increaseNumRecords = (rows.size())-1;
        System.out.println("Number of records after create new user: " + increaseNumRecords);
    }


    public void openAdminPage() {
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.adminTab));
        } catch (TimeoutException exception) {
            fail("Element not found");
        }
        clickButton(adminTab);
    }


    public boolean verifyAdminPageHeader() {
        System.out.println(driver.findElement(this.ADMIN_HEADER1).getText()+"/ "+
                driver.findElement(this.ADMIN_HEADER2).getText());
        return isDisplay(this.ADMIN_HEADER1);
    }

    public boolean verifyDeleteMsg(String msg) {
        System.out.println(getText(deleteMsg));
        return getText(deleteMsg).contains(msg) ;
    }


    public AdminPage openRoleDropDown() {
       clickButton(userRoleDropDown);
        return this;
    }

    public AdminPage selectUserRole() {
        driver.findElement(this.USER_ROLE).sendKeys(Keys.ARROW_UP);
        driver.findElement(this.USER_ROLE).sendKeys(Keys.ENTER);
        return this;
    }


    public AdminPage selectStatus() {
        driver.findElement(this.STATUS).sendKeys(Keys.ARROW_UP);
        driver.findElement(this.STATUS).sendKeys(Keys.ENTER);
        return this;
    }

    public AdminPage searchBtn() {
        clickButton(searchBtn);
        return this;
    }

    public String getUserNameDisplay(String name) {
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]")).getText());
        userName = driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]")).getText();
        return userName;
    }


    public AdminPage clickAddBtn() {
        clickButton(addBtn);
        return this;
    }

    public AdminPage enterEmployeeName(String name) throws InterruptedException {
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.EMPLOYEE_NAME));
        } catch (TimeoutException exception) {
            fail("Element not found");
        }

        driver.findElement(this.EMPLOYEE_NAME).sendKeys(name);
        Thread.sleep(5000);
        Actions actions1 = new Actions(driver);
        actions1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        return this;

    }

    public AdminPage enterUserName(String userName) {
        driver.findElement(this.USERNAME).clear();
        driver.findElement(this.USERNAME).sendKeys(userName);
        return this;
    }

    public AdminPage enterPassword(String password) {
        driver.findElement(this.PASSWORD).clear();
        driver.findElement(this.PASSWORD).sendKeys(password);
        return this;
    }

    public AdminPage confirmPassword(String password) {
        driver.findElement(this.CONFIRM_PASSWORD).sendKeys(password);
        return this;
    }

    public AdminPage saveBtn() {
        driver.findElement(this.SAVE_BTN).click();
        return this;
    }

    public AdminPage searchByUserName(String userName){
        try
        {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.USER_NAME));
        }
        catch (TimeoutException exception) {
            fail("Element not found");
        }
        driver.findElement(this.USER_NAME).sendKeys(userName);
        return this;
    }

    public AdminPage deleteUser() throws InterruptedException {
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.deleteBtn));
        } catch (TimeoutException exception) {
            fail("Element not found");
        }

        driver.findElement(this.deleteBtn).click();
        return this;
    }

    public AdminPage confirmDeleteUser() throws InterruptedException {
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.CONFIRM_DELETE_BTN));
        } catch (TimeoutException exception) {
            fail("Element not found");
        }
        driver.findElement(this.CONFIRM_DELETE_BTN).click();
        return this;
    }


}