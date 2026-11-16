package com.base;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Base_Class {
    public static WebDriver driver;

    protected static WebDriver launchBrowser(String browserName) {
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }

        } catch (Exception e) {

            Assert.fail("ERROR : OCCURE DURING LAUNCH");
        }
        driver.manage().window().maximize();
        return driver;

    }
    protected static void launchurl(String url){
        try{
            driver.get(url);
        }catch (Exception e){
            Assert.fail("ERROR : OCCURE DURING LAUNCH");
        }
    }
    protected static void passInput(WebElement element,String value){
        try{
            element.sendKeys(value);
        }catch (Exception e){
            Assert.fail("ERROR : OCCURE DURING LAUNCH");
        }
    }
    protected static void clickOnEllement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURE DURING LAUNCH");
        }
    }
     protected static void browserTermination(){
        try {
            driver.quit();
        }catch (Exception e){
            Assert.fail("ERROR : OCCURE DURING LAUNCH");
        }
    }
    protected static void windowHandles(int num) {
        try {
            List<String> allWindows = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(allWindows.get(num));

        } catch (Exception e) {
            Assert.fail("ERROR : OCCURE DURING WINDOW HANDLES");
        }
    }

    protected static void selectOptions(WebElement element, String type, String value) {
        Select select = new Select(element);
        try {
            if (type.equalsIgnoreCase("value")) {
                select.selectByValue(value);
            } else if (type.equalsIgnoreCase("index")) {
                select.selectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("text")) {
                select.selectByVisibleText(value);
            }

        } catch (Exception e) {
            Assert.fail("ERROR : OCCURE DURING SELECT OPTIONS");
        }
    }

    protected static void deSelectOptions(WebElement element, String type, String value) {
        Select select = new Select(element);
        try {
            if (type.equalsIgnoreCase("value")) {
                select.deselectByValue(value);
            } else if (type.equalsIgnoreCase("index")) {
                select.deselectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("text")) {
                select.deselectByVisibleText(value);
            }

        } catch (Exception e) {
            Assert.fail("ERROR : OCCURE DURING DESELECT OPTIONS");
        }
    }
}