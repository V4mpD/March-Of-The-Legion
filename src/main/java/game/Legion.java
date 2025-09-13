package game;

import algorithm.sort.handler.MemoryStepHandler;
import algorithm.sort.strategy.SortingStrategy;
import entities.map.Battlefield;
import entities.units.CombatUnit;
import formatter.console.CombatUnitPrinter;
import game.factory.BattlefieldFormationFactory;
import game.factory.*;
import game.populators.BattlefieldUnitPopulator;
import game.validate.FieldSizeAndTroopsValidate;
import orientation.TroopFormation;
import orientation.strategy.FormationStrategy;
import game.utils.ListMatrixConverter;
import validation.ArgumentValidator;

import java.util.*;

public class Legion {

    private final ArgumentValidator argumentValidator;
    private final MemoryStepHandler<CombatUnit> memoryStep;

    private TroopFormation troopFormation;
    private FormationStrategy formationStrategy;
    private CombatUnitPrinter combatUnitPrinter;
    private SortingStrategy<CombatUnit> sortingStrategy;
    private Battlefield battlefield;
    private List<CombatUnit> troopUnits;

    public Legion(ArgumentValidator argumentValidator) {
        this.argumentValidator = argumentValidator;
        this.memoryStep = new MemoryStepHandler<>();
    }

    public Battlefield getBattlefield() {
        return battlefield;
    }

    public MemoryStepHandler<CombatUnit> getMemoryStep() {
        return memoryStep;
    }

    private void configure() {
        sortingStrategy = SortingStrategyFactory.create(String.valueOf(argumentValidator.getAlgorithm()), memoryStep);
        formationStrategy = FormationStrategyFactory.create(String.valueOf(argumentValidator.getOrientation()));
        combatUnitPrinter = CombatUnitPrinterFactory.create(String.valueOf(argumentValidator.getType()));

        if (argumentValidator.getDisposition() == 'r') {
            troopUnits = TroopRandomFactory.create(argumentValidator.getUnits());
        }
        else {
            troopUnits = TroopFactory.create(argumentValidator.getUnits());
        }

        FieldSizeAndTroopsValidate validate = new FieldSizeAndTroopsValidate();
        validate.validate(argumentValidator, troopUnits.size());

        battlefield = new Battlefield(argumentValidator.getFieldSize());
        BattlefieldUnitPopulator.generateRandomPositionInGrid(battlefield, troopUnits);
    }

    public void play() {
        configure();

        System.out.println("*************** March of the Legion ***************");
        System.out.println(argumentValidator);

        System.out.println("Initial Battlefield:");
        combatUnitPrinter.print(battlefield.getMatrixUnits());

        System.out.println("Sorted Battlefield:");
        List<CombatUnit> sorted = sortingStrategy.sort(ListMatrixConverter.toList(battlefield.getMatrixUnits()));
        battlefield.setMatrixUnits(ListMatrixConverter.toMatrix(sorted, battlefield.getSizeSides()));
        combatUnitPrinter.print(battlefield.getMatrixUnits());

        System.out.println("Ordenation Battlefield:");
        troopFormation = new TroopFormation(formationStrategy, battlefield);
        battlefield.setMatrixUnits(troopFormation.form());

        memoryStep.getSteps().add(ListMatrixConverter.toList(battlefield.getMatrixUnits()));

        if (argumentValidator.getDisposition() == 'r') {
            BattlefieldFormationFactory battlefieldFormationFactory = new BattlefieldFormationFactory();
            Battlefield newBattlefield = battlefieldFormationFactory.create(argumentValidator);
            battlefield.setMatrixUnits(newBattlefield.getMatrixUnits());
            memoryStep.getSteps().add(ListMatrixConverter.toList(battlefield.getMatrixUnits()));
        }

        combatUnitPrinter.print(battlefield.getMatrixUnits());
    }
}
