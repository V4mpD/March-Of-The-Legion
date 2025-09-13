package game.validate;

import game.exception.TroopsExceededBattlefiedException;
import validation.ArgumentValidator;

public class FieldSizeAndTroopsValidate {
    public void validate(ArgumentValidator argumentValidator, int totalTroops) {
        double totalSpaceBattlefied = Math.pow(argumentValidator.getFieldSize(), 2);

        if (totalSpaceBattlefied < totalTroops) {
            System.out.println("***** March of the Legion *****");
            System.out.println(argumentValidator);
            throw new TroopsExceededBattlefiedException("Total troops is bigger than total position on Battlefiel!");
        }
    }
}
