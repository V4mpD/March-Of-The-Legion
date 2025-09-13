package entities.units;

public class Sniper extends CombatUnit {
    public Sniper() {
        super('S', 40);
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
