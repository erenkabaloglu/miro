package com.miro.stepdefs;

import com.miro.driver.Driver;
import com.miro.models.SignupForm;
import com.miro.pages.ConfirmEmailPage;
import com.miro.pages.SignupPage;
import com.miro.utils.PropertyUtil;
import com.miro.utils.StoreUtil;
import io.cucumber.java8.En;

import java.util.Map;

public class SignupStepDefs implements En {
    private static final SignupPage signupPage = SignupPage.getInstance();
    private static final ConfirmEmailPage confirmEmailPage = ConfirmEmailPage.getInstance();

    public SignupStepDefs() {
        DataTableType((Map<String, String> entry) ->
                new SignupForm(entry.get("name"), entry.get("email"), entry.get("password"), entry.get("reference"), entry.get("acceptTerms"), entry.get("subscribe")));

        Given("^I am at the signup page$", () -> {
            Driver.getWebDriver().get(PropertyUtil.getProperty("APP_URL"));
        });

        Given("^Following signup data$", (SignupForm signupData) -> {
            StoreUtil.putItemToStore("signupForm", signupData);
        });

        When("^I fill signup form$", signupPage::fillSignupForm);

        When("^I click submit$", signupPage::clickSubmit);

        Then("^Check your email should be displayed$", confirmEmailPage::verifyPageHeader);

        Then("{word} should be displayed", signupPage::verifyErrorMessage);

        Then("{word} password hint should be displayed", signupPage::verifyPasswordHint);

        When("I input password with {word}", signupPage::fillPassword);
    }
}
