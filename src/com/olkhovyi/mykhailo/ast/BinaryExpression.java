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
        final Value val1 = exp1.eval();
        final Value val2 = exp2.eval();

        if (val1 instanceof StringValue) {
            final String str1 = val1.asString();

            switch(operation) {

                case '*': {

                    StringBuilder buffer = new StringBuilder();
                    final int iterates = (int)val2.asDouble();

                    for(int i = 0; i < iterates; i++) {
                        buffer.append(str1);
                    }

                    return new StringValue(buffer.toString());
                }

                case '+':
                default: return new StringValue(str1+val2.asString());
            }
        }

        final double num1 = val1.asDouble();
        final double num2 = val2.asDouble();

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
