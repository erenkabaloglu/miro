package com.miro.driver;

import org.openqa.selenium.WebDriver;

public class Driver {
    // Holds the WebDriver instance
    private static WebDriver webDriver;


    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        Driver.webDriver = webDriver;
    }


}
