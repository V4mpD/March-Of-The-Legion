package orientation.formation;

import entities.map.Battlefield;
import entities.units.CombatUnit;
import orientation.strategy.FormationStrategy;

import java.util.Collections;
import java.util.List;

public class SouthFormation implements FormationStrategy {
    @Override
    public List<List<CombatUnit>> arrange(Battlefield battlefield) {
        FormationStrategy formationStrategy = new NorthFormation();
        List<List<CombatUnit>> troopFormations = formationStrategy.arrange(battlefield);
        Collections.reverse(troopFormations);
        return troopFormations;
    }
}
