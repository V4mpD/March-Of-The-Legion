package algorithm.sort.base;

import algorithm.sort.strategy.SortingStrategy;
import java.util.ArrayList;
import java.util.List;

public class BubbleSort<T> implements SortingStrategy<T> {
    @Override
    public List<T> sort(List<T> list) {
        List<T> sortedList = new ArrayList<>(list);
        boolean swapped;

        for (int i = 0; i < sortedList.size() - 1; i++) {
            swapped = false;

            for (int j = 0; j < sortedList.size() - i - 1; j++) {
                if (sortedList.get(j + 1).hashCode() < sortedList.get(j).hashCode()) {
                    T temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        return sortedList;
    }
}