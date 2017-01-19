package ru.fil7.example.search;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.fil7.example.search.app.Application;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static final int TIMEOUT = 10;

    public WebDriver driver;
    public WebDriverWait wait;
    public Application app;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, TIMEOUT);
        app = new Application(driver);
    }

    @After
    public void stop() {
        driver.quit();
    }

}
