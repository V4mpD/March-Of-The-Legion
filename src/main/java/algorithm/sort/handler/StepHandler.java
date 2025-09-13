package algorithm.sort.handler;

import java.util.List;

public interface StepHandler<T> {
    void onStep(List<T> currentList);
    List<List<T>> getSteps();
}
