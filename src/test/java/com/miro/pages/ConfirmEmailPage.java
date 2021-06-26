package com.miro.pages;

import com.miro.elements.Label;
import com.miro.utils.AutomationException;
import com.miro.utils.TranslationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ConfirmEmailPage {
    private static final Logger log = LogManager.getLogger(ConfirmEmailPage.class);
    private static ConfirmEmailPage instance;

    private static final Label TXT_NAME = new Label(By.className("signup__title-form"));

    public static ConfirmEmailPage getInstance(){
        if(instance == null)
            instance = new ConfirmEmailPage();
        return instance;
    }

    public void verifyPageHeader(){
        log.info("ENTERING verifyPageHeader");
        TXT_NAME.waitUntilVisible();
        //Verification of "check your email text" with multilanguage support -if needed-
        if(TXT_NAME.getLabelText().equals(TranslationUtil.getTranslation("EMAIL_VERIFY"))){
            log.info("Page header is verified");
        } else {
            throw new AutomationException("Page header can not be verified");//Throwing exception instead of using assertions. This is for handling post fail actions
        }
    }
}
