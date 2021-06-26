package com.miro.elements;

import com.miro.driver.Driver;
import com.miro.utils.AutomationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class CheckBox extends PageElementModel {
    private static final Logger log = LogManager.getLogger(CheckBox.class);

    public CheckBox(By selectBy) {
        super(selectBy);
    }

    public void check(){
        log.info("ABOUT TO CHECK CHECKBOX: " + this.selectBy.toString());
        WebElement we;
        try {
            we = Driver.getWebDriver().findElement(this.selectBy);
        } catch (NoSuchElementException e) {
            String error = "ELEMENT NOT FOUND: " + this.selectBy.toString();
            log.error(error);
            throw new AutomationException(error);
        }
        if (!we.isSelected()){
            try {
                WebElement labelElement = Driver.getWebDriver().findElement(By.xpath("//label[@for='" + we.getAttribute("id") + "']"));
                labelElement.click();
            } catch (Exception e) {
                String error = "COULD NOT CLICK CHECKBOX: " + this.selectBy.toString();
                log.error(error);
                throw new AutomationException(error);
            }
        }
    }
}