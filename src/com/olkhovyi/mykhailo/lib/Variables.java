package com.olkhovyi.mykhailo.lib;

import java.util.HashMap;
import java.util.Map;

public class Variables {

    private static Map<String, Double> variables;

    static {
        variables = new HashMap<>();
        variables.put("Пі", Math.PI);
        variables.put("Е", Math.E);
    }

    public static boolean isExists(String key) {
        return variables.containsKey(key);
    }

    public static double get(String key) {
        if (!isExists(key)) {
            return 0;
        }
        return variables.get(key);
    }

    public static void set(String key, double value) {
        variables.put(key, value);
    }
}
