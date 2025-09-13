package orientation.grid;

import entities.units.CombatUnit;
import entities.units.Empty;

import java.util.ArrayList;
import java.util.List;

public class GridInitializer {
    public static List<List<CombatUnit>> createEmpty(int rows, int cols) {
        List<List<CombatUnit>> empty = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            List<CombatUnit> emptyRow = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                emptyRow.add(new Empty());
            }
            empty.add(emptyRow);
        }
        return empty;
    }
}