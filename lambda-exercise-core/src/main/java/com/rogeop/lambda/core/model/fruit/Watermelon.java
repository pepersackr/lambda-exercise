package com.rogeop.lambda.core.model.fruit;

/**
 * @author Robert Pepersack
 */
public class Watermelon extends Fruit {

    private static final long serialVersionUID = 4765710742980765189L;

    /**
     * Default constructor that sets name, color, and type
     */
    public Watermelon() {
        super("watermelon", "green", FruitType.MELON);
    }

}