package com.miro.elements;

import com.miro.driver.Driver;
import com.miro.utils.AutomationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class SelectBox extends PageElementModel {
    private static final Logger log = LogManager.getLogger(SelectBox.class);

    private static final By TITLE_ELEMENT = By.className("speero-dropdown__title");
    private static final By OPTION_ELEMENTS = By.className("speero-dropdown__menu-item");

    public SelectBox(By selectBy) {
        super(selectBy);
    }

    public void selectByText(String text){
        log.info("ABOUT TO SELECT: " + this.selectBy.toString());
        if(text == null)
            return;
        WebElement we;
        try {
            we = Driver.getWebDriver().findElement(this.selectBy);
        } catch (NoSuchElementException e){
            String error = "ELEMENT NOT FOUND: " + this.selectBy.toString();
            log.error(error);
            throw new AutomationException(error);
        }
        WebElement titleElement = we.findElement(TITLE_ELEMENT);
        try {
            titleElement.click();
        } catch (Exception e) {
            String error = "COULD NOT CLICK TO " + TITLE_ELEMENT.toString();
            log.error(error);
            throw new AutomationException(error);
        }
        List<WebElement> foundOptions = we.findElements(OPTION_ELEMENTS)
                .stream()
                .filter((WebElement optionElement) -> optionElement.getText().equals(text))
                .collect(Collectors.toList());
        if(foundOptions.size() == 0){
            throw new AutomationException("NO SUCH OPTION " + text);
        }
        try {
            foundOptions.get(0).click();
        } catch (Exception e) {
            String error = "COULD NOT CLICK TO OPTION" + foundOptions.get(0).toString();
            log.error(error);
            throw new AutomationException(error);
        }

    }

    public void waitUntilAndSelectByText(String text){
        log.info("WAITING FOR SELECT: " + this.selectBy.toString());
        waitUntilVisible();
        selectByText(text);
    }

}
