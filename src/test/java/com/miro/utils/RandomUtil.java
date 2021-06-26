package com.miro.utils;

import java.util.Random;

public class RandomUtil {

    public static String generateAlphabeticString(int length){
        Random random = new Random();

        return random.ints(97, 123)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
