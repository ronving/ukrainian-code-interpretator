package com.olkhovyi.mykhailo.ast;

import com.olkhovyi.mykhailo.lib.Value;

public class UnaryExpression implements Expression {

    private final Expression exp;
    private final char operation;

    public UnaryExpression(char operation, Expression exp) {
        this.operation = operation;
        this.exp = exp;
    }



    @Override
    public Value eval() {
        switch(operation) {
            case '-': return new NumberValue(-exp.eval().asDouble()) ;
            case '+':
            default: return new NumberValue(exp.eval().asDouble()) ;
        }
    }

    @Override
    public String toString() {
        return String.format("%c%s", operation, exp);
    }
}
