package com.rogeop.lambda.core.model.fruit;

/**
 * @author Robert Pepersack
 */
public class Orange extends Fruit {

    private static final long serialVersionUID = 3421395198685421092L;

    /**
     * Default constructor that sets name, color, and type
     */
    public Orange() {
        super("orange", "orange", FruitType.CITRUS);
    }

}