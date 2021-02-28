package com.rogeop.lambda.core.iterateparent;

/**
 * @author Robert Pepersack
 */
public class Frame extends Component {

    /**
     * Default constructor that sets the name with parent left null
     *
     * @param name the name of this component
     */
    public Frame(String name) {
        super(name, null);
    }

    /**
     * Constructor that accepts a name and parent component
     *
     * @param name   the name of this component
     * @param parent the parent component
     */
    public Frame(String name, Component parent) {
        super(name, parent);
    }

}