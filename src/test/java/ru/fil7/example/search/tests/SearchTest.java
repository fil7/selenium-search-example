package ru.fil7.example.search.tests;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.fil7.example.search.TestBase;

import java.util.List;
import java.util.ResourceBundle;

public class SearchTest extends TestBase {

    ResourceBundle testData = ResourceBundle.getBundle("test-data");

    @Test
    public void testSearchOfPerson() {
        driver.get(app.mainPage.URL);

        String cityName = testData.getString("city.name");
        String regionName = testData.getString("region.name");
        String personName = testData.getString("person.name");

        app.mainPage.selectRegion(regionName, cityName);
        app.mainPage.searchOfPerson(personName);

        List<WebElement> foundPersons = driver.findElements(By.xpath(
                String.format("//a[contains(text(), '%s')]", personName)));
        Assert.assertTrue(String.format("Should be found person with name %s", personName),foundPersons.size() > 0);
    }
}
