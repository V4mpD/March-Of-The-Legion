package game.factory;

import orientation.formation.EastFormation;
import orientation.formation.NorthFormation;
import orientation.formation.SouthFormation;
import orientation.formation.WestFormation;
import orientation.strategy.FormationStrategy;

public class FormationStrategyFactory {
    public static FormationStrategy create(String orientation) {
        return switch (orientation.toLowerCase()) {
            case "n" -> new NorthFormation();
            case "s" -> new SouthFormation();
            case "e" -> new EastFormation();
            case "w" -> new WestFormation();
            default -> throw new IllegalArgumentException("Invalid orientation");
        };
    }
}