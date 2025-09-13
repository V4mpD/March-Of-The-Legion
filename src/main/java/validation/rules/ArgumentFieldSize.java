package validation.rules;

public class ArgumentFieldSize {

    public ArgumentFieldSize() {
    }

    public static int getIntValue(String value) {
        int size = 0;

        if (value.equals("Invalid")) {
            size = 10;
        }
        else {
            try {
                size = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("The parameter value 'f' must be a integer");
            }
        }

        return size;
    }

    public static boolean verifyRangeFieldSize(int size) {
        return size >= 5 && size <= 1000;
    }

}
