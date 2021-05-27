package com.rogeop.lambda.core.data;

/**
 * @author Robert Pepersack
 */
public interface IDataReader<R, T> {

    public T read(R resource);

}