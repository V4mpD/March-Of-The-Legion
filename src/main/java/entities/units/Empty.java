package entities.units;

public class Empty extends CombatUnit {
    public Empty() {
        super('*', 60);
    }

    @Override
    public Character toProcessNumeric() {
        return this.getSymbol();
    }

    @Override
    public Character toProcessSymbol() {
        return this.getSymbol();
    }
}
