package entities.units.behavior;

public interface UnitRepresentation<T> {
    T toProcessNumeric();
    T toProcessSymbol();
}