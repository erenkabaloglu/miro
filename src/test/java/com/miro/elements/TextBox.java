package com.miro.elements;

import com.miro.driver.Driver;
import com.miro.utils.AutomationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class TextBox extends PageElementModel {

    private static final Logger log = LogManager.getLogger(TextBox.class);

    public TextBox(By selectBy) {
        super(selectBy);
    }

    public void type(String inputText){
        log.info("ABOUT TO TYPE TEXTBOX " + this.selectBy.toString());
        if(inputText == null)
            return;
        WebElement we;
        try {
            we = Driver.getWebDriver().findElement(this.selectBy);
        } catch (NoSuchElementException e){
            String error = "ELEMENT NOT FOUND: " + this.selectBy.toString();
            log.error(error);
            throw new AutomationException(error);
        }
        try {
            we.sendKeys(inputText);
        } catch (Exception e) {
            String error = "COULD NOT TYPE TEXTBOX: " + this.selectBy.toString() + " TEXT IS: " + inputText;
            log.error(error);
            throw new AutomationException(error);
        }
    }

    public void waitUntilVisibleAndType(String inputText, int... timeOut){
        log.info("WAITING FOR TEXTBOX: " + this.selectBy.toString());
        waitUntilVisible(timeOut);
        type(inputText);
    }

    public void clearText(){
        log.info("ABOUT TO CLEAR TEXTBOX " + this.selectBy.toString());
        WebElement we;
        try {
            we = Driver.getWebDriver().findElement(this.selectBy);
        } catch (NoSuchElementException e){
            String error = "ELEMENT NOT FOUND: " + this.selectBy.toString();
            log.error(error);
            throw new AutomationException(error);
        }
        we.clear();
    }
}
