package com.miro.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TranslationUtil {
    private static Properties languageDefs;

    public static void loadLanguageDefs(){
        String[] paths = {"env", System.getProperty("env", "prod"), System.getProperty("lang", "en") + ".properties"};
        try (InputStream input = new FileInputStream(String.join("/", paths))) {
            languageDefs = new Properties();
            languageDefs.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getTranslation(String translationKey) {
        return languageDefs.get(translationKey).toString();
    }
}
