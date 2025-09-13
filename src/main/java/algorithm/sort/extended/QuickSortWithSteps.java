package algorithm.sort.extended;

import algorithm.sort.base.QuickSort;
import algorithm.sort.handler.StepHandler;

import java.util.ArrayList;
import java.util.List;

public class QuickSortWithSteps<T> extends QuickSort<T> {
    private final StepHandler<T> steps;

    public QuickSortWithSteps(StepHandler<T> steps) {
        super();
        this.steps = steps;
    }

    public StepHandler<T> getSteps() {
        return steps;
    }

    @Override
    public List<T> sort(List<T> list) {
        steps.getSteps().clear();

        if (list == null || list.size() <= 1) {
            return list;
        }
        List<T> sortedList = new ArrayList<>(list);
        super.quickSort(sortedList, 0, sortedList.size() - 1);
        return sortedList;
    }

    protected void quickSort(List<T> list, Integer low, Integer high) {
        if (low < high) {
            Integer pi = super.partition(list, low, high);
            steps.onStep(list);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }
}
