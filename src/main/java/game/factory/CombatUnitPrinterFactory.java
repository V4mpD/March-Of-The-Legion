package game.factory;

import formatter.console.CombatUnitPrinter;
import formatter.unit.NumericFormatterUnit;
import formatter.unit.SymbolFormatterUnit;

public class CombatUnitPrinterFactory {
    public static CombatUnitPrinter create(String type) {
        return switch (type.toLowerCase()) {
            case "n" -> new CombatUnitPrinter(new NumericFormatterUnit());
            default -> new CombatUnitPrinter(new SymbolFormatterUnit());
        };
    }
}