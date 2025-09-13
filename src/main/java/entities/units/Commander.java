package entities.units;

public class Commander extends CombatUnit {
    public Commander() {
        super('C', 10);
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
