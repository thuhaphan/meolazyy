package strategies.smoke;

import object.pages.HomePage;
import object.pages.authentication.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import strategies.BaseTest;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        loginPage = new LoginPage();
    }

    @Test(description = "Login failed with an invalid credential")
    public void loginFailed() {
        //Test data
        testData = dataReader.get("TC01");
        final String EMAIL = (String) testData.get("username");
        final String PASSWORD = (String) testData.get("password");
        final String ERROR_MSG = (String) testData.get("errorMessage");

        loginPage.typeEmail(EMAIL)
                .typePassword(PASSWORD)
                .clickSubmitButton();
        Assert.assertEquals(loginPage.seeErrorMessage(ERROR_MSG), ERROR_MSG);
    }

    @Test(description = "Login passed with a valid credential")
    public void loginPassed() {
        //Test data
        testData = dataReader.get("TC02");
        final String EMAIL = (String) testData.get("username");
        final String PASSWORD = (String) testData.get("password");
        final String SUCCESS_MSG = (String) testData.get("successMessage");

        HomePage homePage = loginPage.typeEmail(EMAIL)
                .typePassword(PASSWORD)
                .clickSubmitButtonShowingHomePage();

        Assert.assertEquals(homePage.seeLoginSuccessMessage(SUCCESS_MSG), SUCCESS_MSG);

        homePage.clickSignOutButton();
    }
}
