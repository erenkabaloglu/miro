package com.miro.utils;

public class AutomationException extends RuntimeException {
    public AutomationException(String message){
        super(message);
        //Here we can integrigate with bug tracking tools like jira and open bugs automatically
        //And we can implement custom reporting, take screenshots etc.
    }
}
