package entities.units;

import entities.units.behavior.UnitRepresentation;

import java.util.Objects;

public abstract class CombatUnit implements UnitRepresentation {

    private Character symbol;
    private Integer value;

    public CombatUnit(Character symbol, Integer value) {
        this.symbol = symbol;
        this.value = value;
    }

    public Character getSymbol() {
        return symbol;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CombatUnit that = (CombatUnit) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "CombatUnit{" + "symbol=" + symbol + ", value=" + value + '}';
    }

}
