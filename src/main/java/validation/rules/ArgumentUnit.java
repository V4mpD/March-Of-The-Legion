package validation.rules;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArgumentUnit {
    public static boolean validateFormatUnit(String unit){
        return unit.matches("^\\d+(,\\d+){4}$");
    }

    public static List<Integer> turnToList(String unit){
        return Arrays.stream(unit.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String getValueUnit(List<Integer> units){
        int sum = units.stream().mapToInt(Integer::intValue).sum();
        return (units == null || units.isEmpty()) ? "[Invalid]" : String.valueOf(sum);
    }
}
