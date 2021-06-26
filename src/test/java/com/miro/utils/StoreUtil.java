package com.miro.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class StoreUtil {

    private static final Logger log = LogManager.getLogger(StoreUtil.class);
    private static Map<String, Object> store;

    public static void initializeStore(){
        if(store == null)
            store = new HashMap<>();
    }

    public static void clearStore(){
        if(store != null)
            store.clear();
    }

    public static void putItemToStore(String storeKey, Object item){
        store.put(storeKey, item);
    }

    public static <T> T getItemFromStore(String storeKey, Class<T> clazz){
        Object item = store.get(storeKey);
        if(clazz.isInstance(item)) {
            return (T) store.get(storeKey);
        } else {
            log.error("Store item is not an instance of " + clazz.getName());
            return null;
        }
    }
}
