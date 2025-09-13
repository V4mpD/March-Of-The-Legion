package entities.map.generator;

import entities.units.CombatUnit;

import java.util.List;

public interface BattlefieldGenerator {
    List<List<CombatUnit>> generate(int size);
}
