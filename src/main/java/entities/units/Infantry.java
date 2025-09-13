package entities.units;

public class Infantry extends CombatUnit {
    public Infantry() {
        super('I', 50);
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
