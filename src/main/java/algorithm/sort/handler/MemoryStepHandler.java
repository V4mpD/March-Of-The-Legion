package algorithm.sort.handler;

import java.util.ArrayList;
import java.util.List;

public class MemoryStepHandler<T> implements StepHandler<T> {
    private final List<List<T>> steps = new ArrayList<>();

    @Override
    public void onStep(List<T> currentList) {
        steps.add(new ArrayList<>(currentList));
    }

    @Override
    public List<List<T>> getSteps() {
        return steps;
    }
}
