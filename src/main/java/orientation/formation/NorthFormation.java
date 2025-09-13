package orientation.formation;

import entities.map.Battlefield;
import entities.units.CombatUnit;
import entities.units.Empty;
import orientation.strategy.FormationStrategy;
import orientation.finder.TroopFinder;
import orientation.grid.GridInitializer;
import orientation.order.TroopOrder;

import java.util.List;

public class NorthFormation implements FormationStrategy {
    @Override
    public List<List<CombatUnit>> arrange(Battlefield battlefield) {
        List<List<CombatUnit>> grip = battlefield.getMatrixUnits();

        int sizeRows = grip.size();
        int sizeCols = grip.get(0).size();

        List<List<CombatUnit>> north = GridInitializer.createEmpty(sizeRows, sizeCols);

        List<CombatUnit> orderTroops = TroopOrder.defaultOrder();
        int currentRow = sizeRows - 1;

        for (CombatUnit troopClass : orderTroops) {
            List<CombatUnit> troops = TroopFinder.findTroop(grip, troopClass);

            for (int i = currentRow; i >= 0; i--) {
                for (int j = 0; j < sizeCols; j++) {
                    if (troops.isEmpty()) break;
                    if (north.get(i).get(j).equals(new Empty())) {
                        north.get(i).set(j, troops.remove(0));
                    }
                }
            }
            currentRow--;
        }

        return north;
    }
}
