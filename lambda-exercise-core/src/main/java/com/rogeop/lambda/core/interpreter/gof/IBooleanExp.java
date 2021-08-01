package com.rogeop.lambda.core.interpreter.gof;

/**
 * @author Robert Pepersack
 */
public interface IBooleanExp {

    public boolean evaluate(Context context);

    public IBooleanExp replace(String var, IBooleanExp exp);

    public IBooleanExp copy();

}