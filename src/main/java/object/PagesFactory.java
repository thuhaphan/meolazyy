package object;

import global.Const;
import object.pages.BasePage;
import object.pages.HomePage;
import object.pages.authentication.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.common.ConfigReader;
import utils.common.LogUtil;
import utils.selenium.ElementLocator;

public class PagesFactory {

    private static WebDriver driver;
    private static ConfigReader config;

    private enum Locators {
        ID,
        CLASS_NAME,
        CSS,
        XPATH
    }

    public static void init(WebDriver pDriver) {
        driver = pDriver;
        config = new ConfigReader();
        config.loadFile(Const.PAGES_WAITING);
    }

    private static <TPage extends BasePage> TPage getPage(Class<TPage> pageClass, Locators locator, String value, String page){
        try {

            WebElement element = null;
            switch (locator){
                case ID:
                    element = ElementLocator.findElementById(value);
                    break;
                case CLASS_NAME:
                    element = ElementLocator.findElementByClassName(value);
                    break;
                case CSS:
                    element = ElementLocator.findElementByCss(value);
                    break;
                case XPATH:
                    element = ElementLocator.findElementByXpath(value);
                    break;
                default:
                    try {
                        throw new Exception("Invalid locator");
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
            }
            if (element != null){
                LogUtil.info("You are now on page " + page);
                return PageFactory.initElements(driver, pageClass);
            }
        } catch (Exception ex) {
            String log = String.format("Your are NOT on page %s (element not found with locator %s: %s)", page, locator.toString(), value);
            LogUtil.error(log);
        }
        return null;
    }
    public static LoginPage getLoginPage() {
        return getPage(LoginPage.class, Locators.ID, config.get("login_page_id"), "Login");
    }

    public static HomePage getHomePage() {
        return getPage(HomePage.class, Locators.XPATH, config.get("home_page_xpath"), "Home Page");
    }
}