package object.pages;

import global.Const;
import object.PagesFactory;
import object.pages.authentication.LoginPage;
import org.openqa.selenium.WebElement;
import utils.common.LogUtil;
import utils.selenium.ElementAction;
import utils.selenium.ElementLocator;

public class HomePage extends BasePage {

    public HomePage () {
        eleRepo.loadFile(Const.OBJ_HOME_PAGE);
    }

    /*
     * PUBLIC ACTIONS
     */

    public LoginPage clickSignOutButton () {
        ElementAction.clickElementByXpath(eleRepo.get("logout_button_xpath"), "Sign out button");
        return PagesFactory.getLoginPage();
    }

    /*
     * PUBLIC EXPECTATIONS
     */

    public String seeLoginSuccessMessage (String successMessage) {
        WebElement eleSuccessMessage = ElementLocator.findElementByXpath(eleRepo.get("login_success_message_xpath"));
        String actualMessage = eleSuccessMessage.getText();
        boolean result = actualMessage.equals(successMessage);
        String log = String.format("[Expectation] See success message '%s': %b", successMessage, result);

        if (result) {
            LogUtil.info(log);
        } else {
            LogUtil.error(log + String.format("(Actual: '%s')", actualMessage));
        }
        return actualMessage;
    }
}