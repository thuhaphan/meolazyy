package strategies;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.common.LogUtil;

import java.util.concurrent.TimeUnit;

public class InitialScenario {
    public static void main(String[] args) {
        // Create a new instance of the Chrome driver
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the website URL
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Login with an invalid username and password
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password1233");
        driver.findElement(By.id("submit")).click();

        try {
            // Verify an error message is displayed
            String expectedError = "Your password is invalid!";
            String actualError = driver.findElement(By.xpath("//div[text() = 'Your password is invalid!']")).getText();
            if (expectedError.equals(actualError)) {
                LogUtil.info("Error is displayed correctly: " + actualError);
            } else {
                LogUtil.info("Error is NOT displayed! Expected error: " + expectedError + ", Actual error: " + actualError);
            }
        } catch (NoSuchElementException e) {
            LogUtil.info("Error message not found as expected.");
        } finally {
            // Close the browser window in any case
            driver.quit();
        }
    }
}