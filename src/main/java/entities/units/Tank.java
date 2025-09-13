package entities.units;

public class Tank extends CombatUnit {
    public Tank() {
        super('T', 30);
    }

    @Override
    public Integer toProcessNumeric() {
        return this.getValue();
    }

    @Override
    public Character toProcessSymbol() {
        return this.getSymbol();
    }
}
