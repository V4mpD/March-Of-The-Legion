package orientation.finder;

import entities.units.CombatUnit;

import java.util.ArrayList;
import java.util.List;

public class TroopFinder {
    public static List<CombatUnit> findTroop(List<List<CombatUnit>> grip, CombatUnit classTroop) {
        List<CombatUnit> result = new ArrayList<>();
        for (List<CombatUnit> row : grip) {
            for (CombatUnit unit : row) {
                if (unit.equals(classTroop)) {
                    result.add(unit);
                }
            }
        }
        return result;
    }
}