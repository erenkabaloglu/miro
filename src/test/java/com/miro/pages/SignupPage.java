package com.miro.pages;

import com.miro.elements.*;
import com.miro.models.SignupForm;
import com.miro.utils.AutomationException;
import com.miro.utils.StoreUtil;
import com.miro.utils.TranslationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class SignupPage {
    private static final Logger log = LogManager.getLogger(SignupPage.class);
    private static SignupPage instance;

    //Elements of particular page are defined
    private static final TextBox TXT_NAME = new TextBox(By.id("name"));
    private static final TextBox TXT_EMAIL = new TextBox(By.id("email"));
    private static final TextBox TXT_PASSWORD = new TextBox(By.id("password"));
    private static final Button BTN_SUBMIT = new Button(By.xpath("//button[@data-autotest-id='mr-form-signup-btn-start-1']"));
    private static final CheckBox CHK_ACCEPT_TERMS = new CheckBox(By.id("signup-terms"));
    private static final CheckBox CHK_SUBSCRIBE = new CheckBox(By.id("signup-subscribe"));
    private static final Label LBL_PASSWORD_HINT = new Label(By.xpath("//div[@id='password-hint']//div[contains(@class, 'signup__input-hint-text')]"));
    private static final SelectBox SEL_REFERENCE = new SelectBox(By.xpath("//div[contains(@class, 'speero-trig-dropdown')]"));


    //Pages are singleton
    public static SignupPage getInstance(){
        if(instance == null)
            instance = new SignupPage();
        return instance;
    }

    //page actions are modelled
    public void fillSignupForm(){
        log.info("ENTERING fillSignupForm");
        SignupForm signupForm = StoreUtil.getItemFromStore("signupForm", SignupForm.class);
        if (signupForm == null){
            log.warn("Signup form is empty");
            return;
        }
        TXT_NAME.waitUntilVisibleAndType(signupForm.getName());
        TXT_EMAIL.type(signupForm.getEmail());
        TXT_PASSWORD.type(signupForm.getPassword());
        SEL_REFERENCE.selectByText(signupForm.getReference());
        if(signupForm.getAcceptTerms())
            CHK_ACCEPT_TERMS.check();
        if (signupForm.getSubscribe())
            CHK_SUBSCRIBE.check();
    }

    public void clickSubmit(){
        log.info("ENTERING clickSubmit");
        BTN_SUBMIT.click();
    }

    public void verifyErrorMessage(String expectedMessageKey){
        log.info("ENTERING verifyErrorMessage");
        String expectedError = TranslationUtil.getTranslation(expectedMessageKey);
        Label errorElement = new Label(By.xpath("//div[contains(@class, 'signup__error-item') and contains(text(),'" + expectedError + "')]"));
        errorElement.waitUntilVisible();
    }

    public void fillPassword(String password){
        log.info("ENTERING fillPassword");
        TXT_PASSWORD.waitUntilVisibleAndType(password);
    }

    public void verifyPasswordHint(String expectedMessageKey){
        log.info("ENTERING verifyPasswordHint");
        String expectedHint = TranslationUtil.getTranslation(expectedMessageKey);
        LBL_PASSWORD_HINT.waitUntilVisible();
        String actualHint = LBL_PASSWORD_HINT.getLabelText();
        if(expectedHint.equals(actualHint)){
            log.info("Hint is verified");
        } else {
            throw new AutomationException("Hint is wrong, actual is " + actualHint);
        }
    }
}
