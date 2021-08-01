package com.rogeop.lambda.core.interpreter.gof;

/**
 * @author Robert Pepersack
 */
public class VariableExp implements IBooleanExp {

    private String name;

    public VariableExp(String name) {
        this.name = name;
    }

    @Override
    public boolean evaluate(Context context) {
        return context.lookup(name);
    }

    @Override
    public IBooleanExp copy() {
        return new VariableExp(name);
    }

    @Override
    public IBooleanExp replace(String var, IBooleanExp exp) {
        if (var.equals(name)) {
            return exp.copy();
        } else {
            return new VariableExp(name);
        }
    }

    @Override
    public String toString() {
        return "VariableExp [name=" + name + "]";
    }

}