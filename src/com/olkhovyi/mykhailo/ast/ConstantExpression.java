package com.olkhovyi.mykhailo.ast;

import com.olkhovyi.mykhailo.lib.Variables;

public class ConstantExpression implements Expression {
    private final String name;

    public ConstantExpression(String name) {
        this.name = name;
    }

    @Override
    public double eval() {
        if (!Variables.isExists(name)) throw new RuntimeException("Такої константи не існує");
        return Variables.get(name);
    }

    @Override
    public String toString() {
        return String.format("%f", Variables.get(name));
    }
}
