package com.rogeop.lambda.core.interpreter;

import java.util.Map;
import java.util.Optional;

/**
 * @author Robert Pepersack
 */
@FunctionalInterface
public interface IBoolean {

    public boolean evaluate(Map<String, Boolean> context);

    public static IBoolean variable(String name) {
        return context -> Optional.ofNullable(context.get(name))
                .orElseThrow(() -> new RuntimeException("No context value found with name " + name));
    }

    public static IBoolean and(IBoolean operand1, IBoolean operand2) {
        return context -> operand1.evaluate(context) && operand2.evaluate(context);
    }

    public static IBoolean or(IBoolean operand1, IBoolean operand2) {
        return context -> operand1.evaluate(context) || operand2.evaluate(context);
    }

    public static IBoolean xor(IBoolean operand1, IBoolean operand2) {
        return context -> operand1.evaluate(context) ^ operand2.evaluate(context);
    }

    public static IBoolean not(IBoolean operand) {
        return context -> !operand.evaluate(context);
    }

}