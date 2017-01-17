package ru.fil7.example.search;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.fil7.example.search.app.Application;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public Application app;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", System.getenv("SELENIUM_HOME") + "\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        app = new Application(driver);
    }

    @After
    public void stop() {
        driver.quit();
    }

}
