package orientation.formation;

import entities.map.Battlefield;
import entities.units.CombatUnit;
import entities.units.Empty;
import orientation.finder.TroopFinder;
import orientation.grid.GridInitializer;
import orientation.order.TroopOrder;
import orientation.strategy.FormationStrategy;

import java.util.List;

public class WestFormation implements FormationStrategy {
    @Override
    public List<List<CombatUnit>> arrange(Battlefield battlefield) {
        List<List<CombatUnit>> grip = battlefield.getMatrixUnits();

        int sizeRows = grip.size();
        int sizeCols = grip.get(0).size();

        List<List<CombatUnit>> west = GridInitializer.createEmpty(sizeRows, sizeCols);

        List<CombatUnit> orderTroops = TroopOrder.defaultOrder();
        int currentCols = sizeCols - 1;

        for (CombatUnit troopClass : orderTroops) {
            List<CombatUnit> troops = TroopFinder.findTroop(grip, troopClass);

            for (int i = currentCols; i >= 0; i--) {
                for (int j = sizeRows - 1; j >= 0; j--) {
                    if (troops.isEmpty()) break;

                    if (west.get(j).get(i).equals(new Empty())) {
                        west.get(j).set(i, troops.remove(0));
                    }
                }
            }
            currentCols--;
        }

        return west;
    }
}
