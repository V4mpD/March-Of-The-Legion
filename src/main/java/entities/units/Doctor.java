package entities.units;

public class Doctor extends CombatUnit {
    public Doctor() {
        super('M', 20);
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
