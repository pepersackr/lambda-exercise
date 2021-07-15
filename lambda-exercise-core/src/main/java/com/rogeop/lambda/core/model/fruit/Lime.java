package com.rogeop.lambda.core.model.fruit;

/**
 * @author Robert Pepersack
 */
public class Lime extends Fruit {

    private static final long serialVersionUID = 6367940240386412587L;

    /**
     * Default constructor that sets name, color, and type
     */
    public Lime() {
        super("lime", "green", FruitType.CITRUS);
    }

}