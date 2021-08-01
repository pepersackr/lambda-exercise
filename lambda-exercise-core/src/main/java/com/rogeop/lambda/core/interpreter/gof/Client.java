package com.rogeop.lambda.core.interpreter.gof;

/**
 * @author Robert Pepersack
 */
public class Client {

    /**
     * Default constructor
     */
    public Client() {
        super();
    }

    public static void main(String[] args) {

        VariableExp x = new VariableExp("x");
        VariableExp y = new VariableExp("y");
        VariableExp z = new VariableExp("z");

        System.out.println("x: " + x + ", y: " + y + ", z:" + z);

        Context context = new Context();
        context.assign("x", true);
        context.assign("y", false);
        context.assign("z", true);

        System.out.println("context: " + context);

        // Evaluate (z and x) and (y and (not x))
        IBooleanExp expression1 = new AndExp(new AndExp(z, x), new AndExp(y, new NotExp(x)));

        System.out.println("expression1: " + expression1);

        boolean result1 = expression1.evaluate(context);

        System.out.println("(z and x) and (y and (not x)): " + result1);

        // Evaluate (z and x) or (y and (not x))
        IBooleanExp expression2 = new OrExp(new AndExp(z, x), new AndExp(y, new NotExp(x)));

        System.out.println("expression2: " + expression2);

        boolean result2 = expression2.evaluate(context);

        System.out.println("(z and x) or (y and (not x)): " + result2);
    }

}