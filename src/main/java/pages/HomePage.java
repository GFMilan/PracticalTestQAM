package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(css = ".auth-popup-button")
    private WebElement loginButton;

    @FindBy(id = "modal-login-phone-field")
    private WebElement phoneInput;

    @FindBy(id = "modal-login-password-field")
    private WebElement passwordInput;

    @FindBy(css = ".br-login-submit")
    private WebElement submitButton;

    @FindBy(css = ".user-panel-button")
    private WebElement userName;

    @FindBy(css = ".login-error")
    private WebElement errorMessage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(this.driver, this);
    }

    public  HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage(driver);
    }


    public HomePage enterPhone(String[] phone) throws InterruptedException {
        for (String digit: phone) {
            phoneInput.sendKeys(digit);
        Thread.sleep(400);
        }
       phoneInput.sendKeys(phone);
        return this;
    }

        public HomePage enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public  HomePage clickSubmitButton() {
        submitButton.click();
        return new HomePage(driver);
    }


    public HomePage waitUntilPageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

    public HomePage enterCredentials(String[] phone, String password) throws InterruptedException {
        enterPhone(phone)
                .enterPassword(password)
                .clickSubmitButton();
        return new HomePage(driver);
    }

    public String getUserName() {
        wait.until(ExpectedConditions.visibilityOf(userName));
        return userName.getText();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }


}