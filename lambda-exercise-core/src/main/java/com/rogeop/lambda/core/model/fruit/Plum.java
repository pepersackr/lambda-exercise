package com.rogeop.lambda.core.model.fruit;

/**
 * @author Robert Pepersack
 */
public class Plum extends Fruit {

    private static final long serialVersionUID = -1551473455995246518L;

    /**
     * Default constructor that sets name, color, and type
     */
    public Plum() {
        super("plum", "purple", FruitType.PIT);
    }

}