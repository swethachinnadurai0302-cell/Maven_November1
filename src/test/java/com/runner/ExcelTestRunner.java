package com.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.ReadExcelData;

public class ExcelTestRunner {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        String username= ReadExcelData.getparticularData(3,0);
        driver.findElement(By.name("email")).sendKeys(username);
        String password=ReadExcelData.getparticularData(3,1);
        driver.findElement(By.name("pass")).sendKeys(password);
    }
}
