package utils.selenium;

import org.openqa.selenium.WebElement;
import utils.common.LogUtil;

public class ElementAction {
    public static void click(WebElement ele, String... eleName) {
        ele.click();
        if (!eleName[0].isEmpty()) {
            LogUtil.info(String.format("Click %s", eleName));
        }
    }

    public static void clickElementById(String id, String eleName) {
        WebElement ele = ElementLocator.findElementById(id);
        click(ele, eleName);
    }

    public static void clickElementByClassName(String className, String eleName) {
        WebElement ele = ElementLocator.findElementByClassName(className);
        click(ele, eleName);
    }

    public static void clickElementByName(String name, String eleName) {
        WebElement ele = ElementLocator.findElementByName(name);
        click(ele, eleName);
    }

    public static void clickElementByXpath(String xpath, String eleName) {
        WebElement ele = ElementLocator.findElementByXpath(xpath);
        click(ele, eleName);
    }

    public static void typeElement(WebElement ele, String value, String... eleName) {
        ele.clear();
        ele.sendKeys(value);
        String log = String.format("Type '%s'", value);
        if (!eleName[0].isEmpty()) {
            log += String.format(" into edit box '%s'", eleName[0]);
        }
        LogUtil.info(log);
    }

    public static void typeElementById(String id, String value, String... eleName) {
        WebElement element = ElementLocator.findElementById(id);
        typeElement(element, value, eleName);
    }
}