import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import constants.Constants;

public class PracticalTaskTest extends BaseTestClass {
    private String[] phone = new String[]{"0", "5", "0", "3", "1", "6", "4", "7", "3", "4"};
    private String[] notCorrectPhone = new String[]{"0", "5"};
    private String pass = "14883690";
    private String expectedUserName = "Andrey";
    private String expectedPhoneError = "Некоректний телефон";
    private String expectedPassError = "Некоректний пароль";
    HomePage homePage;
    HomePage modalWindow;

    @BeforeMethod
    public void beforeMethod() {
        goToUrl(Constants.BASE_URL);
    }


    @Test()
    public void successfulLogin() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.waitUntilPageIsLoaded();

        modalWindow = homePage.clickLoginButton();
        HomePage loggedinPage = modalWindow.enterCredentials(phone, pass);
        Assert.assertEquals(loggedinPage.getUserName(), expectedUserName);
    }

    @Test
    public void notCorrectPhoneNumber() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.waitUntilPageIsLoaded();

        modalWindow = homePage.clickLoginButton();
        HomePage errorPage = modalWindow.enterCredentials(notCorrectPhone, " ");
        Assert.assertEquals(errorPage.getErrorMessage(), expectedPhoneError);
    }

    @Test
    public void notCorrectPassword() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.waitUntilPageIsLoaded();

        modalWindow = homePage.clickLoginButton();
        HomePage errorPage = modalWindow.enterCredentials(phone, "12");
        Assert.assertEquals(errorPage.getErrorMessage(), expectedPassError);
    }

}