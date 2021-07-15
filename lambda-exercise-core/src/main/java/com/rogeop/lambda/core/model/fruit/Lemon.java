package com.rogeop.lambda.core.model.fruit;

/**
 * @author Robert Pepersack
 */
public class Lemon extends Fruit {

    private static final long serialVersionUID = 6221850695330786908L;

    /**
     * Default constructor that sets name, color, and type
     */
    public Lemon() {
        super("lemon", "yellow", FruitType.CITRUS);
    }

}