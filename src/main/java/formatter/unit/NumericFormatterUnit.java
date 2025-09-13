package formatter.unit;

import entities.units.CombatUnit;
import entities.units.Empty;

public class NumericFormatterUnit implements Printer<CombatUnit> {
    @Override
    public String format(CombatUnit unit) {
        return unit.toProcessNumeric().toString();
    }

    @Override
    public String spacing(CombatUnit unit) {
        return unit instanceof Empty ? "    " : "   ";
    }
}
