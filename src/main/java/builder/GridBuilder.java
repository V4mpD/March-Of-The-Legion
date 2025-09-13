package builder;

import entities.common.Grid;
import entities.units.CombatUnit;
import game.Legion;
import game.utils.ListMatrixConverter;

import java.util.ArrayList;
import java.util.List;

public class GridBuilder {
    public List<Grid<CombatUnit>> buildFromLegion(Legion legion) {
        int sizeGrip = legion.getBattlefield().getSizeSides();
        List<Grid<CombatUnit>> grips = new ArrayList<>();

        for (List<CombatUnit> units : legion.getMemoryStep().getSteps()) {
            List<List<CombatUnit>> matrix = ListMatrixConverter.toMatrix(units, sizeGrip);
            grips.add(new Grid<>(matrix));
        }

        return grips;
    }
}