package com.olkhovyi.mykhailo.ast;

import com.olkhovyi.mykhailo.lib.Value;

public class ConditionalExpression implements Expression {

    private final Expression exp1, exp2;
    private final char operation;

    public ConditionalExpression(char operation, Expression exp1, Expression exp2) {
        this.operation = operation;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }



    @Override
    public Value eval() {
        final Value val1 = exp1.eval();
        final Value val2 = exp2.eval();
        if (val1 instanceof StringValue) {
            final String str1 = val1.asString();
            final String str2 = val2.asString();
            switch (operation) {
                case '<': return new NumberValue(str1.compareTo(str2) < 0);
                case '>': return new NumberValue(str1.compareTo(str2) > 0);
                case '=':
                default:
                    return new NumberValue(str1.equals(str2));
            }
        }

        final double num1 = val1.asNumber();
        final double num2 = val2.asNumber();
        switch (operation) {
            case '<': return new NumberValue(num1 < num2);
            case '>': return new NumberValue(num1 > num2);
            case '=':
            default:
                return new NumberValue(num1 == num2);
        }
    }

    @Override
    public String toString() {
        return String.format("(%s %c %s)", exp1, operation, exp2);
    }
}
