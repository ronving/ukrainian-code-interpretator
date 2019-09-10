package com.olkhovyi.mykhailo.ast;

public final class PrintStatement implements Statement {
    private final Expression exp;

    public PrintStatement(Expression exp) {
        this.exp = exp;
    }


    @Override
    public void execute() {
        System.out.println(exp.eval());
    }

    @Override
    public String toString() {
        return "print " + exp;
    }
}
