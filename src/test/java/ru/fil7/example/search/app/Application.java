package ru.fil7.example.search.app;

import org.openqa.selenium.WebDriver;
import ru.fil7.example.search.pages.MainPage;

public class Application {

    private WebDriver driver;

    public MainPage mainPage;

    public Application(WebDriver driver) {
        this.driver = driver;
        initPages(driver);
    }

    private void initPages(WebDriver driver) {
        mainPage = new MainPage(driver);
    }
}
