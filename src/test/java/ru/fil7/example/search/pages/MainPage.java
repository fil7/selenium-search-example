package ru.fil7.example.search.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends Page {

    @FindBy(css = "a.autoDetCity-select")
    public WebElement autoSelectRegion;

    @FindBy(name = "search_block_form")
    public WebElement searchField;

    @FindBy(css = "div.chooseRegionAndCity")
    public WebElement regionMap;

    public By resultSearchTitle = By.cssSelector("#page-title");

    public static final String URL = "http://www.moypolk.ru/";


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectRegion(String regionName, String cityName) {
        autoSelectRegion.click();
        driver.findElement(By.partialLinkText(regionName))
                .click();
        driver.findElement(By.partialLinkText(cityName))
                .click();
    }


    public void searchOfPerson(String personName) {
        wait.until(
                ExpectedConditions.not(
                        ExpectedConditions.visibilityOf(regionMap)));
        searchField.clear();
        searchField.sendKeys(personName + Keys.ENTER);
        wait.until(
                ExpectedConditions.visibilityOf(driver.findElement(resultSearchTitle)));
    }
}
