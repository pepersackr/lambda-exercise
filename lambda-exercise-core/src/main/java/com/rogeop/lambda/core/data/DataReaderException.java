package com.rogeop.lambda.core.data;

/**
 * @author Robert Pepersack
 */
public class DataReaderException extends RuntimeException {

    private static final long serialVersionUID = 7298230691934495486L;

    public DataReaderException() {
    }

    public DataReaderException(String message) {
        super(message);
    }

    public DataReaderException(Throwable cause) {
        super(cause);
    }

    public DataReaderException(String message, Throwable cause) {
        super(message, cause);
    }

}