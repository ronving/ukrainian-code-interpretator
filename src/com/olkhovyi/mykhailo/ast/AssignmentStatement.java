package com.olkhovyi.mykhailo.ast;

import com.olkhovyi.mykhailo.lib.Value;
import com.olkhovyi.mykhailo.lib.Variables;

public class AssignmentStatement implements Statement {

    private final String variable;
    private final Expression exp;

    public AssignmentStatement(String variable, Expression exp) {
        this.variable = variable;
        this.exp = exp;
    }

    @Override
    public void execute() {
        final Value result = exp.eval();
        Variables.set(variable, result);
    }

    @Override
    public String toString() {
        return String.format("%s = %s", variable, exp);
    }
}
