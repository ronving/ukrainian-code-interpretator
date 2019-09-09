package com.olkhovyi.mykhailo.ast;

public class UnaryExpression implements Expression {

    private final Expression exp;
    private final char operation;

    public UnaryExpression(char operation, Expression exp) {
        this.operation = operation;
        this.exp = exp;
    }



    @Override
    public double eval() {
        switch(operation) {
            case '-': return -exp.eval();
            case '+':
            default: return exp.eval();
        }
    }

    @Override
    public String toString() {
        return String.format("%s", Double.toString(eval()));
    }
}
