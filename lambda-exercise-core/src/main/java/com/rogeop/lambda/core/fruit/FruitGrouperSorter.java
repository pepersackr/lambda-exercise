package com.rogeop.lambda.core.fruit;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;

import com.rogeop.lambda.core.model.fruit.Apple;
import com.rogeop.lambda.core.model.fruit.Banana;
import com.rogeop.lambda.core.model.fruit.Blackberry;
import com.rogeop.lambda.core.model.fruit.Blueberry;
import com.rogeop.lambda.core.model.fruit.Fruit;
import com.rogeop.lambda.core.model.fruit.FruitType;
import com.rogeop.lambda.core.model.fruit.Grapefruit;
import com.rogeop.lambda.core.model.fruit.Kiwi;
import com.rogeop.lambda.core.model.fruit.Lemon;
import com.rogeop.lambda.core.model.fruit.Lime;
import com.rogeop.lambda.core.model.fruit.Orange;
import com.rogeop.lambda.core.model.fruit.Pear;
import com.rogeop.lambda.core.model.fruit.Plum;
import com.rogeop.lambda.core.model.fruit.Raspberry;
import com.rogeop.lambda.core.model.fruit.Strawberry;
import com.rogeop.lambda.core.model.fruit.Watermelon;

/**
 * @author Robert Pepersack
 */
public class FruitGrouperSorter {

    /**
     * Function used to group Fruits into an ordered TreeMap of three Lists of
     * Fruits
     */
    private static final Function<Fruit, Integer> grouper = fruit -> fruit.getType().equals(FruitType.TROPICAL) ? 2
            : (fruit.getType().equals(FruitType.CITRUS) ? 1 : 0);

    /**
     * Function that creates a List of Fruits, sorted by name, from an unsorted List
     * of Fruits
     */
    private static final Function<List<Fruit>, List<Fruit>> sorter = l -> l.stream()
            .sorted(Comparator.comparing(Fruit::getName)).collect(toList());

    public List<Fruit> sort(Set<Fruit> fruits) {
        // First, group the Set of Fruits into a TreeMap of Lists using the grouper
        // Function. Second, sort each List by Fruit name using the sorter Function.
        // Third, flatten the Lists of Fruits in the TreeMap values into a single
        // unmodifiable List of sorted Fruits.
        List<Fruit> sortedList = fruits.stream()
                .collect(groupingBy(grouper, TreeMap::new, collectingAndThen(toList(), sorter))).entrySet().stream()
                .flatMap(e -> e.getValue().stream())
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));

        return sortedList;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Set<Fruit> unsortedFruits = new HashSet<>(Arrays.asList(new Plum(), new Lime(), new Raspberry(),
                new Blueberry(), new Watermelon(), new Strawberry(), new Pear(), new Blackberry(), new Kiwi(),
                new Orange(), new Banana(), new Lemon(), new Apple(), new Grapefruit()));

        List<Fruit> sortedFruits = new FruitGrouperSorter().sort(unsortedFruits);

        System.out.println("sortedFruits: " + sortedFruits);
    }

}