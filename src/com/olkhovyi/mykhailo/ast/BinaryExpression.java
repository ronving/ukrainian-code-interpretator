package com.olkhovyi.mykhailo.ast;

public final class BinaryExpression implements Expression {

    private Expression exp1, exp2;
    private final char operation;

    public BinaryExpression(char operation, Expression exp1, Expression exp2) {
        this.operation = operation;
        this.exp1 = exp1;
        this.exp2 = exp2;

    }

    @Override
    public double eval() {
        switch(operation) {
            case '-': return exp1.eval() - exp2.eval();
            case '*': return exp1.eval() * exp2.eval();
            case '/': return exp1.eval() / exp2.eval();
            case '+':
                default: return exp1.eval() + exp2.eval();
        }
    }

    @Override
    public String toString() {
        return String.format("(%s %c %s)", exp1, operation, exp2);
    }
}
