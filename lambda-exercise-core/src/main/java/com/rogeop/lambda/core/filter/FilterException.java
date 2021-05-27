package com.rogeop.lambda.core.filter;

/**
 * @author Robert Pepersack
 */
public class FilterException extends RuntimeException {

    private static final long serialVersionUID = -4196870645133347329L;

    public FilterException() {
    }

    public FilterException(String message) {
        super(message);
    }

    public FilterException(Throwable cause) {
        super(cause);
    }

    public FilterException(String message, Throwable cause) {
        super(message, cause);
    }

}