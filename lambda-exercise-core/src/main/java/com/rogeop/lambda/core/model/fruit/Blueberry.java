package com.rogeop.lambda.core.model.fruit;

/**
 * @author Robert Pepersack
 */
public class Blueberry extends Fruit {

    private static final long serialVersionUID = 6231161907629014373L;

    /**
     * Default constructor that sets name, color, and type
     */
    public Blueberry() {
        super("blueberry", "blue", FruitType.BERRY);
    }

}