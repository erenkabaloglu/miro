package com.miro.driver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    public static WebDriver getDriver() {

        //Driver is choosen according to browser argument. As an example i have added
        //chrome driver and firefox driver. Other driver types also can be added
        String browser = System.getProperty("browser", "chrome");

        //Test can run in headless mode if headless argument is set to y
        boolean headless = "y".equalsIgnoreCase(System.getProperty("headless", "n"));

        switch (browser) {
            case "firefox":
                FirefoxDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(headless);
                return new FirefoxDriver(firefoxOptions);
            case "chrome":
            default:
                ChromeDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--disable-gpu");
                }

                return new ChromeDriver(chromeOptions);
        }
    }
}
