package validation.rules;

public enum ArgumentType {
    NUMBER("n"),
    CHARACTER("c");

    char symbol;

    ArgumentType(String symbol) {
        this.symbol = symbol.toLowerCase().charAt(0);
    }

    public static boolean verifySymbol(char symbol) {
        return symbol == 'n' || symbol == 'c';
    }

    public static String getNameBySymbol(char symbol) {
        return switch (symbol) {
            case 'n' -> "[Number]";
            case 'c' -> "[Character]";
            default -> "[Invalid]";
        };
    }
}
