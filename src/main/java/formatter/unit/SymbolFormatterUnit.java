package formatter.unit;

import entities.units.CombatUnit;
import entities.units.Empty;

public class SymbolFormatterUnit implements Printer<CombatUnit> {
    @Override
    public String format(CombatUnit unit) {
        return unit.toProcessSymbol().toString();
    }
}
