package com.olkhovyi.mykhailo.lib;

import com.olkhovyi.mykhailo.ast.NumberValue;
import com.sun.org.apache.xpath.internal.operations.Variable;

import java.util.HashMap;
import java.util.Map;

public class Variables {

    private static Map<String, Value> variables;
    private final static NumberValue ZERO = new NumberValue(0);

    static {
        variables = new HashMap<>();
        variables.put("Пі", new NumberValue(Math.PI));
        variables.put("Е", new NumberValue(Math.E));
    }

    public static boolean isExists(String key) {
        return variables.containsKey(key);
    }

    public static Value get(String key) {
        if (!isExists(key)) {

            return ZERO;
        }
        return variables.get(key);
    }

    public static void set(String key, Value value) {
        variables.put(key, value);
    }
}
