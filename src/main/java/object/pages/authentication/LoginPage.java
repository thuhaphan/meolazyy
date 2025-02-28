package object.pages.authentication;

import global.Const;
import object.PagesFactory;
import object.pages.BasePage;
import object.pages.HomePage;
import org.openqa.selenium.WebElement;
import utils.common.LogUtil;
import utils.selenium.ElementAction;
import utils.selenium.ElementLocator;

public class LoginPage extends BasePage {

    public LoginPage(){
        eleRepo.loadFile(Const.OBJ_LOGIN_PAGE);
    }

    /* PUBLIC ACTIONS */
    public LoginPage typeEmail(String username) {
        ElementAction.typeElementById(eleRepo.get("username_input_id"), username, "Username");
        return this;
    }

    public LoginPage typePassword(String password) {
        ElementAction.typeElementById(eleRepo.get("password_input_id"), password, "Password");
        return this;
    }

    public LoginPage clickSubmitButton() {
        ElementAction.clickElementById(eleRepo.get("submit_button_id"), "Submit button");
        return this;
    }

    public HomePage clickSubmitButtonShowingHomePage () {
        clickSubmitButton();
        return PagesFactory.getHomePage();
    }

    public String seeErrorMessage(String msg) {
        WebElement ele = ElementLocator.findElementByXpath(eleRepo.get("error_message_xpath"));
        String actualMessage = ele.getText();
        boolean result = actualMessage.equals(msg);
        String log = String.format("[Expectation] See error message '%s': %b", msg, result);

        if (result) {
            LogUtil.info(log);
        } else {
            LogUtil.info(log + String.format(" (actual: '%s')", actualMessage));
        }

        return actualMessage;
    }
}