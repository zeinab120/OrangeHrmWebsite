package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase {
    WebDriver driver;

    // TODO: Step1: Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // TODO step2: define locators
    private final By USERNAME = By.xpath("//*[@name='username']");
    private final By passwordTxt = By.xpath("//*[@name='password']");
    private final By loginBtn = By.xpath("//button[@type='submit']");
    private final By LOGIN_MSG = By.xpath("(//*[text()='Dashboard'])[2]");
    private final By LOGIN_PAGE = By.xpath("//div[@class='orangehrm-login-slot']//h5");

    // TODO: step3 define action methods
    public void enterUserName(String userName) {
        driver.findElement(this.USERNAME).clear();
        setTextElement(USERNAME,userName);
    }
    public void enterPassword(String password) {
        driver.findElement(this.passwordTxt).clear();
        setTextElement(passwordTxt,password);
    }

    public boolean verifyLoginPage(){
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.LOGIN_PAGE));
        } catch (TimeoutException exception) {
            fail("Element not found");
        }
        System.out.println(driver.findElement(this.LOGIN_PAGE).getText());
        return getText(LOGIN_PAGE).replaceAll(" ","").contains("Login");
    }

    public void clickLoginButton() {
       clickButton(loginBtn);
    }

    public boolean successMessage(){
       return isDisplay(LOGIN_MSG);
    }

}