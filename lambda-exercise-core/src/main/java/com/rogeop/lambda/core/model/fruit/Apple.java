package com.rogeop.lambda.core.model.fruit;

/**
 * @author Robert Pepersack
 */
public class Apple extends Fruit {

    private static final long serialVersionUID = 4239185435750329208L;

    /**
     * Default constructor that sets name, color, and type
     */
    public Apple() {
        super("apple", "red", FruitType.CORE);
    }

}