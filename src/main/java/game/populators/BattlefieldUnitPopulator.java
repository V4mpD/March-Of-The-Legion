package game.populators;

import entities.map.Battlefield;
import entities.units.CombatUnit;
import game.generator.BattlefieldPositionGenerator;

import java.util.List;

public class BattlefieldUnitPopulator {
    public static void generateRandomPositionInGrid(Battlefield battlefield, List<CombatUnit> totalTroops) {
        List<Integer[]> positionRandomSet = BattlefieldPositionGenerator.generateUniquePositions(
                battlefield.getSizeSides(),
                battlefield.getSizeSides(),
                totalTroops.size()
        );

        for (int i = 0; i < totalTroops.size(); i++) {
            if (positionRandomSet.get(i) == null) {
                break;
            }
            Integer[] position = positionRandomSet.get(i);
            int x = position[0];
            int y = position[1];
            CombatUnit unit = totalTroops.get(i);
            battlefield.valueAt(x, y, unit);
        }

    }
}
