package com.olkhovyi.mykhailo.lib;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    private static Map<String, Double> constants;

    static {
        constants = new HashMap<>();
        constants.put("Пі", Math.PI);
        constants.put("Е", Math.E);
    }

    public static boolean isExists(String key) {
        return constants.containsKey(key);
    }

    public static double get(String key) {
        if (!isExists(key)) {
            return 0;
        }
        return constants.get(key);
    }
}
