package game.factory;

import entities.units.CombatUnit;
import game.utils.RandomHelper;
import orientation.order.TroopOrder;

import java.util.ArrayList;
import java.util.List;

public class TroopRandomFactory {
    public static List<CombatUnit> create(List<Integer> qtdTroops) {
        List<CombatUnit> units = new ArrayList<>();

        List<CombatUnit> troopOrder = TroopOrder.defaultOrder();

        Integer totalTroops = qtdTroops.stream()
                                        .mapToInt(Integer::intValue)
                                        .sum();

        for (int i = 0; i < totalTroops; i++) {
            int num = RandomHelper.getRandomIntBetween(0, troopOrder.size() - 1);
            units.add(troopOrder.get(num));
        }

        return units;
    }
}
