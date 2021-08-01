package com.rogeop.lambda.core.interpreter.gof;

/**
 * @author Robert Pepersack
 */
public class NotExp implements IBooleanExp {

    private IBooleanExp operand;

    public NotExp(IBooleanExp operand) {
        this.operand = operand;
    }

    @Override
    public boolean evaluate(Context context) {
        return !(operand.evaluate(context));
    }

    @Override
    public IBooleanExp copy() {
        return new NotExp(operand.copy());
    }

    @Override
    public IBooleanExp replace(String var, IBooleanExp exp) {
        return new NotExp(operand.replace(var, exp));
    }

    @Override
    public String toString() {
        return "NotExp [operand=" + operand + "]";
    }

}