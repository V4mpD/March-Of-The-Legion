package orientation.strategy;

import entities.map.Battlefield;
import entities.units.CombatUnit;

import java.util.List;

public interface FormationStrategy {
    List<List<CombatUnit>> arrange(Battlefield battlefield);
}
