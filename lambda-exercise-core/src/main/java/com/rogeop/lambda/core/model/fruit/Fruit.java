package com.rogeop.lambda.core.model.fruit;

import java.io.Serializable;
import java.util.Objects;

/**
 * Base class for all fruit classes. This class and its subclasses are
 * immutable.
 *
 * @author Robert Pepersack
 */
public abstract class Fruit implements Serializable {

    private static final long serialVersionUID = 7504907155343732055L;

    private final String name;

    private final String color;

    private final FruitType type;

    /**
     * Constructor that accepts a name and a color
     *
     * @param name  this fruit's name
     * @param color this fruit's color
     * @param type  this fruit's type
     */
    protected Fruit(String name, String color, FruitType type) {
        this.name = name;
        this.color = color;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public FruitType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, name, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Fruit other = Fruit.class.cast(obj);
        return Objects.equals(color, other.color) && Objects.equals(name, other.name) && type == other.type;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [name=" + name + ", color=" + color + ", type=" + type + "]";
    }

}
