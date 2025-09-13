package algorithm.sort.base;
import algorithm.sort.strategy.SortingStrategy;

import java.util.ArrayList;
import java.util.List;

public class QuickSort<T> implements SortingStrategy<T> {
    @Override
    public List<T> sort(List<T> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }
        List<T> sortedList = new ArrayList<>(list);
        quickSort(sortedList, 0, sortedList.size() - 1);
        return sortedList;
    }

    protected void quickSort(List<T> list, Integer low, Integer high) {
        if (low < high) {
            Integer pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    protected Integer partition(List<T> list, Integer low, Integer high) {
        T pivot = list.get(high);

        Integer i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).hashCode() <= pivot.hashCode()) {
                i++;
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        T temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }
}
