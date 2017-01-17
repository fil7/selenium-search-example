package ru.fil7.example.search.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public static final int TIMEOUT = 10;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT);
    }

    public boolean isElementPresent(By locator, WebElement context) {
        try {
            if (context != null) {
                context.findElement(locator);
                return true;
            }
            return false;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }

    }

    public boolean isElementNotPresent(WebDriver driver, By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            return driver.findElements(locator).size() == 0;
        } finally {
            driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        }
    }

    public static boolean areElementsPresent(By locator, WebElement context) {
        return context.findElements(locator).size() > 0;
    }

    public static boolean areElementsPresent(By locator, WebDriver driver) {
        return driver.findElements(locator).size() > 0;
    }




}
