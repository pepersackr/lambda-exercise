package com.rogeop.lambda.core.filter;

/**
 * @author Robert Pepersack
 */
public class CriteriaFilterException extends RuntimeException {

    private static final long serialVersionUID = 1228353203941676555L;

    public CriteriaFilterException() {
    }

    public CriteriaFilterException(String message) {
        super(message);
    }

    public CriteriaFilterException(Throwable cause) {
        super(cause);
    }

    public CriteriaFilterException(String message, Throwable cause) {
        super(message, cause);
    }

}