package com.miro.elements;

import com.miro.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Base class for page elements such as button, textbox, selectbox...
//Keeps the common methods for elements
public abstract class PageElementModel {
    protected By selectBy;

    public PageElementModel(By selectBy) {
        this.selectBy = selectBy;
    }

    public void waitUntilVisible(int... timeOut){
        int timeOutI = 30;
        if (timeOut.length != 0){
            timeOutI = timeOut[0];
        }
        WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), timeOutI);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectBy));
    }

    public boolean isDisplayed(){
        try {
            return Driver.getWebDriver().findElement(selectBy).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

}
