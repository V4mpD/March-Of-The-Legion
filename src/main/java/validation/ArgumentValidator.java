package validation;

import validation.rules.*;

import java.util.ArrayList;
import java.util.List;

public class ArgumentValidator {
    private char algorithm;
    private char type;
    private String[] args;
    private char disposition;
    private char orientation;
    private int fieldSize;

    private List<Integer> units = new ArrayList<>();

    public ArgumentValidator(String[] args) {
        this.args = args;
        validateAlgorithm();
        validateType();
        validateUnits();
        validateOrientation();
        validateFieldSize();
    }

    public char getAlgorithm() {
        return algorithm;
    }

    public char getType() {
        return type;
    }

    public List<Integer> getUnits() {
        return units;
    }

    public char getDisposition() {
        return disposition;
    }

    public char getOrientation() {
        return orientation;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void validateAlgorithm() {
        if (ArgumentAlgorithm.verifySymbol(getValueKey("a").charAt(0))) {
            algorithm = getValueKey("a").charAt(0);
        }
    }

    public void validateType() {
        if (ArgumentType.verifySymbol(getValueKey("t").charAt(0))) {
            type = getValueKey("t").charAt(0);
        }
    }

    public void validateUnits() {
        if (ArgumentUnit.validateFormatUnit(getValueKey("u"))) {
            units = ArgumentUnit.turnToList(getValueKey("u"));
            disposition = 'u';
        } else if (ArgumentUnit.validateFormatUnit(getValueKey("r"))) {
            units = ArgumentUnit.turnToList(getValueKey("r"));
            disposition = 'r';
        }
    }

    public void validateOrientation() {
        if (ArgumentOrientation.verifySymbol(getValueKey("o").charAt(0))) {
            orientation = getValueKey("o").charAt(0);
        }
    }

    public void validateFieldSize() {
        if(ArgumentFieldSize.verifyRangeFieldSize(ArgumentFieldSize.getIntValue(getValueKey("f")))){
            fieldSize = ArgumentFieldSize.getIntValue(getValueKey("f"));
        }
        else {
            fieldSize = 5;
        }
    }

    public String getValueKey(String key) {
        for (String arg : args) {
            String[] argsList = arg.split("=");
            String currentKey = argsList[0];

            if (currentKey.equals(key)) {
                if (argsList.length == 1) {
                    return "Invalid";
                } else {
                    return argsList[1];
                }
            }
        }
        return key;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Algorithm: ").append(ArgumentAlgorithm.getNameBySymbol(getAlgorithm())).append("\n")
                .append("Type: ").append(ArgumentType.getNameBySymbol(getType())).append("\n")
                .append("Troops: ").append(ArgumentUnit.getValueUnit(getUnits())).append("\n")
                .append("Orientation: ").append(ArgumentOrientation.getNameBySymbol(getOrientation())).append("\n")
                .append("Battlefield: ").append("[").append(this.getFieldSize()).append(" x ").append(this.getFieldSize()).append("]").append("\n");

        return sb.toString();
    }

}
