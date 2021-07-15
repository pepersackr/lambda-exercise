package com.rogeop.lambda.core.model.fruit;

/**
 * @author Robert Pepersack
 */
public class Kiwi extends Fruit {

    private static final long serialVersionUID = -6570921600662349412L;

    /**
     * Default constructor that sets name, color, and type
     */
    public Kiwi() {
        super("kiwi", "green", FruitType.CORE);
    }

}