package com.rogeop.lambda.core.interpreter.gof;

/**
 * @author Robert Pepersack
 */
public class OrExp implements IBooleanExp {

    private IBooleanExp operand1;
    private IBooleanExp operand2;

    /**
     * Constructor that accepts left and right operands
     *
     * @param operand1 left operand
     * @param operand2 right operand
     */
    public OrExp(IBooleanExp operand1, IBooleanExp operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public boolean evaluate(Context context) {
        return operand1.evaluate(context) || operand2.evaluate(context);
    }

    @Override
    public IBooleanExp copy() {
        return new OrExp(operand1.copy(), operand2.copy());
    }

    @Override
    public IBooleanExp replace(String var, IBooleanExp exp) {
        return new OrExp(operand1.replace(var, exp), operand2.replace(var, exp));
    }

    @Override
    public String toString() {
        return "OrExp [operand1=" + operand1 + ", operand2=" + operand2 + "]";
    }

}