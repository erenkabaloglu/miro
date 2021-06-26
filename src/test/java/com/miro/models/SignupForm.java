package com.miro.models;

import com.miro.utils.RandomUtil;

//Models signup form data
public class SignupForm {
    private String name;
    private String email;
    private String password;
    private String reference;
    private Boolean acceptTerms;
    private Boolean subscribe;

    public SignupForm(String name, String email, String password, String reference, String acceptTerms, String subscribe) {
        this.name = name;

        //to create a unique email in each run
        if (email != null && email.equals("#RANDOM"))
            email = RandomUtil.generateAlphabeticString(10).concat("@automationmiro.com");
        this.email = email;
        this.password = password;
        this.reference = reference;
        this.acceptTerms = Boolean.valueOf(acceptTerms);
        this.subscribe = Boolean.valueOf(subscribe);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Boolean getAcceptTerms() {
        return acceptTerms;
    }

    public void setAcceptTerms(Boolean acceptTerms) {
        this.acceptTerms = acceptTerms;
    }

    public Boolean getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Boolean subscribe) {
        this.subscribe = subscribe;
    }
}
