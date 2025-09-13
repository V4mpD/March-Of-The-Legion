import builder.GridBuilder;
import entities.common.Grid;
import entities.units.CombatUnit;
import game.Legion;
import builder.LegionInitialize;
import ui.BattlefieldUI;
import validation.ArgumentValidator;

import java.util.List;

public class Troops {
    public static void main(String[] args) {
        ArgumentValidator argumentValidator = new ArgumentValidator(args);

        LegionInitialize legionInitialize = new LegionInitialize();
        Legion legion = legionInitialize.init(argumentValidator);

        GridBuilder gridBuilder = new GridBuilder();
        List<Grid<CombatUnit>> grids = gridBuilder.buildFromLegion(legion);

        BattlefieldUI battlefieldUi = new BattlefieldUI(
                500,
                grids,
                argumentValidator
        );
    }
}