package com.rogeop.lambda.core.model.fruit;

/**
 * @author Robert Pepersack
 */
public class Grapefruit extends Fruit {

    private static final long serialVersionUID = 879512278598318916L;

    /**
     * Default constructor that sets name, color, and type
     */
    public Grapefruit() {
        super("grapefruit", "yellow", FruitType.CITRUS);
    }

}