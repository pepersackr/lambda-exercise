package com.rogeop.lambda.core.model.fruit;

/**
 * @author Robert Pepersack
 */
public class Blackberry extends Fruit {

    private static final long serialVersionUID = 7964818049319509617L;

    /**
     * Default constructor that sets name, color, and type
     */
    public Blackberry() {
        super("blackberry", "black", FruitType.BERRY);
    }

}