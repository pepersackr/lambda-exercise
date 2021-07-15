package com.rogeop.lambda.core.model.fruit;

/**
 * @author Robert Pepersack
 */
public class Strawberry extends Fruit {

    private static final long serialVersionUID = 211224247111601035L;

    /**
     * Default constructor that sets name, color, and type
     */
    public Strawberry() {
        super("strawberry", "red", FruitType.BERRY);
    }

}