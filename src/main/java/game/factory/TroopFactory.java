package game.factory;

import entities.units.CombatUnit;
import orientation.order.TroopOrder;

import java.util.ArrayList;
import java.util.List;

public class TroopFactory {
    public static List<CombatUnit> create(List<Integer> qtdTroops) {
        List<CombatUnit> units = new ArrayList<>();
        int aux = 0;
        for (CombatUnit unit : TroopOrder.defaultOrder()) {
            for (int j = 0; j < qtdTroops.get(aux); j++) {
                units.add(unit);
            }
            aux++;
        }
        return units;
    }
}
