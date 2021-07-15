package com.rogeop.lambda.core.model.fruit;

/**
 * @author Robert Pepersack
 */
public class Raspberry extends Fruit {

    private static final long serialVersionUID = -4372616334001428247L;

    /**
     * Default constructor that sets name, color, and type
     */
    public Raspberry() {
        super("raspberry", "red", FruitType.BERRY);
    }

}