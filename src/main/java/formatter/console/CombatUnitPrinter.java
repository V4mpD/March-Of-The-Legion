package formatter.console;

import entities.units.CombatUnit;
import formatter.unit.Printer;

import java.util.List;

public class CombatUnitPrinter {

    private final Printer<CombatUnit> printer;

    public CombatUnitPrinter(Printer<CombatUnit> printer) {
        this.printer = printer;
    }

    public void print(List<List<CombatUnit>> matrixUnits) {
        StringBuilder sb = new StringBuilder();
        for (List<CombatUnit> combatUnits : matrixUnits) {
            for (CombatUnit combatUnit : combatUnits) {
                sb.append(printer.format(combatUnit))
                        .append(printer.spacing(combatUnit));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
