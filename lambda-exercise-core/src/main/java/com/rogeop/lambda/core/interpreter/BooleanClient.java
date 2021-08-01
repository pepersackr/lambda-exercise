package com.rogeop.lambda.core.interpreter;

import static com.rogeop.lambda.core.interpreter.IBoolean.and;
import static com.rogeop.lambda.core.interpreter.IBoolean.not;
import static com.rogeop.lambda.core.interpreter.IBoolean.or;
import static com.rogeop.lambda.core.interpreter.IBoolean.variable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Robert Pepersack
 */
public class BooleanClient {

    /**
     * Default constructor
     */
    public BooleanClient() {
        super();
    }

    public static void main(String[] args) {

        Map<String, Boolean> context = new HashMap<>();
        context.put("x", true);
        context.put("y", false);
        context.put("z", true);

        System.out.println("context: " + context);

        IBoolean x = variable("x");
        IBoolean y = variable("y");
        IBoolean z = variable("z");

        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("z: " + z);

        // Evaluate (z and x) and (y and (not x))
        IBoolean expression1 = and(and(z, x), and(y, not(x)));

        System.out.println("expression1: " + expression1);

        boolean result1 = expression1.evaluate(context);

        System.out.println("(z and x) and (y and (not x)): " + result1);

        // Evaluate (z and x) or (y and (not x))
        IBoolean expression2 = or(and(z, x), and(y, not(x)));

        System.out.println("expression2: " + expression2);

        boolean result2 = expression2.evaluate(context);

        System.out.println("(z and x) or (y and (not x)): " + result2);
    }

}