package orientation.formation;

import entities.map.Battlefield;
import entities.units.CombatUnit;
import orientation.strategy.FormationStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EastFormation implements FormationStrategy {
    @Override
    public List<List<CombatUnit>> arrange(Battlefield battlefield) {
        FormationStrategy formationStrategy = new WestFormation();
        List<List<CombatUnit>> troopsFormation = formationStrategy.arrange(battlefield);

        for (List<CombatUnit> list : troopsFormation) {
            Collections.reverse(list);
        }

        return troopsFormation;
    }
}
