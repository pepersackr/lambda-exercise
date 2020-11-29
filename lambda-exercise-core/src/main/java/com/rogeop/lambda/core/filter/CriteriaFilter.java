package com.rogeop.lambda.core.filter;

import java.util.List;

/**
 * CriteriaFilter defines the interface for filtering objects using criteria
 *
 * @author Robert Pepersack
 * @version 1.0
 */
public interface CriteriaFilter<T, C> {

    /**
     * Defines the interface for filtering objects using criteria
     *
     * @param data     the list of objects to be filtered
     * @param criteria the criteria to be used to filter the list of objects
     * @return a list of objects that result from filtering the data
     */
    public List<T> filter(List<T> data, C criteria);

}