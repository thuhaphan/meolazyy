package utils.selenium;

import global.Const;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.config.DriverManagerType.*;

public class DriverFactory {

    public static WebDriver getDriverInstance(String browserName) {
        WebDriver driver;
        switch (browserName) {
            case Const.BROWSER_CHROME:
                WebDriverManager.getInstance(CHROME).setup();
                driver = new ChromeDriver();
                break;
            case Const.BROWSER_FIREFOX:
                WebDriverManager.getInstance(FIREFOX).setup();
                driver = new FirefoxDriver();
                break;
            case Const.BROWSER_EDGE:
                WebDriverManager.getInstance(EDGE).setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new WebDriverManagerException("Invalid browser: " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Const.DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return driver;
    }
}