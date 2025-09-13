package game.factory;

import algorithm.sort.handler.MemoryStepHandler;
import algorithm.sort.extended.BubbleSortWithSteps;
import algorithm.sort.extended.MergeSortWithSteps;
import algorithm.sort.extended.QuickSortWithSteps;
import algorithm.sort.extended.SelectionSortWithSteps;
import algorithm.sort.strategy.SortingStrategy;
import entities.units.CombatUnit;

public class SortingStrategyFactory {
    public static SortingStrategy<CombatUnit> create(String algorithm, MemoryStepHandler<CombatUnit> memoryStep) {
        return switch (algorithm.toLowerCase()) {
            case "b" -> new BubbleSortWithSteps<>(memoryStep);
            case "s" -> new SelectionSortWithSteps<>(memoryStep);
            case "q" -> new QuickSortWithSteps<>(memoryStep);
            case "m" -> new MergeSortWithSteps<>(memoryStep);
            default -> throw new IllegalArgumentException("Invalid algorithm");
        };
    }
}