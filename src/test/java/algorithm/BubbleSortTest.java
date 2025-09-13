package algorithm;

import algorithm.sort.base.BubbleSort;
import algorithm.sort.base.SelectionSort;
import algorithm.sort.strategy.SortingStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSortTest {

    @Test
    public void bubbleSortTestAscending() {
        SortingStrategy<Integer> sorting = new BubbleSort<>();

        List<Integer> list = Arrays.asList(10, 3, 7, 8, 2, 5, 4, 3, 0, 2, 1);

        List<Integer> result = sorting.sort(list);

        assertEquals(
                Arrays.asList(0, 1, 2, 2, 3, 3, 4, 5, 7, 8, 10),
                result
        );
    }

    @Test
    public void bubbleSortTestDescending() {
        SortingStrategy<Integer> sorting = new BubbleSort<>();

        List<Integer> list = Arrays.asList(10, 3, 7, 8, 2, 5, 4, 3, 0, 2, 1);

        List<Integer> result = sorting.sort(list);

        Collections.reverse(result);

        assertEquals(
                Arrays.asList(10, 8, 7, 5, 4, 3, 3, 2, 2, 1, 0),
                result
        );
    }


}
