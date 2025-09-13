package algorithm.sort.extended;

import algorithm.sort.base.BubbleSort;
import algorithm.sort.handler.StepHandler;

import java.util.ArrayList;
import java.util.List;

public class BubbleSortWithSteps<T> extends BubbleSort<T> {
    private final StepHandler<T> steps;

    public BubbleSortWithSteps(StepHandler<T> steps) {
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
            steps.onStep(sortedList);

            if (!swapped) break;
        }

        return sortedList;
    }
}
