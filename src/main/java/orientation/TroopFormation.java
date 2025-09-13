package orientation;

import entities.map.Battlefield;
import entities.units.CombatUnit;
import orientation.strategy.FormationStrategy;

import java.util.List;

public class TroopFormation {

    private final FormationStrategy formationStrategy;
    private Battlefield battlefield;

    public TroopFormation(FormationStrategy formationStrategy, Battlefield battlefield) {
        this.formationStrategy = formationStrategy;
        this.battlefield = battlefield;
    }

    public List<List<CombatUnit>> form() {
        return formationStrategy.arrange(battlefield);
    }
}
