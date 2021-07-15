package com.rogeop.lambda.core.model.fruit;

/**
 * @author Robert Pepersack
 */
public class Banana extends Fruit {

    private static final long serialVersionUID = 2268005593609551444L;

    /**
     * Default constructor that sets name, color, and type
     */
    public Banana() {
        super("banana", "yellow", FruitType.TROPICAL);
    }

}