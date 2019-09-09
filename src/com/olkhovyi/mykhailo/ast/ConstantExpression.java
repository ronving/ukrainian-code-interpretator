package com.olkhovyi.mykhailo.ast;

import com.olkhovyi.mykhailo.lib.Constants;

public class ConstantExpression implements Expression {
    private final String name;

    public ConstantExpression(String name) {
        this.name = name;
    }

    @Override
    public double eval() {
        if (!Constants.isExists(name)) throw new RuntimeException("Такої константи не існує");
        return Constants.get(name);
    }

    @Override
    public String toString() {
        return String.format("%f", Constants.get(name));
    }
}
