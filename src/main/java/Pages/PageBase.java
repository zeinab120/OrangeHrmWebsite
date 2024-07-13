package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class PageBase {
    WebDriver driver;

    // constructor

    public PageBase(WebDriver driver) {
        this.driver=driver;
    }

    private final By DROP_DOWN = By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
    private final By LOG_OUT = By.xpath("//li/a[text()='Logout']");
    private final By RESULT = By.xpath("    //h5[text()='Login']");

    public static WebDriverWait shortWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void fail(String message) {
        if (message == null) {
            throw new AssertionError();
        } else {
            throw new AssertionError(message);
        }
    }
    public PageBase openDropDown() {
        driver.findElement(this.DROP_DOWN).click();
        return this;
    }

    public PageBase logOut() {
        driver.findElement(this.LOG_OUT).click();
        return this;
    }

    public boolean verifyResult() {
        return driver.findElement(this.RESULT).isDisplayed();
    }

    public boolean isDisplay(By element) {
        return driver.findElement(element).isDisplayed();
    }

    protected void clickButton(By button)
    {
        driver.findElement(button).click();
    }


    protected void setTextElement(By element , String value){

        driver.findElement(element).sendKeys(value);
    }
    // TODO: Capture Screenshot
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")
                    + "/src/test/resources/screenshots/" + screenshotName + System.currentTimeMillis() + ".png"));
        } catch (WebDriverException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getText(By element) {

        return driver.findElement(element).getText();
    }


}
