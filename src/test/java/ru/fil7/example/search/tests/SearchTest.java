package ru.fil7.example.search.tests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.fil7.example.search.TestBase;

import java.util.List;
import java.util.ResourceBundle;

public class SearchTest extends TestBase {

    ResourceBundle testData = ResourceBundle.getBundle("test-data");

    private String cityName;
    private String regionName;
    private String personName;

    @Before
    public void init() {
        cityName = testData.getString("city.name");
        regionName = testData.getString("region.name");
        personName = testData.getString("person.name");
    }

    @Test
    public void testSearchOfPersonWhenRegionAndCityAreSelectedOnAutoDetectPanel() {
        driver.get(app.mainPage.URL);

        app.mainPage.btnSelectRegion.click();
        app.mainPage.selectRegionAndCity(regionName, cityName);
        app.mainPage.searchOfPerson(personName);

        List<WebElement> foundPersons = driver.findElements(By.xpath(
                String.format("//a[contains(text(), '%s')]", personName)));
        Assert.assertTrue(String.format("Should be found person with name %s", personName),foundPersons.size() > 0);
    }

    @Test
    public void testSearchOfPersonWhenRegionAndCityAreSelectedOnMainPage() {
        driver.get(app.mainPage.URL);

        app.mainPage.btnCloseAutoDetect.click();
        // wait for autoDetectCity-form to disappear
        wait.until(
                ExpectedConditions.not(
                        ExpectedConditions.visibilityOf(app.mainPage.btnCloseAutoDetect)));
        app.mainPage.linkSelectAnotherRegion.click();
        app.mainPage.selectRegionAndCity(regionName, cityName);

        app.mainPage.searchOfPerson(personName);

        List<WebElement> foundPersons = driver.findElements(By.xpath(
                String.format("//a[contains(text(), '%s')]", personName)));
        Assert.assertTrue(String.format("Should be found person with name %s", personName),foundPersons.size() > 0);
    }

}
