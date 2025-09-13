package orientation.order;

import entities.units.*;

import java.util.Arrays;
import java.util.List;

public class TroopOrder {
    public static List<CombatUnit> defaultOrder() {
        return Arrays.asList(
                new Commander(),
                new Doctor(),
                new Tank(),
                new Sniper(),
                new Infantry()
        );
    }
}