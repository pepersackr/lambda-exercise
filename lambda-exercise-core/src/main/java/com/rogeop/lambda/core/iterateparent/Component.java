package com.rogeop.lambda.core.iterateparent;

/**
 * @author Robert Pepersack
 */
public abstract class Component {

    private final String name;
    private final Component parent;

    /**
     * Default constructor that sets name to empty string and parent null
     */
    public Component() {
        this.name = "";
        this.parent = null;
    }

    /**
     * Constructor that accepts a name and parent component
     *
     * @param name   the name of this component
     * @param parent the parent component
     */
    public Component(String name, Component parent) {
        this.name = name;
        this.parent = parent;
    }

    public Component getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

}