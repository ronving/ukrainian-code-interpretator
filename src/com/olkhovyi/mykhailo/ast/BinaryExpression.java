package com.olkhovyi.mykhailo.ast;

import com.olkhovyi.mykhailo.lib.Value;

public final class BinaryExpression implements Expression {

    private Expression exp1, exp2;
    private final char operation;

    public BinaryExpression(char operation, Expression exp1, Expression exp2) {
        this.operation = operation;
        this.exp1 = exp1;
        this.exp2 = exp2;

    }

    @Override
    public Value eval() {
        final double num1 = exp1.eval().asDouble();
        final double num2 = exp2.eval().asDouble();
        switch(operation) {
            case '-': return new NumberValue(num1 - num2);
            case '*': return new NumberValue(num1 * num2);
            case '/': return new NumberValue(num1 / num2);
            case '+':
                default: return new NumberValue(num1 + num2);
        }
    }

    @Override
    public String toString() {
        return String.format("(%s %c %s)", exp1, operation, exp2);
    }
}
