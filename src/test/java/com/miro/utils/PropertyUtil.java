package com.miro.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    private static Properties prop;

    public static void loadProperties(){
        String path = "env/".concat(System.getProperty("env", "prod")).concat("/user.properties");
        System.out.println(path);
        try (InputStream input = new FileInputStream(path)) {
            prop = new Properties();
            prop.load(input);
        } catch (IOException ex) {
            throw new AutomationException("Could not load properties from " + path);
        }
    }

    public static String getProperty(String propertyKey){
        return prop.getProperty(propertyKey);
    }
}
