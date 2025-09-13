package game.factory;

import entities.map.Battlefield;
import entities.units.CombatUnit;
import game.populators.BattlefieldUnitPopulator;
import game.validate.FieldSizeAndTroopsValidate;
import orientation.TroopFormation;
import orientation.strategy.FormationStrategy;
import validation.ArgumentValidator;

import java.util.List;

public class BattlefieldFormationFactory {
    public Battlefield create(ArgumentValidator argumentValidator) {
        Battlefield newBattlefield = new Battlefield(argumentValidator.getFieldSize());
        List<CombatUnit> troops = TroopFactory.create(argumentValidator.getUnits());

        FieldSizeAndTroopsValidate validate = new FieldSizeAndTroopsValidate();
        validate.validate(argumentValidator, troops.size());

        BattlefieldUnitPopulator.generateRandomPositionInGrid(newBattlefield, troops);

        FormationStrategy formationStrategy =  FormationStrategyFactory.create(String.valueOf(argumentValidator.getOrientation()));
        TroopFormation troopFormation = new TroopFormation(formationStrategy, newBattlefield);
        newBattlefield.setMatrixUnits(troopFormation.form());

        return newBattlefield;
    }
}
