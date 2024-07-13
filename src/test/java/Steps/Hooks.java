package Steps;

import Drivers.TestBase;
import Drivers.DriverHolder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Hooks {

    static WebDriver driver;
    @Before
    public void setup_driver(){

        driver = TestBase.getNewInstance("");
        DriverHolder.setDriver(driver);
        //set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7000));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @After
    public void quit_driver() {
        driver.quit();
    }

}
