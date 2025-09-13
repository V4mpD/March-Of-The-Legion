package entities.map.generator;

import entities.units.CombatUnit;
import entities.units.Empty;

import java.util.ArrayList;
import java.util.List;

public class SquareBattlefieldGenerator implements BattlefieldGenerator {
    @Override
    public List<List<CombatUnit>> generate(int size) {
        if (size <= 1) {
            throw new IllegalArgumentException("Size sides must be greater than 1");
        }

        List<List<CombatUnit>> matrix = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<CombatUnit> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new Empty());
            }
            matrix.add(row);
        }
        return matrix;
    }
}
