package com.rogeop.lambda.core.data;

import java.util.List;

/**
 * @author Robert Pepersack
 */
public interface DataGenerator<T> {

    public List<T> generate(int num);

}