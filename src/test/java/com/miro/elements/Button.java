package com.miro.elements;

import com.miro.driver.Driver;
import com.miro.utils.AutomationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Button extends PageElementModel {
    private static final Logger log = LogManager.getLogger(Button.class);

    public Button(By selectBy) {
        super(selectBy);
    }

    public void click(){
        log.info("ABOUT TO CLICK BUTTON " + this.selectBy.toString());
        WebElement we;
        try {
            we = Driver.getWebDriver().findElement(this.selectBy);
        } catch (NoSuchElementException e){
            String error = "ELEMENT NOT FOUND: " + this.selectBy.toString();
            log.error(error);
            throw new AutomationException(error);
        }
        try {
            we.click();
        } catch (Exception e) {
            String error = "COULD NOT CLICK BUTTON: " + this.selectBy.toString();
            log.error(error);
            throw new AutomationException(error);
        }
    }

    public void waitUntilVisibleAndClick(int... timeOut){
        log.info("WAITING FOR CLICK BUTTON " + this.selectBy.toString());
        waitUntilVisible(timeOut);
        click();
    }
}
