package algorithm.sort.base;

import algorithm.sort.strategy.SortingStrategy;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort<T> implements SortingStrategy<T> {
    @Override
    public List<T> sort(List<T> list) {
        List<T> sortedList = new ArrayList<>(list);

        for (int i = 0; i < sortedList.size(); i++) {
            int index = i;
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(j).hashCode() < sortedList.get(index).hashCode()) {
                    index = j;
                }
            }
            if (index != i) {
                T temp = sortedList.get(index);
                sortedList.set(index, sortedList.get(i));
                sortedList.set(i, temp);
            }
        }

        return sortedList;
    }
}
