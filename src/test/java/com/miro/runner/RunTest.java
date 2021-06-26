package com.miro.runner;

import com.miro.driver.Driver;
import com.miro.driver.DriverFactory;
import com.miro.utils.PropertyUtil;
import com.miro.utils.StoreUtil;
import com.miro.utils.TranslationUtil;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"}, glue = "com.miro.stepdefs", tags = "not @ignore")
public class RunTest {

    // Initialize a webDriver instance of required browser
    // jUnit hooks used since there is no equivalent before/after all cucumber hook
    @BeforeClass
    public static void initializeDriver(){
        Driver.setWebDriver(DriverFactory.getDriver());

        //load environment specific prperties, currently production/live environment is the only environment but it may extend to other testing environments
        PropertyUtil.loadProperties();

        //Signup page is english only but to provide language support in the future I read texts from language files
        //If a new language is added we can add its language definition under environment foler
        TranslationUtil.loadLanguageDefs();

        //variables are kept in a store to use them between different steps, for memory usage store is initialized before suite and
        //cleared after suite
        StoreUtil.initializeStore();
    }

    // Close the webDriver instance
    @AfterClass
    public static void closeDriver(){
        StoreUtil.clearStore();
        Driver.getWebDriver().quit();
    }
}
