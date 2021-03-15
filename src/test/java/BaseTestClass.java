import constants.Constants;
import driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTestClass {
    protected WebDriver driver = null;

    @BeforeSuite
    public void beforeSuite(){

        driver = WebDriverFactory.initDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    @AfterSuite
    public void afterSuite() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public void goToUrl() {
        goToUrl(Constants.BASE_URL);
    }
}