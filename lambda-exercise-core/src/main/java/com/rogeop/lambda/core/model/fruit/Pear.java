package com.rogeop.lambda.core.model.fruit;

/**
 * @author Robert Pepersack
 */
public class Pear extends Fruit {

    private static final long serialVersionUID = 7954552459190285877L;

    /**
     * Default constructor that sets name, color, and type
     */
    public Pear() {
        super("pear", "green", FruitType.CORE);
    }

}