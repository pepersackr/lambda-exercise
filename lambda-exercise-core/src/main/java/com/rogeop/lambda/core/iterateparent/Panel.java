package com.rogeop.lambda.core.iterateparent;

/**
 * @author Robert Pepersack
 */
public abstract class Panel extends Component {

    /**
     * Constructor that accepts a name and parent component
     *
     * @param name   the name of this component
     * @param parent the parent component
     */
    public Panel(String name, Component parent) {
        super(name, parent);
    }

}