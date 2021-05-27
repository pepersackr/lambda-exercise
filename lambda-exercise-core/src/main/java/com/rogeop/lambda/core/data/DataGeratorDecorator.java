package com.rogeop.lambda.core.data;

import java.util.List;

/**
 * @author Robert Pepersack
 */
public abstract class DataGeratorDecorator<T> implements IDataGenerator<T> {

    private final IDataGenerator<T> dataGenerator;

    public DataGeratorDecorator(IDataGenerator<T> dataGenerator) {
        this.dataGenerator = dataGenerator;
    }

    @Override
    public List<T> generate(int num) {
        return dataGenerator.generate(num);
    }

    protected IDataGenerator<T> getDataGenerator() {
        return dataGenerator;
    }

}