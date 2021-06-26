package com.miro.elements;

import com.miro.driver.Driver;
import org.openqa.selenium.By;

public class Label extends PageElementModel {

    public Label(By selectBy) {
        super(selectBy);
    }

    public String getLabelText(){
        return Driver.getWebDriver().findElement(this.selectBy).getText();
    }
}
