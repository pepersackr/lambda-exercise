package com.rogeop.lambda.core.interpreter.gof;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Robert Pepersack
 */
public class Context {

    private final Map<String, Boolean> context = new HashMap<>();

    /**
     * Default constructor
     */
    public Context() {
        super();
    }

    public void assign(String name, boolean val) {
        context.put(name, new Boolean(val));
    }

    public boolean lookup(String name) {
        Boolean result = Optional.ofNullable(context.get(name))
                .orElseThrow(() -> new RuntimeException("No context value found with name " + name));
        return result;
    }

    @Override
    public String toString() {
        return "Context [context=" + context + "]";
    }

}