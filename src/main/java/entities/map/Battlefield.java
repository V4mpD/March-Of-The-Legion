package entities.map;

import entities.map.exceptions.NoExistsBattlefieldException;
import entities.map.generator.BattlefieldGenerator;
import entities.map.generator.SquareBattlefieldGenerator;
import entities.units.CombatUnit;
import java.util.List;

public class Battlefield {
    private Integer sizeSides;
    private List<List<CombatUnit>> matrixUnits;

    private BattlefieldGenerator battlefieldGenerator = new SquareBattlefieldGenerator();

    public Battlefield() {
    }

    public Battlefield(Integer sizeSides) {
        this.sizeSides = sizeSides;
        this.matrixUnits = battlefieldGenerator.generate(sizeSides);
    }

    public List<List<CombatUnit>> getMatrixUnits() {
        return matrixUnits;
    }

    public void setMatrixUnits(List<List<CombatUnit>> matrixUnits) {
        this.matrixUnits = matrixUnits;
    }

    public Integer getSizeSides() {
        return sizeSides;
    }

    public void setSizeSides(Integer sizeSides) {
        this.sizeSides = sizeSides;
        this.matrixUnits = battlefieldGenerator.generate(sizeSides);
    }

    public void valueAt(int row, int col, CombatUnit unit) {
        this.validateMatrix();
        this.matrixUnits.get(row).set(col, unit);
    }

    private void validateMatrix() {
        if (matrixUnits == null) {
            throw new NoExistsBattlefieldException("Battlefield is null");
        }
    }
}
