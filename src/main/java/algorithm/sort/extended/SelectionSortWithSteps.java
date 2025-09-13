package algorithm.sort.extended;

import algorithm.sort.handler.MemoryStepHandler;
import algorithm.sort.base.SelectionSort;
import algorithm.sort.handler.StepHandler;

import java.util.ArrayList;
import java.util.List;

public class SelectionSortWithSteps<T> extends SelectionSort<T> {
    private final StepHandler<T> steps;

    public SelectionSortWithSteps(StepHandler<T> steps) {
        super();
        this.steps = steps;
    }

    public StepHandler<T> getSteps() {
        return steps;
    }

    @Override
    public List<T> sort(List<T> list) {
        steps.getSteps().clear();

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
                steps.onStep(sortedList);
            }
        }

        return sortedList;
    }
}
